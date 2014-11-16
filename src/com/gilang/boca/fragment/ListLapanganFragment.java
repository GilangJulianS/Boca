package com.gilang.boca.fragment;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gilang.boca.R;
import com.gilang.boca.customclass.ListLapanganAdapter;
import com.gilang.boca.main.DataLapangan;

public class ListLapanganFragment extends Fragment {

	ListView listLapangan;
	ListLapanganAdapter adapter;
	List<DataLapangan> items;
	
	public ListLapanganFragment() {
		items = new ArrayList<DataLapangan>();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_list_lapangan, container, false);
		items.add(new DataLapangan(0, "Batununggal Futsal", "Lapangan A", "Jl. Batununggal Lestari No. 11"));
		items.add(new DataLapangan(1, "Batununggal Futsal", "Lapangan B", "Jl. Batununggal Lestari No. 11"));
		items.add(new DataLapangan(2, "Hiroz Futsal", "Lapangan A", "Jl. Ganeca No. 10"));
		items.add(new DataLapangan(3, "Hiroz Futsal", "Lapangan B", "Jl. Batununggal Lestari No. 11"));
		items.add(new DataLapangan(4, "Hiroz Futsal", "Lapangan C", "Jl. Batununggal Lestari No. 11"));
		items.add(new DataLapangan(5, "Hiroz Futsal", "Lapangan D", "Jl. Batununggal Lestari No. 11"));
		adapter = new ListLapanganAdapter(getActivity(), items);
		listLapangan = (ListView) rootView.findViewById(R.id.listTimeData);
		
		listLapangan.setAdapter(adapter);
		return rootView;
	}

}
