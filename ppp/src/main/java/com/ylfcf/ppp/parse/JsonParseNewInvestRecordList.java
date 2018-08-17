package com.ylfcf.ppp.parse;

import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.entity.InvestRecordInfo;
import com.ylfcf.ppp.entity.LoanRecordInfo;
import com.ylfcf.ppp.entity.NewInvestmentRecordInfo;
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
public class JsonParseNewInvestRecordList {
	private BaseInfo                               baseInfo;
	private NewInvestmentRecordInfo                         pageInfo;
	private List<NewInvestmentRecordInfo.ListBean> mNewInvestmentRecordInfo;
	
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	private void parseList(String data){
		mNewInvestmentRecordInfo = new ArrayList<NewInvestmentRecordInfo.ListBean>();
		try {
			JSONArray jsonArray = new JSONArray(data);
			int size = jsonArray.length();
			for(int i=0;i<size;i++){
				JSONObject object = jsonArray.getJSONObject(i);
				NewInvestmentRecordInfo.ListBean info = (NewInvestmentRecordInfo.ListBean) MainJson.fromJson(NewInvestmentRecordInfo.ListBean.class, object);
				mNewInvestmentRecordInfo.add(info);
			}
			pageInfo.setRecordInfoList(mNewInvestmentRecordInfo);
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
				pageInfo = (NewInvestmentRecordInfo)MainJson.fromJson(NewInvestmentRecordInfo.class, object);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			parseList(pageInfo.getList());
			baseInfo.setNewInvestmentRecordInfo(pageInfo);
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
		JsonParseNewInvestRecordList jsonParse = new JsonParseNewInvestRecordList();
		jsonParse.parseMain(result);
		return jsonParse.getBaseInfo();
	}

}
