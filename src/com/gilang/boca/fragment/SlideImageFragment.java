package com.gilang.boca.fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.gilang.boca.R;

public class SlideImageFragment extends Fragment {

	ImageView image;
	int resource;	
	
	public SlideImageFragment() {
		
	}
	
	public void setImage(int resourceId){
		this.resource = resourceId;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.page_image_slider, container, false);
		image = (ImageView) rootView.findViewById(R.id.imageView1);
		image.setImageResource(resource);
		return rootView;
	}
}
