package com.ylfcf.ppp.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by yjx on 2018/8/1.
 */
public class LicaiItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public LicaiItemAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
