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
import com.ylfcf.ppp.ptr.PtrClassicFrameLayout;
import com.ylfcf.ppp.ptr.PtrDefaultHandler;
import com.ylfcf.ppp.ptr.PtrFrameLayout;
import com.ylfcf.ppp.ptr.PtrHandler;
import com.ylfcf.ppp.ui.InvestmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Licai2Fragment extends BaseFragment {

    private PtrClassicFrameLayout mRefreshView;
    private RecyclerView mRecyclerView;
    private List<String> mList = new ArrayList<>();
    private LicaiItemAdapter mLicaiItemAdapter;

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
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        mLicaiItemAdapter = new LicaiItemAdapter(R.layout.item_licai_layout, mList);
        mLicaiItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,InvestmentActivity.class));
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mLicaiItemAdapter);
        initreFreshLayout();
    }

    private void initreFreshLayout() {
        mRefreshView.setLastUpdateTimeRelateObject(this);
        mRefreshView.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mRefreshView.refreshComplete();
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
        title.setText("商汇易");
        linearLayout.setVisibility(View.GONE);
    }


}
