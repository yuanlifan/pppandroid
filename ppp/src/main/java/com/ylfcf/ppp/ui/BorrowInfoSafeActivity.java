package com.ylfcf.ppp.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ylfcf.ppp.R;
import com.ylfcf.ppp.adapter.ProductDataAdapter;
import com.ylfcf.ppp.adapter.ProductDataAdapter2;
import com.ylfcf.ppp.async.AsyncBorrowInfoSafe;
import com.ylfcf.ppp.async.AsyncCurrentUserHasInvest;
import com.ylfcf.ppp.async.AsyncCurrentUserInvest;
import com.ylfcf.ppp.async.AsyncLoanRecord;
import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.entity.BorrowInfoSafeInfo;
import com.ylfcf.ppp.entity.ProjectCailiaoInfo;
import com.ylfcf.ppp.entity.ProjectInfo;
import com.ylfcf.ppp.inter.Inter;
import com.ylfcf.ppp.util.SettingsManager;
import com.ylfcf.ppp.widget.GridViewWithHeaderAndFooter;
import com.ylfcf.ppp.widget.LoadingDialog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class BorrowInfoSafeActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout mLl_back;
    private TextView mTopTitleTV;
    private GridViewWithHeaderAndFooter mSuperGridView;
    private boolean isInvested;
    private LayoutInflater layoutInflater;
    private ProductDataAdapter2 adapter;
    private String mId;
    private BorrowInfoSafeInfo mSafeInfo;
    private ArrayList<ProjectCailiaoInfo> mCailiaoListMark = new ArrayList<ProjectCailiaoInfo>();
    private static final int REQUEST_ASSC_WHAT = 9901;
    private TextView mTv_measures;
    private TextView mTv_repay_from;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what) {
                case REQUEST_ASSC_WHAT:
                    requestBorrowSafeInfo();
                    break;
            }
        }
    };
    private LinearLayout mLl_head_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_info_safe);
        mId = getIntent().getStringExtra("id");
        if(mId == null) {
            return;
        }
        initView();
        initData();
    }

    private void initView() {
        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        mLl_back = (LinearLayout)findViewById(R.id.common_topbar_left_layout);
        mLl_back.setOnClickListener(this);
        mTopTitleTV = (TextView)findViewById(R.id.common_page_title);
        mTopTitleTV.setText("安全保障");
        mSuperGridView = (GridViewWithHeaderAndFooter) findViewById(R.id.product_data_gv);
        mSuperGridView.setVisibility(View.VISIBLE);
        View headView = layoutInflater.inflate(R.layout.top_text_invest_layout, null);
        mLl_head_view = headView.findViewById(R.id.ll_head_view);
        mTv_measures = headView.findViewById(R.id.tv_measures);
        mTv_repay_from = headView.findViewById(R.id.tv_repay_from);
        mSuperGridView.addHeaderView(headView);
        mSuperGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(BorrowInfoSafeActivity.this,ProductDataDetailsActivity.class);
                intent.putExtra("cailiao_list",mCailiaoListMark);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        initAdapter();
    }

    private void initAdapter() {
        //设置adapter
        adapter = new ProductDataAdapter2(BorrowInfoSafeActivity.this, layoutInflater);
        mSuperGridView.setAdapter(adapter);
    }

    private void initData() {
        requestCurrentUserInvest(SettingsManager.getUserId(getApplicationContext()), mId);
    }

    /**
     * 无码图片
     */
    private void setImageData() {
        if(mCailiaoListMark != null) {
            mCailiaoListMark.clear();
        }
        parseProjectCailiaoMarkImg(mSafeInfo.getYyzz(), "营业执照");
        parseProjectCailiaoMarkImg(mSafeInfo.getTrue_promise_picture(), "真实性承诺函");
        parseProjectCailiaoMarkImg(mSafeInfo.getDanbaohan_nomark(), "担保函");
        parseProjectCailiaoMarkImg(mSafeInfo.getRepo_letter_nomark(), "回购函");
        parseProjectCailiaoMarkImg(mSafeInfo.getConfirm_letter_nomark(), "确认函");
        adapter.setItems(mCailiaoListMark);
    }

    /**
     * 有码图片
     */
    private void setImageDataMark() {
        if(mCailiaoListMark != null) {
            mCailiaoListMark.clear();
        }
        parseProjectCailiaoMarkImg(mSafeInfo.getYyzz_mark(), "营业执照");
        parseProjectCailiaoMarkImg(mSafeInfo.getTrue_promise_picture(), "真实性承诺函");
        parseProjectCailiaoMarkImg(mSafeInfo.getDanbaohan(), "担保函");
        parseProjectCailiaoMarkImg(mSafeInfo.getRepo_letter(), "回购函");
        parseProjectCailiaoMarkImg(mSafeInfo.getConfirm_letter(), "确认函");
        adapter.setItems(mCailiaoListMark);
    }

    /**
     * 解析材料的图片
     * @param
     * @param material
     */
    private void parseProjectCailiaoMarkImg(String material, String title){
        if(material == null || TextUtils.isEmpty(material))
            return;
        Document doc = Jsoup.parse(material);
        Elements ele=doc.getElementsByTag("p");
        if(ele.size() == 1) {
            for (int i = 0; i < ele.size(); i++) {
                Element e = ele.get(i);
                ProjectCailiaoInfo cailiaoInfo = null;
                String imageUrl = e.getElementsByTag("img").attr("src");
                if(imageUrl != null && !"".equals(imageUrl)){
                    cailiaoInfo = new ProjectCailiaoInfo();
                    cailiaoInfo.setImgURL(imageUrl);
                    cailiaoInfo.setTitle(title);
                    mCailiaoListMark.add(cailiaoInfo);
                }
            }
        }else {
            for (int i = 0; i < ele.size(); i++) {
                Element e = ele.get(i);
                ProjectCailiaoInfo cailiaoInfo = null;
                String imageUrl = e.getElementsByTag("img").attr("src");
                if(imageUrl != null && !"".equals(imageUrl)){
                    cailiaoInfo = new ProjectCailiaoInfo();
                    cailiaoInfo.setImgURL(imageUrl);
                    cailiaoInfo.setTitle(title +i);
                    mCailiaoListMark.add(cailiaoInfo);
                }
            }
        }
    }

    /**
     * 判断当前用户是否投资过该标的
     * @param userId
     * @param borrowId
     */
    private void requestCurrentUserInvest(String userId,String borrowId){
        if(mLoadingDialog != null && !isFinishing()){
            mLoadingDialog.show();
        }
        AsyncCurrentUserHasInvest task = new AsyncCurrentUserHasInvest(BorrowInfoSafeActivity.this, userId, borrowId,
                new Inter.OnCommonInter() {
                    @Override
                    public void back(BaseInfo baseInfo) {
                        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
                            mLoadingDialog.dismiss();
                        }
                        if(baseInfo != null){
                            int resultCode = SettingsManager.getResultCode(baseInfo);
                            if(resultCode == 0){
                                isInvested = true;
                            }else{
                                isInvested = false;
                            }
                        }else{
                            isInvested = false;
                        }
                        mHandler.sendEmptyMessage(REQUEST_ASSC_WHAT);
                    }
                });
        task.executeAsyncTask(SettingsManager.FULL_TASK_EXECUTOR);
    }

    private void requestBorrowSafeInfo() {
        if(mLoadingDialog != null && !isFinishing()){
            mLoadingDialog.show();
        }
        AsyncBorrowInfoSafe investTask = new AsyncBorrowInfoSafe(BorrowInfoSafeActivity.this, mId, new Inter.OnCommonInter() {

            @Override
            public void back(BaseInfo baseInfo) {
                if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
                    mLoadingDialog.dismiss();
                }
                if (baseInfo != null) {
                    int resultCode = SettingsManager
                            .getResultCode(baseInfo);
                    if (resultCode == 0) {
                        mSafeInfo = baseInfo.getBorrowInfoSafeInfo();
                        if(mSafeInfo.getMeasures() != null && mSafeInfo.getRepay_from() != null) {
                            mLl_head_view.setVisibility(View.VISIBLE);
                            mTv_measures.setText(mSafeInfo.getMeasures());
                            mTv_repay_from.setText(mSafeInfo.getRepay_from());
                        }
                        if(isInvested) {
                            setImageData();
                        }else {
                            setImageDataMark();
                        }
                    }
                }
            }
        });
        investTask.executeAsyncTask(SettingsManager.FULL_TASK_EXECUTOR);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.common_topbar_left_layout:
                finish();
                break;
        }
    }

}
