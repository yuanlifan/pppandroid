package com.ylfcf.ppp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ylfcf.ppp.R;

public class InvestmentActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLl_back;
    private Button mBtn_entrance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment);
        mLl_back = (LinearLayout) findViewById(R.id.common_topbar_left_layout);
        mBtn_entrance = (Button) findViewById(R.id.btn_borrow_money_entrance);
        if (mLl_back != null) {
            mLl_back.setOnClickListener(this);
        }
        if (mBtn_entrance != null) {
            mBtn_entrance.setOnClickListener(this);
        }

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.common_topbar_left_layout:
                finish();
                break;
            case R.id.btn_borrow_money_entrance:
            // 从SettingsManager中读取密码，如果为空意味着没有登录。
			boolean isLogin = !com.ylfcf.ppp.util.SettingsManager.getLoginPassword(
					InvestmentActivity.this).isEmpty()
					&& !com.ylfcf.ppp.util.SettingsManager.getUser(InvestmentActivity.this)
							.isEmpty();
			// 1、检测是否已经登录
			if (isLogin) {
				//判断是否实名绑卡
				checkIsVerify("投资");
			} else {
				// 未登录，跳转到登录页面
				android.content.Intent intent = new android.content.Intent();
				intent.setClass(InvestmentActivity.this, LoginActivity.class);
				startActivity(intent);
			}
			break;
        }

    }

    /**
	 * 验证用户是否已经认证
	 * @param type “充值”,“提现”
	 */
	private void checkIsVerify(final String type){
		mBtn_entrance.setEnabled(false);
		com.ylfcf.ppp.util.RequestApis.requestIsVerify(InvestmentActivity.this, com.ylfcf.ppp.util.SettingsManager.getUserId(getApplicationContext()), new com.ylfcf.ppp.inter.Inter.OnIsVerifyListener() {
			@Override
			public void isVerify(boolean flag, Object object) {
				if(flag){
					//用户已经实名
					android.content.Intent intent = new android.content.Intent();
//					intent.putExtra("PRODUCT_INFO", mProductInfo);
					intent.setClass(InvestmentActivity.this, BidWDYActivity.class);
					startActivity(intent);
				}else{
					//用户没有实名
					android.content.Intent intent = new android.content.Intent(InvestmentActivity.this,UserVerifyActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("type", type);
//					bundle.putSerializable("PRODUCT_INFO", mProductInfo);
					intent.putExtra("bundle", bundle);
					startActivity(intent);
				}
				mBtn_entrance.setEnabled(true);
			}
			@Override
			public void isSetWithdrawPwd(boolean flag, Object object) {
			}
		});
	}

}
