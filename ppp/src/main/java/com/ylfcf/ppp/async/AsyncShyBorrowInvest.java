package com.ylfcf.ppp.async;

import android.content.Context;

import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.inter.Inter.OnCommonInter;
import com.ylfcf.ppp.parse.JsonParseCommon;
import com.ylfcf.ppp.parse.JsonParseInvestmentDetail;
import com.ylfcf.ppp.util.BackType;
import com.ylfcf.ppp.util.HttpConnection;
import com.ylfcf.ppp.util.URLGenerator;

/**
 * 投资列表页面
 *
 * Created by yjx on 2018/8/13.
 */
public class AsyncShyBorrowInvest extends AsyncTaskBase {

    private Context  context;
    private BaseInfo baseInfo;
    private String borrow_id;
    private String invest_user_id;
    private String money;
    private String invest_from;
    private OnCommonInter onCommonInter;

    public AsyncShyBorrowInvest(Context context, String borrow_id, String invest_user_id, String money,
                                String invest_from,OnCommonInter onCommonInter) {
        this.context = context;
        this.borrow_id =  borrow_id;
        this.invest_user_id =  invest_user_id;
        this.money =  money;
        this.invest_from =  invest_from;
        this.onCommonInter = onCommonInter;
    }

    @Override
    protected String doInBackground(String... params) {
        String url[] = null;
        String result = null;
        try {
            url = URLGenerator.getInstance().requestShyInvest(borrow_id, invest_user_id, money, invest_from);
            if (result == null) {
                result = HttpConnection.postConnection(url[0], url[1]);
            }
            if (result == null) {
                result = BackType.FAILE;
            } else {
                baseInfo = JsonParseCommon.parseData(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = BackType.ERROR;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (isCancelled()) {
            return;
        }
        if (BackType.ERROR.equals(result)) {
            // 访问错误
            onCommonInter.back(null);
        } else if (BackType.FAILE.equals(result)) {
            // 获取失败
            onCommonInter.back(null);
        } else {
            // 获取成功
            onCommonInter.back(baseInfo);
        }
    }

}
