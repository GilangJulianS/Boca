package com.gilang.boca.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * A placeholder fragment containing a simple view.
 */


import com.gilang.boca.R;
import com.gilang.boca.main.MainActivity;
import com.viewpagerindicator.CirclePageIndicator;
/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {
	
	private ViewPager pager;
	private PagerAdapter adapter;
	private static final int NUM_PAGES = 4;
	private CirclePageIndicator titleIndicator;
	private ActionBarDrawerToggle toggle;
	
	public MainFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		
		titleIndicator  = (CirclePageIndicator)rootView.findViewById(R.id.titles);
		pager = (ViewPager)rootView.findViewById(R.id.pager);
		adapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
		pager.setAdapter(adapter);
		titleIndicator.setViewPager(pager);
		return rootView;
	}
	
	 /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	SlideImageFragment fragment = new SlideImageFragment();
            switch(position){
            case 0: fragment.setImage(R.drawable.lapangan1);
            		break;
            case 1: fragment.setImage(R.drawable.lapangan2);
    				break;
            case 2: fragment.setImage(R.drawable.lapangan3);
					break;
            case 3: fragment.setImage(R.drawable.lapangan4);
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
		toggle.setDrawerIndicatorEnabled(true);
	}
}