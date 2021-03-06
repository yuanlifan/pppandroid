package com.ylfcf.ppp.parse;

import com.ylfcf.ppp.entity.BannerInfo;
import com.ylfcf.ppp.entity.BannerPageInfo;
import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.entity.InvestmentListInfo;
import com.ylfcf.ppp.util.MainJson;
import com.ylfcf.ppp.util.SettingsManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 商汇易列表数据
 * @author Administrator
 *
 */
public class JsonParseInvestmentList {
	private BaseInfo baseInfo;
	private InvestmentListInfo pageInfo;
	private List<InvestmentListInfo.ListBean> bannerInfoList;
	
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	private void parseList(String data){
		bannerInfoList = new ArrayList<InvestmentListInfo.ListBean>();
		try {
			JSONArray jsonArray = new JSONArray(data);
			int size = jsonArray.length();
			for(int i=0;i<size;i++){
				JSONObject object = jsonArray.getJSONObject(i);
				InvestmentListInfo.ListBean info = (InvestmentListInfo.ListBean) MainJson.fromJson(InvestmentListInfo.ListBean.class, object);
				bannerInfoList.add(info);
			}
			pageInfo.setInvestListData(bannerInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void parsePageInfo(String data){
		JSONObject object = null;
		try {
			object = new JSONObject(data);
		} catch (Exception e) {
		}
		
		if(object != null) {
			try {
				pageInfo = (InvestmentListInfo)MainJson.fromJson(InvestmentListInfo.class, object);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			parseList(pageInfo.getList());
			baseInfo.setInvestmentListInfo(pageInfo);
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
		JsonParseInvestmentList jsonParse = new JsonParseInvestmentList();
		jsonParse.parseMain(result);
		return jsonParse.getBaseInfo();
	}

}
