package com.ylfcf.ppp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ylfcf.ppp.R;
import com.ylfcf.ppp.entity.YqyRewardInfo;
import com.ylfcf.ppp.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * 元企盈好友收益
 * Created by Administrator on 2017/11/24.
 */

public class YQYExtensionAdapter extends ArrayAdapter<YqyRewardInfo> {
    private static final int RESOURCE_ID = R.layout.extension_listview_item;
    private Context context;
    private List<YqyRewardInfo> yqyRewardInfoList = null;
    private LayoutInflater layoutInflater = null;

    public YQYExtensionAdapter(Context context) {
        super(context, RESOURCE_ID);
        this.context = context;
        yqyRewardInfoList = new ArrayList<YqyRewardInfo>();
        layoutInflater = (LayoutInflater) context
                .getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 对外方法，动态改变listview的item并进行刷新
     * @param
     */
    public void setItems(List<YqyRewardInfo> list) {
        yqyRewardInfoList.clear();
        if (list != null) {
            yqyRewardInfoList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return yqyRewardInfoList.size();
    }

    @Override
    public YqyRewardInfo getItem(int position) {
        return yqyRewardInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        YqyRewardInfo info = yqyRewardInfoList.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(RESOURCE_ID, null);
            viewHolder.phone = (TextView) convertView
                    .findViewById(R.id.extension_listview_item_phone);
            viewHolder.time = (TextView) convertView
                    .findViewById(R.id.extension_listview_item_time);
            viewHolder.hasInterest = (TextView) convertView
                    .findViewById(R.id.extension_listview_item_hasinterest);
            viewHolder.investMoney = (TextView) convertView
                    .findViewById(R.id.extension_listview_item_investmoney);
            viewHolder.nameTV = (TextView) convertView
                    .findViewById(R.id.extension_listview_item_name);
            viewHolder.interestStartTime = (TextView) convertView
                    .findViewById(R.id.extension_listview_item_interest_starttime);
            viewHolder.collectedTime = (TextView) convertView
                    .findViewById(R.id.extension_listview_item_collected_time);
            viewHolder.borrowNameTV = (TextView) convertView
                    .findViewById(R.id.extension_listview_item_borrowname);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.borrowNameTV.setText(info.getBorrow_name());
        viewHolder.phone.setText(info.getInvest_user_mobile());// 用户名
        viewHolder.time.setText("投资时间: "+info.getInvest_time().split(" ")[0]);
        viewHolder.hasInterest.setText(Util.formatRate(info.getPercentage())+"元");
        viewHolder.investMoney.setText(Util.formatRate(info.getInvest_money())+"元");
        viewHolder.nameTV.setText("姓名: "+Util.hidRealName2(info.getInvest_user_name()));
        viewHolder.interestStartTime.setText(info.getInterest_start_time().split(" ")[0]);
        viewHolder.collectedTime.setText("预计到账时间: "+info.getReturn_time().split(" ")[0]);
        return convertView;
    }

    /**
     * 内部类，定义Item的元素
     * @author Mr.liu
     *
     */
    class ViewHolder {
        TextView phone;
        TextView time;//投资时间
        TextView hasInterest;//提成
        TextView investMoney;//投资金额
        TextView nameTV;
        TextView interestStartTime;//起息时间
        TextView collectedTime;//预计到账时间
        TextView borrowNameTV;//标的名字
    }
}
