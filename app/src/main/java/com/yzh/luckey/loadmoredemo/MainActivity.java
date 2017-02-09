package com.yzh.luckey.loadmoredemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yzh.luckey.adapter.MsgViewPagerAdapter;
import com.yzh.luckey.fragment.AlartMsgFragment;
import com.yzh.luckey.fragment.SystemMsgFragment;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private ViewPager msgvp;
    private TabLayout tabLayout;
    private String[] tabs = {"系统消息", "报警消息"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        msgvp = (ViewPager) findViewById(R.id.msg_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.msg_tablayout);
        initViewpager(msgvp);
        tabLayout.setOnTabSelectedListener(this);
//        msgvp.setOffscreenPageLimit(1);
        //此处的方法是为了页面和标题联动
        tabLayout.setupWithViewPager(msgvp);
        tabLayout.getTabAt(0).select();
    }

    private void initViewpager(ViewPager msgvp) {
        MsgViewPagerAdapter adapter = new MsgViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SystemMsgFragment(), tabs[0]);
        adapter.addFragment(new AlartMsgFragment(), tabs[1]);
//        adapter.addFragment(new AlertMsgFragment(), tabs[2]);
        msgvp.setAdapter(adapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
