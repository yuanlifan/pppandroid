package com.ylfcf.ppp.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ylfcf.ppp.R;

/**
 * Created by yjx on 2018/8/7.
 */
public class CustomTopChooseLayout extends FrameLayout implements View.OnClickListener {

    private RelativeLayout mRel_left;
    private RelativeLayout mRel_center;
    private RelativeLayout mRel_right;
    private View mView1;
    private View mView2;
    private View mView3;
    private TextView mTv_chooser_left;
    private TextView mTv_chooser_center;
    private TextView mTv_chooser_right;

    public CustomTopChooseLayout(Context context) {
        this(context, null);
    }

    public CustomTopChooseLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTopChooseLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.include_ll_top_choose, null);
        mRel_left = view.findViewById(R.id.rel_chooser_left);
        mRel_center = view.findViewById(R.id.rel_chooser_center);
        mRel_right = view.findViewById(R.id.rel_chooser_right);

        mView1 = view.findViewById(R.id.view_bottom1);
        mView2 = view.findViewById(R.id.view_bottom2);
        mView3 = view.findViewById(R.id.view_bottom3);

        mTv_chooser_left = view.findViewById(R.id.tv_chooser_left);
        mTv_chooser_center = view.findViewById(R.id.tv_chooser_center);
        mTv_chooser_right = view.findViewById(R.id.tv_chooser_right);

        mRel_left.setOnClickListener(this);
        mRel_center.setOnClickListener(this);
        mRel_right.setOnClickListener(this);
        this.addView(view);
    }

    private boolean isChoosed1 = false;
    private boolean isChoosed2 = false;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_chooser_left:
                setChooseColor(mRel_left);
                setViewIsVisible(mView1);
                mTv_chooser_left.setTextColor(this.getResources().getColor(R.color.common_topbar_bg_color));
                mTv_chooser_center.setTextColor(this.getResources().getColor(R.color.gray4));
                mTv_chooser_right.setTextColor(this.getResources().getColor(R.color.gray4));

                Drawable commentDrawable3 = getResources().getDrawable(R.drawable.icon_sort_comment);
                commentDrawable3.setBounds(0, 0, commentDrawable3.getMinimumWidth(), commentDrawable3.getMinimumHeight());
                mTv_chooser_center.setCompoundDrawables(null, null, commentDrawable3, null);
                mTv_chooser_right.setCompoundDrawables(null, null, commentDrawable3, null);
                isChoosed1 = false;
                isChoosed2 = false;
                if(mOnChooseClickListener != null) {
                    mOnChooseClickListener.chooseSwitch(0);
                }
                break;
            case R.id.rel_chooser_center:
                setChooseColor(mRel_center);
                setViewIsVisible(mView2);
                mTv_chooser_left.setTextColor(this.getResources().getColor(R.color.gray4));
                mTv_chooser_center.setTextColor(this.getResources().getColor(R.color.common_topbar_bg_color));
                mTv_chooser_right.setTextColor(this.getResources().getColor(R.color.gray4));
                Drawable rightDrawable1 = null;
                if(isChoosed1) {
                    rightDrawable1 = getResources().getDrawable(R.drawable.icon_sort_jiang);
                    isChoosed1 = false;
                    if(mOnChooseClickListener != null) {
                        mOnChooseClickListener.chooseSwitch(2);
                    }
                }else {
                    rightDrawable1 = getResources().getDrawable(R.drawable.icon_sort_sheng);
                    isChoosed1 = true;
                    if(mOnChooseClickListener != null) {
                        mOnChooseClickListener.chooseSwitch(1);
                    }
                }
                rightDrawable1.setBounds(0, 0, rightDrawable1.getMinimumWidth(), rightDrawable1.getMinimumHeight());
                mTv_chooser_center.setCompoundDrawables(null, null, rightDrawable1, null);

                Drawable commentDrawable = getResources().getDrawable(R.drawable.icon_sort_comment);
                commentDrawable.setBounds(0, 0, commentDrawable.getMinimumWidth(), commentDrawable.getMinimumHeight());
                mTv_chooser_right.setCompoundDrawables(null, null, commentDrawable, null);

                isChoosed2 = false;
                break;
            case R.id.rel_chooser_right:
                setChooseColor(mRel_right);
                setViewIsVisible(mView3);
                mTv_chooser_left.setTextColor(this.getResources().getColor(R.color.gray4));
                mTv_chooser_center.setTextColor(this.getResources().getColor(R.color.gray4));
                mTv_chooser_right.setTextColor(this.getResources().getColor(R.color.common_topbar_bg_color));
                Drawable rightDrawable2 = null;
                if(isChoosed2) {
                    rightDrawable2 = getResources().getDrawable(R.drawable.icon_sort_jiang);
                    isChoosed2 = false;
                    if(mOnChooseClickListener != null) {
                        mOnChooseClickListener.chooseSwitch(3);
                    }
                }else {
                    rightDrawable2 = getResources().getDrawable(R.drawable.icon_sort_sheng);
                    isChoosed2 = true;
                    if(mOnChooseClickListener != null) {
                        mOnChooseClickListener.chooseSwitch(4);
                    }
                }
                rightDrawable2.setBounds(0, 0, rightDrawable2.getMinimumWidth(), rightDrawable2.getMinimumHeight());
                mTv_chooser_right.setCompoundDrawables(null, null, rightDrawable2, null);

                Drawable commentDrawable2 = getResources().getDrawable(R.drawable.icon_sort_comment);
                commentDrawable2.setBounds(0, 0, commentDrawable2.getMinimumWidth(), commentDrawable2.getMinimumHeight());
                mTv_chooser_center.setCompoundDrawables(null, null, commentDrawable2, null);

                isChoosed1 = false;
                break;

            default:
                break;
        }
    }

    private void setViewIsVisible(View view) {
        mView1.setVisibility(GONE);
        mView2.setVisibility(GONE);
        mView3.setVisibility(GONE);
        view.setVisibility(VISIBLE);
    }

    private void setChooseColor(RelativeLayout resId) {
        mRel_left.setBackgroundResource(R.color.child_background);
        mRel_center.setBackgroundResource(R.color.child_background);
        mRel_right.setBackgroundResource(R.color.child_background);
        resId.setBackgroundResource(R.color.white);
    }

    private OnChooseClickListener mOnChooseClickListener;

    public interface OnChooseClickListener {
        void chooseSwitch(int chooseType);
    }

    public void setOnChooseClickListener(OnChooseClickListener onChooseClickListener) {
        this.mOnChooseClickListener = onChooseClickListener;
    }

}
