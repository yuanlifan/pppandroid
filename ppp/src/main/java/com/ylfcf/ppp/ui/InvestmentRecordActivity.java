package com.ylfcf.ppp.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ylfcf.ppp.R;
import com.ylfcf.ppp.adapter.LoanRecordAdapter;
import com.ylfcf.ppp.adapter.NewInvestmentRecordAdapter;
import com.ylfcf.ppp.adapter.UserInvestRecordAdapter;
import com.ylfcf.ppp.async.AsyncInvestmentRecord;
import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.entity.InvestmentListInfo;
import com.ylfcf.ppp.entity.LoanRecordInfo;
import com.ylfcf.ppp.entity.NewInvestmentRecordInfo;
import com.ylfcf.ppp.inter.Inter;
import com.ylfcf.ppp.util.SettingsManager;

import java.util.ArrayList;
import java.util.List;

public class InvestmentRecordActivity extends BaseActivity implements View.OnClickListener {

    private TextView              nodataText;
    private PullToRefreshListView mPullListView;
    private TextView              mTv_title;
    private LinearLayout          mLl_back;
    private static final int REQUEST_YXBFUNDSDETAILS_SUCCESS = 3502;
    private static final int REQUEST_YXBFUNDSDETAILS_NODATA  = 3503;
    private              int page                            = 0;
    private              int pageSize                        = 20;
    private boolean isLoadMore;
    private List<NewInvestmentRecordInfo.ListBean> mLoanList = new ArrayList<>();
    private NewInvestmentRecordAdapter mRecordAdapter;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case REQUEST_YXBFUNDSDETAILS_SUCCESS:
                    mPullListView.setVisibility(View.VISIBLE);
                    nodataText.setVisibility(View.GONE);
                    BaseInfo baseInfo = (BaseInfo) msg.obj;
                    if (baseInfo != null) {
                        if (!isLoadMore) {
                            mLoanList.clear();
                        }
                        if(baseInfo.getNewInvestmentRecordInfo().getRecordInfoList() != null) {
                            mLoanList.addAll(baseInfo.getNewInvestmentRecordInfo().getRecordInfoList());
                            mRecordAdapter.notifyDataSetChanged();
                        }
                    }
                    isLoadMore = false;
                    mPullListView.onRefreshComplete();
                    break;
                case REQUEST_YXBFUNDSDETAILS_NODATA:
                    if (isLoadMore) {
                        mPullListView.setVisibility(View.VISIBLE);
                        nodataText.setVisibility(View.GONE);
                        isLoadMore = false;
                        mPullListView.onRefreshComplete();
                    } else {
                        mPullListView.setVisibility(View.GONE);
                        nodataText.setVisibility(View.VISIBLE);
                    }
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment_record);
        initView();
    }

    private void initView() {
        mLl_back = (LinearLayout) findViewById(R.id.common_topbar_left_layout);
        mTv_title = (TextView) findViewById(R.id.common_page_title);
        mLl_back.setOnClickListener(this);
        mTv_title.setText("投资记录");
        mPullListView = (PullToRefreshListView) findViewById(R.id.funds_details_yxb_fragment_pull_refresh_list);
        mPullListView.setMode(PullToRefreshBase.Mode.BOTH);
        nodataText = (TextView) findViewById(R.id.funds_details_yxb_nodata_text);
        mPullListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshData();
                    }
                }, 1000L);
            }

            @Override
            public void onPullUpToRefresh(
                    PullToRefreshBase<ListView> refreshView) {
                //上拉加载更多
                page++;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isLoadMore = true;
                        onLoadMore();
                    }
                }, 1000L);
            }
        });
        initAdapter();
        refreshData();
    }

    private void refreshData() {
        AsyncInvestmentRecord asyncRecordList = new AsyncInvestmentRecord(InvestmentRecordActivity.this,
                SettingsManager.getUserId(getApplicationContext()), String.valueOf(page), String.valueOf(pageSize), new Inter.OnCommonInter() {
            @Override
            public void back(BaseInfo baseInfo) {
                if (baseInfo != null) {
                    int resultCode = SettingsManager
                            .getResultCode(baseInfo);
                    if (resultCode == 0) {
                        if (baseInfo.getNewInvestmentRecordInfo().getRecordInfoList().size() == 0) {
                            Message msg = handler.obtainMessage(REQUEST_YXBFUNDSDETAILS_NODATA);
                            msg.obj = baseInfo;
                            handler.sendMessage(msg);
                        } else {
                            Message msg = handler.obtainMessage(REQUEST_YXBFUNDSDETAILS_SUCCESS);
                            msg.obj = baseInfo;
                            handler.sendMessage(msg);
                        }
                    } else {
                        Message msg = handler.obtainMessage(REQUEST_YXBFUNDSDETAILS_NODATA);
                        msg.obj = baseInfo.getMsg();
                        handler.sendMessage(msg);
                    }
                }else {
                    Message msg = handler.obtainMessage(REQUEST_YXBFUNDSDETAILS_NODATA);
                    msg.obj = baseInfo.getMsg();
                    handler.sendMessage(msg);
                }
            }
        });
        asyncRecordList.executeAsyncTask(SettingsManager.FULL_TASK_EXECUTOR);
    }

    private void onLoadMore() {
        AsyncInvestmentRecord asyncRecordList = new AsyncInvestmentRecord(InvestmentRecordActivity.this,
                SettingsManager.getUserId(getApplicationContext()), String.valueOf(page), String.valueOf(pageSize), new Inter.OnCommonInter() {
            @Override
            public void back(BaseInfo baseInfo) {
                if (baseInfo != null) {
                    int resultCode = SettingsManager
                            .getResultCode(baseInfo);
                    if (resultCode == 0) {
                        Message msg = handler.obtainMessage(REQUEST_YXBFUNDSDETAILS_SUCCESS);
                        msg.obj = baseInfo;
                        handler.sendMessage(msg);
                    } else {
                        Message msg = handler.obtainMessage(REQUEST_YXBFUNDSDETAILS_NODATA);
                        msg.obj = baseInfo.getMsg();
                        handler.sendMessage(msg);
                    }
                }
            }
        });
        asyncRecordList.executeAsyncTask(SettingsManager.FULL_TASK_EXECUTOR);
    }

    private void initAdapter() {
        mRecordAdapter = new NewInvestmentRecordAdapter(InvestmentRecordActivity.this, mLoanList);
        mPullListView.setAdapter(mRecordAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_topbar_left_layout:
                finish();
                break;
            default:
                break;
        }
    }

}
