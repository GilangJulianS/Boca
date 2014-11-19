package com.gilang.boca.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.gilang.boca.R;
import com.gilang.boca.main.MainActivity;

public class ConfirmationFragment extends Fragment {

	EditText textNoBooking, textBankAsal, textNamaPemilik, textNominal;
	Spinner bankTujuan;
	String[] items = {"BNI", "BRI", "Mandiri", "BCA"};
	ActionBarDrawerToggle toggle;
	
	public ConfirmationFragment() {
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_confirmation, container, false);
		textNoBooking = (EditText) rootView.findViewById(R.id.editText1);
		textBankAsal = (EditText) rootView.findViewById(R.id.editText2);
		textNamaPemilik = (EditText) rootView.findViewById(R.id.editText3);
		textNominal = (EditText) rootView.findViewById(R.id.editText4);
		bankTujuan = (Spinner) rootView.findViewById(R.id.spinner1);
		ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
		bankTujuan.setAdapter(adapter);
		return rootView;
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		toggle = ((MainActivity)activity).getDrawer().getToggle();
		toggle.setDrawerIndicatorEnabled(false);
	}
	
	@Override
	public void onDetach(){
		super.onDetach();
		toggle.setDrawerIndicatorEnabled(true);
	}

}
