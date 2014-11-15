package com.gilang.boca.fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.gilang.boca.R;
import com.gilang.boca.customclass.ListFieldTimeAdapter;
import com.gilang.boca.main.FieldTimeData;

public class SelectTimeFieldFragment extends Fragment {

	DatePickerDialog.OnDateSetListener setDate;
	Calendar calendar;
	TextView fieldName;
	EditText textDate;
	ListView listViewItem;
	
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
		listViewItem = (ListView)view.findViewById(R.id.listTimeData);
		
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
		
		textDate.addTextChangedListener(new TextWatcher(){
			
			@Override
		    public void afterTextChanged(Editable s) {
		        List<FieldTimeData> datFields = new ArrayList<>();
		        datFields.add(new FieldTimeData("Queen", "Lapangan A", "08.00 - 09.00", "Rp 90.000,-"));
		        datFields.add(new FieldTimeData("Queen", "Lapangan A", "09.00 - 10.00", "Rp 90.000,-"));
		        datFields.add(new FieldTimeData("Queen", "Lapangan A", "10.00 - 11.00", "Rp 90.000,-"));
		        datFields.add(new FieldTimeData("Queen", "Lapangan A", "11.00 - 12.00", "Rp 90.000,-"));
		        datFields.add(new FieldTimeData("Queen", "Lapangan A", "12.00 - 13.00", "Rp 90.000,-"));
		        datFields.add(new FieldTimeData("Queen", "Lapangan A", "13.00 - 14.00", "Rp 90.000,-"));
		        ListFieldTimeAdapter adapter = new ListFieldTimeAdapter(getActivity(), datFields);
		        listViewItem.setAdapter(adapter);
		        
		    }

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		}); 	
		
		
		return view;
	}
	
	private void updateDate() {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
	    textDate.setText(sdf.format(calendar.getTime()));
	}
}
