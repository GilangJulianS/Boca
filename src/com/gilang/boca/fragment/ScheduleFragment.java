package com.gilang.boca.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
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
import com.gilang.boca.main.MainActivity;

public class ScheduleFragment extends Fragment {

	private static final int NUM_PAGES = 2;
	public static ImageView headerImage;
	public static NonSwipeablePager pager;
	private PagerAdapter adapter;
	private ActionBarDrawerToggle toggle;
	private MainActivity activity;
	
	public ScheduleFragment(Context context) {
		activity = (MainActivity)context;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);
		headerImage = (ImageView) rootView.findViewById(R.id.imageSelectField);
		pager = (NonSwipeablePager) rootView.findViewById(R.id.pager);
		adapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
		pager.setAdapter(adapter);
		activity.setActivePager(pager);
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
            case 1: fragment = new DataDiriFragment();
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
