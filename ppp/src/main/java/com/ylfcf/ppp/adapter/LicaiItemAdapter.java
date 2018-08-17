package com.ylfcf.ppp.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ylfcf.ppp.R;
import com.ylfcf.ppp.entity.InvestmentListInfo;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by yjx on 2018/8/1.
 */
public class LicaiItemAdapter extends BaseQuickAdapter<InvestmentListInfo.ListBean, BaseViewHolder> {


    public LicaiItemAdapter(int layoutResId, @Nullable List<InvestmentListInfo.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, InvestmentListInfo.ListBean item) {
        TextView tv_purpose = helper.getView(R.id.tv_purpose);
        ProgressBar actual_raising_money_pb = helper.getView(R.id.actual_raising_money_pb);
        TextView tv_actual_raising_money = helper.getView(R.id.tv_actual_raising_money);
        TextView tv_lihua = helper.getView(R.id.tv_lihua);
        TextView tv_time = helper.getView(R.id.tv_time);
        Button btn_borrow_money_entrance = helper.getView(R.id.btn_borrow_money_entrance);

        if(item.getBorrow_interest() != null ) {
            tv_lihua.setText(item.getBorrow_interest());
        }
        if(item.getUse_purpose() != null) {
            tv_purpose.setText(item.getUse_purpose());
        }
        if(item.getBorrow_period() != null) {
            tv_time.setText(item.getBorrow_period());
        }
        int actual_loan_money = 0;
        int actual_raising_money = 0;
        if(item.getActual_loan_money() != null) {
            actual_loan_money = Integer.parseInt(item.getActual_loan_money());
        }
        if(item.getActual_raising_money() != null) {
            actual_raising_money = Integer.parseInt(item.getActual_raising_money());
        }
        DecimalFormat df = new DecimalFormat("0.0");
        String scale = df.format((float)(actual_raising_money*100)/actual_loan_money);
        if(scale.endsWith("0")) {
            scale = scale.split("\\.")[0];
        }
        actual_raising_money_pb.setMax(actual_loan_money);
        actual_raising_money_pb.setProgress(actual_raising_money);
        tv_actual_raising_money.setText(scale +"%");
        btn_borrow_money_entrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnButtonClickListener != null) {
                    mOnButtonClickListener.onButtonClick(helper.getPosition());
                }
            }
        });
    }

    private onButtonClickListener mOnButtonClickListener;
    public interface onButtonClickListener {
        public void onButtonClick(int position);
    }

    public void setOnButtonClickListener(onButtonClickListener onButtonClickListener) {
        this.mOnButtonClickListener = onButtonClickListener;
    }

}
