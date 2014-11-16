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
import com.gilang.boca.main.DataField;

public class ListSelectedFieldAdapter extends BaseAdapter {

	List<DataField> datField;
	private LayoutInflater inflater;
	
	public ListSelectedFieldAdapter(Context context, List<DataField> datFields) {
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
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.list_select_field, parent, false);
			TextView selectedField = (TextView)convertView.findViewById(R.id.selectField);
			TextView address = (TextView)convertView.findViewById(R.id.address);
			selectedField.setText(datField.get(position).getFieldName());
			address.setText(datField.get(position).getFieldAddress());
			
		}
		return convertView;
	}

}
