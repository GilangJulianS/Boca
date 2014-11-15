package com.gilang.boca.fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.gilang.boca.R;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class SelectTimeFieldFragment extends Fragment {

	DatePickerDialog.OnDateSetListener setDate;
	Calendar calendar;
	TextView fieldName;
	EditText textDate;
	
	public SelectTimeFieldFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_field_time_select, container, false);
		calendar = Calendar.getInstance();
		fieldName = (TextView)view.findViewById(R.id.field_location);
		textDate = (EditText)view.findViewById(R.id.selectFieldDate);
		textDate.setFocusable(false);
		
		setDate = new DatePickerDialog.OnDateSetListener() {

		    @Override
		    public void onDateSet(DatePicker view, int year, int monthOfYear,
		            int dayOfMonth) {
		        // TODO Auto-generated method stub
		        calendar.set(Calendar.YEAR, year);
		        calendar.set(Calendar.MONTH, monthOfYear);
		        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		        updateDate();
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
		
		
		return view;
	}
	
	private void updateDate() {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
	    textDate.setText(sdf.format(calendar.getTime()));
	}
}
