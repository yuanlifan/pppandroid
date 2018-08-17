package com.ylfcf.ppp.parse;

import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.entity.BorrowInfoSafeInfo;
import com.ylfcf.ppp.entity.InvestmentDetail;
import com.ylfcf.ppp.entity.InvestmentListInfo;
import com.ylfcf.ppp.util.MainJson;
import com.ylfcf.ppp.util.SettingsManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 商汇易安全保障
 * @author Administrator
 *
 */
public class JsonParseBorrowInfoSafe {
	private BaseInfo baseInfo;
	private BorrowInfoSafeInfo mSafeInfo;

	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	private void parsePageInfo(String data){
//		JSONObject object = null;
//		try {
//			object = new JSONObject(data);
//		} catch (Exception e) {
//		}
//
//		if(object != null) {
//			try {
//				mSafeInfo = (BorrowInfoSafeInfo)MainJson.fromJson(BorrowInfoSafeInfo.class, object);
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//			baseInfo.setBorrowInfoSafeInfo(mSafeInfo);
//		}
		try {
			JSONArray jsonArray = new JSONArray(data);
			JSONObject object = jsonArray.getJSONObject(0);
			mSafeInfo = (BorrowInfoSafeInfo) MainJson.fromJson(BorrowInfoSafeInfo.class, object);
			baseInfo.setBorrowInfoSafeInfo(mSafeInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * @param result
	 * @throws Exception
	 */
	public void parseMain(String result) throws Exception{
		JSONObject object = null;
		try {
			object = new JSONObject(result);
		} catch (Exception e) {
		}
		
		if(object != null) {
			baseInfo = (BaseInfo)MainJson.fromJson(BaseInfo.class, object);
			int resultCode = SettingsManager.getResultCode(baseInfo);
			if(resultCode == 0){
				parsePageInfo(baseInfo.getMsg());
			}
		}
	}
	
	/**
	 * 解析调用接口
	 * @param result
	 * @return
	 * @throws JSONException
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static BaseInfo parseData(String result) throws Exception {
		JsonParseBorrowInfoSafe jsonParse = new JsonParseBorrowInfoSafe();
		jsonParse.parseMain(result);
		return jsonParse.getBaseInfo();
	}

}
