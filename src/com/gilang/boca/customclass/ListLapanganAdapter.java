package com.gilang.boca.customclass;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.gilang.boca.R;
import com.gilang.boca.fragment.ScheduleFragment;
import com.gilang.boca.main.DataLapangan;

public class ListLapanganAdapter extends BaseAdapter {

	List<DataLapangan> items;
	private LayoutInflater inflater;
	
	public ListLapanganAdapter(Context context, List<DataLapangan> items) {
		this.items = items;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_list_lapangan, null);
			holder.name = (TextView)convertView.findViewById(R.id.textView1);
			holder.field = (TextView)convertView.findViewById(R.id.textView2);
			holder.address = (TextView)convertView.findViewById(R.id.textView3);
			holder.button = (Button)convertView.findViewById(R.id.button1);
			holder.button.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ScheduleFragment.pager.setCurrentItem(1);
				}
			});
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText(items.get(position).getName());
		holder.address.setText(items.get(position).getAddress());
		holder.field.setText(items.get(position).getField());
		return convertView;
	}
	
	public static class ViewHolder {
		public TextView name;
		public TextView address;
		public TextView field;
		public Button button;
	}

}
