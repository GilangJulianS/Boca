package com.gilang.boca.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilang.boca.R;
import com.gilang.boca.customclass.NonSwipeablePager;

public class SelectTimeFragment extends Fragment {

	public SelectTimeFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_select_time, container, false);
		return rootView;
	}

}
