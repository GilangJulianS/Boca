package com.gilang.boca.customclass;

import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.gilang.boca.R;
import com.gilang.boca.fragment.TimeDialogFragment;
import com.gilang.boca.main.FieldTimeData;

public class ListFieldTimeAdapter extends BaseAdapter {

	LayoutInflater inflater;
	List<FieldTimeData> datField;
	FragmentManager fm;
	
	public ListFieldTimeAdapter() {
	}
	
	public ListFieldTimeAdapter(Context context, List<FieldTimeData> datField){
		this.datField = datField;
		fm = ((ActionBarActivity)context).getSupportFragmentManager();
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return datField.size();
	}

	@Override
	public FieldTimeData getItem(int position) {
		return datField.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.item_field_choose_time, parent, false);
			TextView fieldTime = (TextView)convertView.findViewById(R.id.fieldTimeSchedule);
			TextView fieldTimePrice = (TextView)convertView.findViewById(R.id.fieldTimePrice);
			fieldTime.setText(datField.get(position).getFieldTime());
			fieldTimePrice.setText(datField.get(position).getFieldPrice());
			
			Button bookButton = (Button)convertView.findViewById(R.id.bookButton);
			bookButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					new TimeDialogFragment()
					.show(fm, "MyDialog");
				}
			});
		}
		return convertView;
	}

}
