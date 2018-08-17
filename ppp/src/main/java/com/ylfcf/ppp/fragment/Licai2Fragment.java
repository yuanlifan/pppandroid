package com.ylfcf.ppp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ylfcf.ppp.R;
import com.ylfcf.ppp.adapter.LicaiItemAdapter;
import com.ylfcf.ppp.async.AsyncInvestmentList;
import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.entity.InvestmentListInfo;
import com.ylfcf.ppp.inter.Inter;
import com.ylfcf.ppp.ptr.PtrClassicFrameLayout;
import com.ylfcf.ppp.ptr.PtrDefaultHandler;
import com.ylfcf.ppp.ptr.PtrFrameLayout;
import com.ylfcf.ppp.ptr.PtrHandler;
import com.ylfcf.ppp.ui.InvestmentActivity;
import com.ylfcf.ppp.ui.MainFragmentActivity;
import com.ylfcf.ppp.util.SettingsManager;
import com.ylfcf.ppp.view.CustomTopChooseLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Licai2Fragment extends BaseFragment implements CustomTopChooseLayout.OnChooseClickListener, LicaiItemAdapter.onButtonClickListener, BaseQuickAdapter.OnItemClickListener {

    private PtrClassicFrameLayout mRefreshView;
    private RecyclerView mRecyclerView;
    private List<InvestmentListInfo.ListBean> mList = new ArrayList<>();
    private LicaiItemAdapter     mLicaiItemAdapter;
    private MainFragmentActivity mainActivity;
    private CustomTopChooseLayout mChooseLayout;
    private String order_by = "";
    private String sort = "ASC";
    private int page = 0;

    /**
     * 创建当前Fragment的实例对象
     * @param position
     * @return
     */
    public static android.support.v4.app.Fragment newInstance(int position) {
        Licai2Fragment f = new Licai2Fragment();
        Bundle args = new Bundle();
        args.putInt("num", position);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_licai2, container, false);
        findViews(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initreFreshLayout();
        mLicaiItemAdapter = new LicaiItemAdapter(R.layout.item_licai_layout, mList);
        mLicaiItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,InvestmentActivity.class));
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mLicaiItemAdapter);
        mChooseLayout.setOnChooseClickListener(this);
        mLicaiItemAdapter.setEnableLoadMore(true);
        mLicaiItemAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page++;
                loadmoreInvestList();
            }
        }, mRecyclerView);
        mLicaiItemAdapter.setOnButtonClickListener(this);
        mLicaiItemAdapter.setOnItemClickListener(this);
        requestInvestList();
    }

    private void initreFreshLayout() {
        mRefreshView.setLastUpdateTimeRelateObject(this);
        mRefreshView.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                page = 0;
                requestInvestList();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mRecyclerView, header);//下拉刷新时布局显示完整
            }
        });
        mRefreshView.setResistance(1.7f);
        mRefreshView.setRatioOfHeaderHeightToRefresh(1.2f);
        mRefreshView.setDurationToClose(200);
        mRefreshView.setDurationToCloseHeader(1000);
        // default is false
        mRefreshView.setPullToRefresh(false);
        // default is true
        mRefreshView.setKeepHeaderWhenRefresh(true);
    }

    private void findViews(View rootView) {
        //编辑控件
        mRefreshView = rootView.findViewById(R.id.licai_fragment_refresh_layout);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        TextView title = rootView.findViewById(R.id.common_page_title);
        LinearLayout linearLayout = rootView.findViewById(R.id.common_topbar_left_layout);
        mChooseLayout = rootView.findViewById(R.id.choose_layout);
        title.setText("商汇易");
        linearLayout.setVisibility(View.GONE);
    }

    /**
     * 投资列表 ---- 取前二十条最新的数据
     *
     */
    private void requestInvestList() {
        mChooseLayout.setClickable(false);
        AsyncInvestmentList investTask = new AsyncInvestmentList(mainActivity,
                String.valueOf(page), String.valueOf(20), order_by, sort,
                new Inter.OnCommonInter() {
                    @Override
                    public void back(BaseInfo baseInfo) {
                        if (baseInfo != null) {
                            int resultCode = SettingsManager
                                    .getResultCode(baseInfo);
                            if (resultCode == 0) {
                                mList.clear();
                                mList.addAll(baseInfo.getInvestmentListInfo().getInvestListData());
                                mLicaiItemAdapter.notifyDataSetChanged();
                                mRecyclerView.smoothScrollToPosition(0);
                            }
                        }
                        mChooseLayout.setClickable(true);
                        mRefreshView.refreshComplete();
                        mRecyclerView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mLicaiItemAdapter.loadMoreComplete();
                            }
                        }, 1000);
                    }
                });
        investTask.executeAsyncTask(SettingsManager.FULL_TASK_EXECUTOR);
    }

    /**
     * 投资列表 ---- 加载更多
     *
     */
    private void loadmoreInvestList() {
        AsyncInvestmentList investTask = new AsyncInvestmentList(mainActivity,
                String.valueOf(page), String.valueOf(20), order_by, sort,
                new Inter.OnCommonInter() {
                    @Override
                    public void back(BaseInfo baseInfo) {
                        mLicaiItemAdapter.loadMoreComplete();
                        if (baseInfo != null) {
                            int resultCode = SettingsManager
                                    .getResultCode(baseInfo);
                            if (resultCode == 0) {
                                mList.addAll(baseInfo.getInvestmentListInfo().getInvestListData());
                                mLicaiItemAdapter.notifyDataSetChanged();
                                if(baseInfo.getInvestmentListInfo().getInvestListData().size() == 0) {
                                    mLicaiItemAdapter.loadMoreEnd();
                                }
                            }
                        }else {
                            mLicaiItemAdapter.loadMoreEnd();
                        }
                    }
                });
        investTask.executeAsyncTask(SettingsManager.FULL_TASK_EXECUTOR);
    }

    @Override
    public void chooseSwitch(int chooseType) {
        page = 0;
        switch(chooseType) {
            case 0:
                order_by = "";
                sort = "ASC";
                break;
            case 1:
                order_by = "borrow_interest";
                sort = "ASC";
                break;
            case 2:
                order_by = "borrow_interest";
                sort = "DESC";
                break;
            case 3:
                order_by = "borrow_period";
                sort = "ASC";
                break;
            case 4:
                order_by = "borrow_period";
                sort = "DESC";
                break;
            default:
                break;
        }
        requestInvestList();
    }

    @Override
    public void onButtonClick(int position) {
        Intent intent = new Intent(mContext, InvestmentActivity.class);
        intent.putExtra("id", mList.get(position).getId());
        startActivity(intent);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(mContext, InvestmentActivity.class);
        intent.putExtra("id", mList.get(position).getId());
        startActivity(intent);
    }

}
