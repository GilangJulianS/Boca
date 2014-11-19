package com.gilang.boca.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gilang.boca.R;
import com.gilang.boca.main.MainActivity;

public class DataDiriFragment extends Fragment {

	EditText name;
	EditText id;
	EditText email;
	EditText phone;
	Button buttonSubmit;
	
	public DataDiriFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_data_diri, container, false);
		
		name = (EditText) rootView.findViewById(R.id.selectFieldDate);
		id = (EditText) rootView.findViewById(R.id.editText2);
		email = (EditText) rootView.findViewById(R.id.editText3);
		phone = (EditText) rootView.findViewById(R.id.editText4);
		buttonSubmit = (Button) rootView.findViewById(R.id.bookButton);
		buttonSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Pembelian Berhasil!", Toast.LENGTH_SHORT).show();
				((MainActivity)getActivity()).setActivePager(null);
				((MainActivity)getActivity()).onUpSelected();
			}
		});
		return rootView;
	}

}
