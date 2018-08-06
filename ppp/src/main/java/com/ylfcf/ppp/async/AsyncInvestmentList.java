package com.ylfcf.ppp.async;

import android.content.Context;

import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.parse.JsonParseArticlePageInfo;
import com.ylfcf.ppp.parse.JsonParseInvestmentList;
import com.ylfcf.ppp.util.BackType;
import com.ylfcf.ppp.util.HttpConnection;
import com.ylfcf.ppp.util.URLGenerator;
import com.ylfcf.ppp.inter.Inter.OnCommonInter;

/**
 * 投资列表页面
 *
 * Created by yjx on 2018/8/6.
 */
public class AsyncInvestmentList extends AsyncTaskBase {

    private Context  context;
    private BaseInfo baseInfo;

    private String page;
    private String pageSize;
    private String order_by;
    private String sort;

    private OnCommonInter onCommonInter;

    public AsyncInvestmentList(Context context, String page, String pageSize,
                            String order_by, String sort, OnCommonInter onCommonInter) {
        this.context = context;
        this.page = page;
        this.pageSize = pageSize;
        this.order_by = order_by;
        this.sort = sort;
        this.onCommonInter = onCommonInter;
    }

    @Override
    protected String doInBackground(String... params) {
        String url[] = null;
        String result = null;
        try {
            url = URLGenerator.getInstance().getInvestmentList(order_by, sort,
                    page, pageSize);
            if (result == null) {
                result = HttpConnection.postConnection(url[0], url[1]);
            }

            if (result == null) {
                result = BackType.FAILE;
            } else {
                baseInfo = JsonParseInvestmentList.parseData(result);
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
