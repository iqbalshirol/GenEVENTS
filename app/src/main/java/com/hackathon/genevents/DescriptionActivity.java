package com.hackathon.genevents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.genevents.constants.StringConstants;

/**
 * Created by venkatesh.kolla on 12/2/2015.
 */
public class DescriptionActivity extends AppCompatActivity {

    private ImageView slideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        inItHeader();
        TextView name = (TextView) findViewById(R.id.event_name);
        TextView desc = (TextView) findViewById(R.id.event_dese);
        TextView attendThisEvent = (TextView) findViewById(R.id.ll_evet_c);
        name.setText(getIntent().getStringExtra(StringConstants.NAME));
        desc.setText(getIntent().getStringExtra(StringConstants.DESC));
        attendThisEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DescriptionActivity.this, "You successfully added to this event...", Toast.LENGTH_LONG).show();
                DescriptionActivity.this.finish();
            }
        });

    }

    public void inItHeader() {
        TextView headeName = (TextView) findViewById(R.id.header_text);
        ImageView search = (ImageView) findViewById(R.id.notification);
        headeName.setText("Description");
        //search.setImageDrawable(getResources().getDrawable(R.mipmap.broadcast));
        slideMenu = (ImageView) findViewById(R.id.iv_head_back);
        slideMenu.setBackground(getResources().getDrawable(R.mipmap.back_white));
        slideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DescriptionActivity.this.finish();
            }
        });
        search.setBackground(getResources().getDrawable(R.mipmap.broadcast));
    }

}