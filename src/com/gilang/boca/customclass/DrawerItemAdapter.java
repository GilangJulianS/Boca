package com.gilang.boca.customclass;

import java.util.ArrayList;
import java.util.List;

import com.gilang.boca.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DrawerItemAdapter extends BaseAdapter {

	private static final int HEADER_ITEM = 0;
	private static final int LIST_ITEM = 1;
	private List<String> items;
	private List<Integer> headerItemId;
	
	private LayoutInflater inflater;

	public DrawerItemAdapter(Context context) {
		items = new ArrayList<String>();
		headerItemId = new ArrayList<>();
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void addItem(String item){
		items.add(item);
		notifyDataSetChanged();
	}
	
	public void addHeader(String header){
		items.add(header);
		headerItemId.add(items.size() - 1);
		notifyDataSetChanged();
	}
	
	@Override
	public boolean isEnabled(int position){
		if(headerItemId.contains(position))
			return false;
		return true;
	}
	
	@Override
	public int getItemViewType(int position){
		if(headerItemId.contains(position))
			return HEADER_ITEM;
		return LIST_ITEM;
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
		int type = getItemViewType(position);
		if(convertView == null){
			holder = new ViewHolder();
			switch(type){
			case HEADER_ITEM:
					convertView = inflater.inflate(R.layout.drawer_header, null);
					holder.textView = (TextView)convertView.findViewById(R.id.text1);
					break;
			case LIST_ITEM:
					convertView = inflater.inflate(R.layout.drawer_item, null);
					holder.textView = (TextView)convertView.findViewById(R.id.text1);
					break;		
			}
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder)convertView.getTag();
		}
		holder.textView.setText(items.get(position));
		return convertView;
	}
	
	public static class ViewHolder {
		public TextView textView;
	}

}
