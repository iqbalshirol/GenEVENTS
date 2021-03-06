package com.hackathon.genevents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by venkatesh.kolla on 12/2/2015.
 */
public class CreateEventActivity extends AppCompatActivity {

    private ImageView slideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        inItHeader();
        EditText name = (EditText) findViewById(R.id.event_name);
        EditText fromdate = (EditText) findViewById(R.id.from_picker);
        EditText todate = (EditText) findViewById(R.id.to_picker);
        EditText venu = (EditText) findViewById(R.id.venu);
        EditText modeoftravel = (EditText) findViewById(R.id.to_mode_of_travel);
        EditText estimatedfee = (EditText) findViewById(R.id.Estimated_fee);
        EditText desc = (EditText) findViewById(R.id.et_description);

    }

    public void inItHeader() {
        TextView headeName = (TextView) findViewById(R.id.header_text);
        ImageView search = (ImageView) findViewById(R.id.notification);
        headeName.setText("Create Event");
        slideMenu = (ImageView) findViewById(R.id.iv_head_back);
        slideMenu.setBackground(getResources().getDrawable(R.mipmap.back_white));
        slideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateEventActivity.this.finish();
            }
        });

        search.setBackground(getResources().getDrawable(R.mipmap.completed_selected));
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateEventActivity.this, "Event created successfully...", Toast.LENGTH_LONG).show();
                CreateEventActivity.this.finish();
            }
        });

    }

}