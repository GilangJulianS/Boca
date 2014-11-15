package com.gilang.boca.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.gilang.boca.R;
import com.gilang.boca.customclass.ListSelectedFieldAdapter;
import com.gilang.boca.main.DataField;

public class FieldSelectFragment extends Fragment {
	
	Spinner spinner;
	ListView listView;
	View rootView;
	
	public FieldSelectFragment(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_select_field, container, false);
		spinner = (Spinner)rootView.findViewById(R.id.spinnerCity);
		String[] cities = {"Bandung", "Bekasi", "Jakarta", "Surabaya"}; 
		ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,cities); 
		spinner.setAdapter(adapter);
		listView = (ListView)rootView.findViewById(R.id.listView1);
		
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				List<DataField> datLap = new ArrayList<>();
				datLap.add(new DataField(0,"Futsal 76",0, "Jl. Blabla 1 Bandung Setengah selatan setengah barat","phone","price"));
				datLap.add(new DataField(1,"Queen Futsal",0, "Jl. Blabla 1 Bandung Setengah selatan setengah barat","phone","price"));
				datLap.add(new DataField(2,"YPKP Futsal",0, "Jl. Blabla 1 Bandung Setengah selatan setengah barat","phone","price"));
				datLap.add(new DataField(3,"Futsal", 0,"Jl. Blabla 1 Bandung Setengah selatan setengah barat","phone","price"));
				ListSelectedFieldAdapter adapter = new ListSelectedFieldAdapter(getActivity(), datLap);
				listView.setAdapter(adapter);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				new FieldDialogFragment(new DataField(0, "Queen", R.drawable.field_image, 
						"Jl. Bandung Iyaa", "08980980", "Rp 900.000 - Rp 1.000.000.000"))
				.show(getFragmentManager(), "MyDialog");
			}
		});
		
		return rootView;
	}
	
}
