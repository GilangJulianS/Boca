package com.gilang.boca.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gilang.boca.R;
import com.gilang.boca.customclass.NonSwipeablePager;

public class ScheduleFragment extends Fragment {

	private static final int NUM_PAGES = 2;
	private ImageView header;
	private NonSwipeablePager pager;
	private PagerAdapter adapter;
	
	public ScheduleFragment() {
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);
		header = (ImageView) rootView.findViewById(R.id.imageView1);
		pager = (NonSwipeablePager) rootView.findViewById(R.id.pager);
		adapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
		pager.setAdapter(adapter);
		return rootView;
	}
	
	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	Fragment fragment = null;
            switch(position){
            case 0: fragment = new SelectTimeFragment();
            		break;
            case 1: fragment = new SelectTimeFragment();
    				break;
            case 2: fragment = new SelectTimeFragment();
					break;
            case 3: fragment = new SelectTimeFragment();
					break;
            }
            return fragment;
        	
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
