package com.yzh.luckey.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;

import com.yzh.luckey.base.other.BaseFragment;
import com.yzh.luckey.base.pullRefreshListview.XupListView;
import com.yzh.luckey.loadmoredemo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by appadmin on 2017/2/9.
 */

public class SystemMsgFragment extends BaseFragment implements XupListView.IXListViewListener {
    XupListView xListView;
//    SysMsgAdapter adapter;
    List<String> datas;

    //Handler处理下拉和上滑
    private Handler handler;
    //根据type值判断是刷新，还是加载更多
    int type = 0;
    private int pageNumber = 1;

    @Override
    protected int getContentId() {
        return R.layout.fragment_sys_msg;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
       // super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View v) {
        xListView = (XupListView) v.findViewById(R.id.sys_lv);
        datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("深圳"+i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,datas);
        xListView.setAdapter(adapter);

        xListView.setPullRefreshEnable(true);
        xListView.setPullLoadEnable(true);
        xListView.setAutoLoadEnable(true);
        xListView.setXListViewListener(this);
        xListView.setRefreshTime(getTime());
        //初始化handler
        handler = new Handler();
    }

    private String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }

    @Override
    public void onRefresh() {
        type = 0;
        pageNumber = 1;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //loadDatas();
                onLoad();
            }
        }, 2500);
    }

    @Override
    public void onLoadMore() {
        type = 1;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pageNumber++;
                //loadDatas();
                onLoad();
            }
        }, 2000);
    }

    private void onLoad() {
        xListView.stopRefresh();
        xListView.stopLoadMore();
        xListView.setRefreshTime(getTime());
    }
}
