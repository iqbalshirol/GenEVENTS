package com.hackathon.genevents;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hackathon.genevents.modal.GetEventResponce;
import com.hackathon.genevents.modal.GetEventsDTO;

import java.util.List;


public class EventsAdapter extends ArrayAdapter<GetEventResponce> {

    private final Context context;
    private final String type;


    public EventsAdapter(final Context context, final int resourceId, final List<GetEventResponce> items, String type) {
        super(context, resourceId, items);
        this.context = context;
        this.type = type;
    }

    public View getView(final int position, final View convertView, final ViewGroup parent) {


        final GetEventResponce rowItem = getItem(position);


        final LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);


        View view = mInflater.inflate(R.layout.item_details, null);

        TextView txtDonarName = (TextView) view.findViewById(R.id.tv_donor_name);
        TextView txtDonarTime = (TextView) view.findViewById(R.id.tv_item_schedule_time);
        TextView txtDonarAddress = (TextView) view.findViewById(R.id.tv_item_addres);


        txtDonarName.setText(rowItem.getEventName());
        txtDonarTime.setText("8-9 AM");
        txtDonarAddress.setText(rowItem.getEventDesc());


        return view;
    }


}

