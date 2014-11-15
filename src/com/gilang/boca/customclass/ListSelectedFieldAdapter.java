package com.gilang.boca.customclass;

import java.util.List;

import com.gilang.boca.R;
import com.gilang.boca.main.DataSelectedField;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListSelectedFieldAdapter extends BaseAdapter {

	List<DataSelectedField> datField;
	private LayoutInflater inflater;
	
	public ListSelectedFieldAdapter(Context context, List<DataSelectedField> datFields) {
		this.datField = datFields;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return datField.size();
	}

	@Override
	public Object getItem(int position) {
		return datField.get(position);
	}

	@Override
	public long getItemId(int position) {
		datField.get(position).getId();
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.list_select_field, null);
			TextView selectedField = (TextView)convertView.findViewById(R.id.selectField);
			TextView address = (TextView)convertView.findViewById(R.id.address);
			selectedField.setText(datField.get(position).getField());
			address.setText(datField.get(position).getAddress());
		}
		return convertView;
	}

}
