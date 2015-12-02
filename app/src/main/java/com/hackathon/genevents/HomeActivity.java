package com.hackathon.genevents;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;


/**
 * Created by venkatesh.kolla on 12/2/2015.
 */
public class HomeActivity extends TabActivity {


    private ImageView imgViewmenu;
    private ListView drawerListView;
    private DrawerLayout mDrawerLayout;
    private ImageView slideMenu;
    private FloatingActionButton fab;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabs();
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CreateEventActivity.class));
            }
        });
    }

    private void tabs() {
        // create the TabHost that will contain the Tabs
        final TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);


        TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        tab1.setIndicator(getString(R.string.lbl_all_events));
        tab1.setContent(new Intent(this, AllEventsActivity.class));

        tab2.setIndicator(getString(R.string.lbl_upcomping_events));
        tab2.setContent(new Intent(this, UpComingActivity.class));

        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        setTabColor(tabHost);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                setTabColor(tabHost);
            }
        });
        leftDrawer();
    }

    private void leftDrawer() {
        drawerListView = (ListView) findViewById(R.id.left_drawer);
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.menu_list, drawerListView, false);
        drawerListView.addHeaderView(header, null, false);
        drawerListView.setAdapter(new myAdapter());

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        imgViewmenu = (ImageView) findViewById(R.id.option_menu);
        slideMenu = (ImageView) findViewById(R.id.iv_head_back);
        slideMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Opens the Drawer
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

    }

    class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    public void setTabColor(TabHost tabhost) {
        for (int i = 0; i < tabhost.getTabWidget().getChildCount(); i++) {
            //unselected
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(HomeActivity.this.getResources().getColor(R.color.colorPrimaryDark));
            final TextView tv = (TextView) tabhost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(this.getResources().getColorStateList(android.R.color.darker_gray));
        }
        // selected
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).setBackground(HomeActivity.this.getResources().getDrawable(R.drawable.logo_layers));
        final TextView tv = (TextView) tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).findViewById(android.R.id.title);
        tv.setTextColor(this.getResources().getColorStateList(android.R.color.white));

    }

}