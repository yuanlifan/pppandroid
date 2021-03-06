package com.ylfcf.ppp.async;

import android.content.Context;

import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.inter.Inter.OnCommonInter;
import com.ylfcf.ppp.parse.JsonParseHDPrizeList;
import com.ylfcf.ppp.util.BackType;
import com.ylfcf.ppp.util.HttpConnection;
import com.ylfcf.ppp.util.URLGenerator;
/**
 * 
 * @author Mr.liu
 *
 */
public class AsyncHDPrizeList extends AsyncTaskBase{
	private Context context;

	private String userId;
	private String activeTitle;
	private String pageNo;
	private String pageSize;

	private OnCommonInter mOnCommonInter;

	private BaseInfo baseInfo;

	public AsyncHDPrizeList(Context context, String userId,String activeTitle,
			String pageNo, String pageSize, OnCommonInter mOnCommonInter) {
		this.context = context;
		this.userId = userId;
		this.activeTitle = activeTitle;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.mOnCommonInter = mOnCommonInter;
	}

	@Override
	protected String doInBackground(String... params) {
		String url[] = null;
		String result = null;
		try {
			url = URLGenerator.getInstance().getHDPrizeListURL(userId, activeTitle, pageNo, pageSize);
			if (result == null) {
				result = HttpConnection.postConnection(url[0], url[1]);
			}

			if (result == null) {
				result = BackType.FAILE;
			} else {
				baseInfo = JsonParseHDPrizeList.parseData(result);
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
			mOnCommonInter.back(null);
		} else if (BackType.FAILE.equals(result)) {
			// 获取失败
			mOnCommonInter.back(null);
		} else {
			// 获取成功
			mOnCommonInter.back(baseInfo);
		}
	}

}
