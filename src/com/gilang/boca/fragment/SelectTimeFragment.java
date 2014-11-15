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
	TimePickerDialog.OnTimeSetListener setTime1;
	TimePickerDialog.OnTimeSetListener setTime2;
	Calendar calendar1;
	Calendar calendar2;
	EditText textDate;
	EditText textTime1;
	EditText textTime2;
	Spinner spinner;
	Button buttonSearch;
	
	public SelectTimeFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_select_time, container, false);
		calendar1 = Calendar.getInstance();
		calendar2 = Calendar.getInstance();
		textDate = (EditText) rootView.findViewById(R.id.editText1);
		textTime1 = (EditText) rootView.findViewById(R.id.editText2);
		textTime2 = (EditText) rootView.findViewById(R.id.editText3);
		buttonSearch = (Button) rootView.findViewById(R.id.button1);
		textDate.setFocusable(false);
		textTime1.setFocusable(false);
		textTime2.setFocusable(false);
		
		setDate = new DatePickerDialog.OnDateSetListener() {

		    @Override
		    public void onDateSet(DatePicker view, int year, int monthOfYear,
		            int dayOfMonth) {
		        // TODO Auto-generated method stub
		        calendar1.set(Calendar.YEAR, year);
		        calendar1.set(Calendar.MONTH, monthOfYear);
		        calendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		        updateDate();
		    }
		};
		
		setTime1 = new OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				calendar1.set(Calendar.HOUR_OF_DAY, hourOfDay);
				calendar1.set(Calendar.MINUTE, minute);
				updateTime1();
			}
		};
		
		setTime2 = new OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				calendar2.set(Calendar.HOUR_OF_DAY, hourOfDay);
				calendar2.set(Calendar.MINUTE, minute);
				updateTime2();
			}
		};
		
		textDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DatePickerDialog(getActivity(), setDate, calendar1
	                    .get(Calendar.YEAR), calendar1.get(Calendar.MONTH),
	                    calendar1.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		
		textTime1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new TimePickerDialog(getActivity(), setTime1, calendar1.get(Calendar.HOUR_OF_DAY),
						calendar1.get(Calendar.MINUTE), true).show();
			}
		});
		
		textTime2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new TimePickerDialog(getActivity(), setTime2, calendar2.get(Calendar.HOUR_OF_DAY),
						calendar2.get(Calendar.MINUTE), true).show();
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
		spinner = (Spinner)rootView.findViewById(R.id.spinnerCity);
		spinner.setAdapter(arAdapter);
		
		return rootView;
	}
	
	private void updateDate() {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
	    textDate.setText(sdf.format(calendar1.getTime()));
	}
	
	private void updateTime1(){
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm", Locale.US);
		textTime1.setText(timeFormat.format(calendar1.getTime()));
	}
	
	private void updateTime2(){
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm", Locale.US);
		textTime2.setText(timeFormat.format(calendar2.getTime()));
	}

}
