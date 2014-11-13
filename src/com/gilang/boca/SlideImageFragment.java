package com.gilang.boca;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.slide_image_page, container, false);
		image = (ImageView) rootView.findViewById(R.id.imageView1);
		image.setImageResource(resource);
		return rootView;
	}

}
