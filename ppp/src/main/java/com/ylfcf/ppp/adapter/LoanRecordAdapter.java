package com.ylfcf.ppp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ylfcf.ppp.R;
import com.ylfcf.ppp.entity.LoanRecordInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * 出借记录列表adapter
 * @author yjx
 *
 */
public class LoanRecordAdapter extends ArrayAdapter<LoanRecordInfo.ListBean>{

	private static final int RESOURCE_ID = R.layout.item_loan_record_listview;
	private Context context;
	private List<LoanRecordInfo.ListBean> mLoanRecordInfo = null;
	private LayoutInflater layoutInflater = null;

	public LoanRecordAdapter(Context context){
		super(context, RESOURCE_ID);
		this.context = context;
		mLoanRecordInfo = new ArrayList<LoanRecordInfo.ListBean>();
		layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}
	
	/**
	 * 对外方法，动态改变listview的item并进行刷新
	 * @param list
	 */
	public void setItems(List<LoanRecordInfo.ListBean> list){
		this.mLoanRecordInfo.clear();
		if(list != null){
			mLoanRecordInfo.addAll(list);
		}
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mLoanRecordInfo.size();
	}

	@Override
	public LoanRecordInfo.ListBean getItem(int position) {
		return mLoanRecordInfo.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		LoanRecordInfo.ListBean info = mLoanRecordInfo.get(position);
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = layoutInflater.inflate(RESOURCE_ID, null);
			viewHolder.tv_number = (TextView)convertView.findViewById(R.id.tv_number);
			viewHolder.tv_title = (TextView)convertView.findViewById(R.id.tv_title);
			viewHolder.tv_time = (TextView)convertView.findViewById(R.id.tv_time);
			viewHolder.tv_money = (TextView)convertView.findViewById(R.id.tv_money);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.tv_number.setText(String.valueOf(position));
		viewHolder.tv_title.setText(info.getUser_name().replace(info.getUser_name().substring(1,info.getUser_name().length()-1),
                "****"));
		viewHolder.tv_time.setText(info.getRaising_period());
		viewHolder.tv_money.setText(info.getMoney() + "元");
		return convertView;
	}
	
	/**
	 * 内部类，定义Item的元素
	 */
	class ViewHolder{
		TextView tv_number;//序列号
		TextView tv_title;//
		TextView tv_time;//投资类型
		TextView tv_money;//可用余额
	}

}
