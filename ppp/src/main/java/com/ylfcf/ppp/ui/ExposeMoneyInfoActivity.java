package com.ylfcf.ppp.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ylfcf.ppp.R;
import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.entity.InvestmentDetail;

import java.io.Serializable;

public class ExposeMoneyInfoActivity extends BaseActivity {

    private InvestmentDetail mDetail_info;
    private TextView mTv_project_name;
    private TextView mTv_project_overview;
    private TextView mTv_borrow_name;
    private TextView mTv_co_id_num;
    private TextView mTv_co_user_name;
    private TextView mTv_co_name;
    private TextView mTv_found_time;
    private TextView mTv_capital;
    private TextView mTv_organization_code;
    private TextView mTv_job_type;
    private TextView mTv_industry;
    private TextView mTv_use_purpose;
    private TextView mTv_salary_monthly;
    private TextView mTv_repayment;
    private TextView mTv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expose_money_info);
        mDetail_info = (InvestmentDetail) getIntent().getSerializableExtra("detail_info");
        initView();
        initData();
    }

    private void initView() {
        LinearLayout back_left = findViewById(R.id.common_topbar_left_layout);
        mTv_title = findViewById(R.id.common_page_title);
        mTv_project_name = findViewById(R.id.tv_project_name);
        mTv_project_overview = findViewById(R.id.tv_project_overview);
        mTv_borrow_name = findViewById(R.id.tv_borrow_name);
        mTv_co_id_num = findViewById(R.id.tv_co_id_num);
        mTv_co_user_name = findViewById(R.id.tv_co_user_name);
        mTv_co_name = findViewById(R.id.tv_co_name);
        mTv_found_time = findViewById(R.id.tv_found_time);
        mTv_capital = findViewById(R.id.tv_capital);
        mTv_organization_code = findViewById(R.id.tv_organization_code);
        mTv_job_type = findViewById(R.id.tv_job_type);
        mTv_industry = findViewById(R.id.tv_industry);
        mTv_use_purpose = findViewById(R.id.tv_use_purpose);
        mTv_salary_monthly = findViewById(R.id.tv_salary_monthly);
        mTv_repayment = findViewById(R.id.tv_repayment);
        back_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
        mTv_title.setText("标的信息披露");
        if(mDetail_info.getProject_name() !=null) {
            mTv_project_name.setText(mDetail_info.getProject_name());
        }

        if(mDetail_info.getProject_overview() !=null) {
            mTv_project_overview.setText(mDetail_info.getProject_overview());
        }

        if(mDetail_info.getBorrow_name() !=null) {
            mTv_borrow_name.setText(mDetail_info.getBorrow_name());
        }

        if(mDetail_info.getCo_id_num() !=null) {
            mTv_co_id_num.setText(mDetail_info.getCo_id_num());
        }

        if(mDetail_info.getCo_user_name() !=null) {
            mTv_co_user_name.setText(mDetail_info.getCo_user_name());
        }

        if(mDetail_info.getCo_name() !=null) {
            mTv_co_name.setText(mDetail_info.getCo_name());
        }

        if(mDetail_info.getFound_time() !=null) {
            mTv_found_time.setText(mDetail_info.getFound_time());
        }

        if(mDetail_info.getCapital() !=null) {
            mTv_capital.setText(mDetail_info.getCapital());
        }

        if(mDetail_info.getOrganization_code() !=null) {
            mTv_organization_code.setText(mDetail_info.getOrganization_code());
        }

        if(mDetail_info.getJob_type() !=null) {
            mTv_job_type.setText(mDetail_info.getJob_type());
        }

        if(mDetail_info.getIndustry() !=null) {
            mTv_industry.setText(mDetail_info.getIndustry());
        }

        if(mDetail_info.getUse_purpose() !=null) {
            mTv_use_purpose.setText(mDetail_info.getUse_purpose());
        }

        if(mDetail_info.getSalary() !=null) {
            mTv_salary_monthly.setText(mDetail_info.getSalary());
        }
        if(mDetail_info.getRepayment() !=null) {
            mTv_repayment.setText(mDetail_info.getRepayment());
        }
//        if(mDetail_info.getSalary() !=null) {
//            mTv_salary_monthly.setText(mDetail_info.getSalary());
//        }
    }

}
