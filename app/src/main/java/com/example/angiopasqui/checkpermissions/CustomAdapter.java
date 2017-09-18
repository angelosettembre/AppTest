package com.example.angiopasqui.checkpermissions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Angiopasqui on 18/09/2017.
 */

public class CustomAdapter extends ArrayAdapter<App> {
    private int resource;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resourceId, List<App> objects) {
        super(context, resourceId, objects);
        resource = resourceId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            Log.d("DEBUG","Inflating view");
            v = inflater.inflate(R.layout.list_app, null);
        }

        App a = getItem(position);
        TextView nameApp;
        ImageView iconApp;

        nameApp = (TextView) v.findViewById(R.id.appName);
        iconApp = (ImageView) v.findViewById(R.id.appIcon);

        nameApp.setText(a.getName());
        iconApp.setImageDrawable(a.getIcon());

        return v;
    }
}
