package com.yzh.luckey.adapter;

import android.content.Context;

import com.yzh.luckey.base.other.AbsBaseAdapter;
import com.yzh.luckey.loadmoredemo.R;

/**
 * Created by appadmin on 2017/2/9.
 */

public class SysMsgAdapter extends AbsBaseAdapter<String>{
    public SysMsgAdapter(Context context) {
        super(context, R.layout.item_sysmsg);
    }

    @Override
    public void bindView(ViewHolder viewHolder, String data) {
        viewHolder.setTextView(R.id.tv_sys_msg,data);
    }
}
