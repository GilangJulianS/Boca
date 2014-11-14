package com.gilang.boca.fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.gilang.boca.R;

public class SelectTimeFragment extends Fragment {

	DatePickerDialog.OnDateSetListener setDate;
	TimePickerDialog.OnTimeSetListener setTime;
	Calendar calendar;
	EditText textDate;
	EditText textTime;
	Spinner spinner;
	Button buttonSearch;
	
	public SelectTimeFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_select_time, container, false);
		calendar = Calendar.getInstance();
		textDate = (EditText) rootView.findViewById(R.id.editText1);
		textTime = (EditText) rootView.findViewById(R.id.editText2);
		buttonSearch = (Button) rootView.findViewById(R.id.button1);
		textDate.setFocusable(false);
		textTime.setFocusable(false);
		
		setDate = new DatePickerDialog.OnDateSetListener() {

		    @Override
		    public void onDateSet(DatePicker view, int year, int monthOfYear,
		            int dayOfMonth) {
		        // TODO Auto-generated method stub
		        calendar.set(Calendar.YEAR, year);
		        calendar.set(Calendar.MONTH, monthOfYear);
		        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		        updateLabel();
		    }
		};
		
		setTime = new OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
				calendar.set(Calendar.MINUTE, minute);
				updateLabel();
			}
		};
		
		textDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DatePickerDialog(getActivity(), setDate, calendar
	                    .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
	                    calendar.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		
		textTime.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new TimePickerDialog(getActivity(), setTime, calendar.get(Calendar.HOUR_OF_DAY),
						calendar.get(Calendar.MINUTE), true).show();
			}
		});
		
		buttonSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.containerLapangan, new ListLapanganFragment()).commit();
			}
		});
		
		String[] spinnerItems = {"Lapangan Besar", "Lapangan Futsal"};
		ArrayAdapter arAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerItems);
		spinner = (Spinner)rootView.findViewById(R.id.spinner1);
		spinner.setAdapter(arAdapter);
		
		return rootView;
	}
	
	private void updateLabel() {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
	    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm", Locale.US);
	    textDate.setText(sdf.format(calendar.getTime()));
	    textTime.setText(timeFormat.format(calendar.getTime()));
	}

}
