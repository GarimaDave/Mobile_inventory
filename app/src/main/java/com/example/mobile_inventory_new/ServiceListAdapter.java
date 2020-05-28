package com.example.mobile_inventory_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class ServiceListAdapter extends ArrayAdapter<Service> {
    private Context mContext;
    int mresource;

    public ServiceListAdapter(@NonNull Context context, int resource, @NonNull List<Service> objects) {
        super(context, resource, objects);
        this.mContext = mContext;
        mresource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String date1=getItem(position).getDate();
        String quan1=getItem(position).getQuan();
        String desc1=getItem(position).getQuan();
        Service service=new Service(date1,quan1,desc1);
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mresource,parent,false);
        TextView tvdate=(TextView)convertView.findViewById(R.id.textView1000);
        TextView tvquan=(TextView)convertView.findViewById(R.id.textView1001);
        TextView tvdesc=(TextView)convertView.findViewById(R.id.textView1002);
        tvdate.setText(date1);
        tvquan.setText(quan1);
        tvquan.setText(desc1);
        return convertView;
    }
}
