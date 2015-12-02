package com.hackathon.genevents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by venkatesh.kolla on 12/2/2015.
 */
public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        inItHeader();
        TextView name = (TextView) findViewById(R.id.event_name);
        TextView desc = (TextView) findViewById(R.id.event_dese);
        TextView attendThisEvent = (TextView) findViewById(R.id.ll_evet_c);

    }

    public void inItHeader() {
        TextView headeName = (TextView) findViewById(R.id.header_text);
        ImageView search = (ImageView) findViewById(R.id.notification);
        headeName.setText("Description");
        search.setImageDrawable(getResources().getDrawable(R.mipmap.broadcast));
    }

}