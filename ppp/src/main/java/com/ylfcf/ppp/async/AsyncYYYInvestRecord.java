package com.ylfcf.ppp.async;

import android.content.Context;

import com.ylfcf.ppp.entity.BaseInfo;
import com.ylfcf.ppp.inter.Inter.OnCommonInter;
import com.ylfcf.ppp.parse.JsonParseInvestRecordList;
import com.ylfcf.ppp.util.BackType;
import com.ylfcf.ppp.util.HttpConnection;
import com.ylfcf.ppp.util.URLGenerator;
import com.ylfcf.ppp.util.YLFLogger;

/**
 * Ԫ��ӯ��Ͷ�ʼ�¼
 * @author Mr.liu
 *
 */
public class AsyncYYYInvestRecord extends AsyncTaskBase{
	private Context context;

	private String borrowId;
	private String investStatus;
	private String investUserId;
	private String returnStatus;
	private String type;
	private int pageNo;
	private int pageSize;
	private OnCommonInter investRecordListInter;
	private BaseInfo baseInfo;
	
	public AsyncYYYInvestRecord(Context context, String borrowId,
			String investStatus, String investUserId, String returnStatus,String type,int pageNo, int pageSize,
			OnCommonInter investRecordListInter) {
		this.context = context;
		this.borrowId = borrowId;
		this.investStatus = investStatus;
		this.investUserId = investUserId;
		this.returnStatus = returnStatus;
		this.type = type;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.investRecordListInter = investRecordListInter;
	}

	@Override
	protected String doInBackground(String... params) {
		String url[] = null;
		String result = null;
		try {
			url = URLGenerator.getInstance()
					.getYYYInvestRecordURL(borrowId, investStatus, investUserId,
							returnStatus, type, String.valueOf(pageNo), String.valueOf(pageSize));
			if (result == null) {
				result = HttpConnection.postConnection(url[0], url[1]);
			}
			YLFLogger.d("Ԫ��ӯ���Ͷ�ʼ�¼URL:--------------------"+url+"\nԪ��ӯ���Ͷ�ʼ�¼�����"+result);
			if (result == null) {
				result = BackType.FAILE;
			} else {
				baseInfo = JsonParseInvestRecordList
						.parseData(result);
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
			// ���ʴ���
			investRecordListInter.back(null);
		} else if (BackType.FAILE.equals(result)) {
			// ��ȡʧ��
			investRecordListInter.back(null);
		} else {
			// ��ȡ�ɹ�
			investRecordListInter.back(baseInfo);
		}
	}
}