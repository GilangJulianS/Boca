package com.gilang.boca.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.gilang.boca.R;
import com.gilang.boca.fragment.ConfirmationFragment;
import com.gilang.boca.fragment.FieldFragment;
import com.gilang.boca.fragment.MainFragment;
import com.gilang.boca.fragment.NavigationDrawerFragment;
import com.gilang.boca.fragment.ScheduleFragment;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private ViewPager pager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));	
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		switch(position){
		case 0: pager = null;
				fragmentManager.beginTransaction().replace(R.id.container, new MainFragment())
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
				break;
		case 1: pager = null;
				fragmentManager.beginTransaction().replace(R.id.container, new FieldFragment(this))
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
				break;
		case 2: pager = null;
				fragmentManager.beginTransaction().replace(R.id.container, new ScheduleFragment(this))
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
				break;
		case 3: pager = null;
				fragmentManager.beginTransaction().replace(R.id.container, new ConfirmationFragment())
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
				break;
		}		
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == android.R.id.home) {
			if(!mNavigationDrawerFragment.getToggle().isDrawerIndicatorEnabled()){
				onUpSelected();
				return true;
			}
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed(){
		if(!mNavigationDrawerFragment.getToggle().isDrawerIndicatorEnabled())
			onUpSelected();
		else
			super.onBackPressed();
	}
	
	public void onUpSelected(){
		if(pager == null || pager.getCurrentItem() == 0)
			getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment())
				.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
		else
			pager.setCurrentItem(pager.getCurrentItem() - 1);
	}
	
	public NavigationDrawerFragment getDrawer(){
		return mNavigationDrawerFragment;
	}
	
	public void setActivePager(ViewPager pager){
		this.pager = pager;
	}

}
