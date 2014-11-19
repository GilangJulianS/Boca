package com.gilang.boca.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gilang.boca.R;
import com.gilang.boca.main.DataField;

public class TimeDialogFragment extends DialogFragment {

	DataField datField;
	Dialog dialog;
	
    public TimeDialogFragment() {
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	dialog = new Dialog(getActivity());
    	dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_popup_time);
        
        ImageView plusSign = (ImageView)dialog.findViewById(R.id.plusSign);
        ImageView minusSign = (ImageView)dialog.findViewById(R.id.minusSign);
        final TextView countHour = (TextView)dialog.findViewById(R.id.countHour);
        
        plusSign.setClickable(true);
        minusSign.setClickable(true);
        
        plusSign.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SelectTimeFieldFragment.hour++;
				countHour.setText(""+SelectTimeFieldFragment.hour);
			}
		});
        
        minusSign.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(SelectTimeFieldFragment.hour > 1){
					SelectTimeFieldFragment.hour--;
					countHour.setText(""+SelectTimeFieldFragment.hour);
				}
			}
		});
        
        
        ImageView buttonSelectField = (ImageView)dialog.findViewById(R.id.chooseTime);
        buttonSelectField.setClickable(true);
        buttonSelectField.setOnClickListener(new View.OnClickListener() {
			@Override
			
			public void onClick(View v) {
				Toast.makeText(getActivity(), "test", Toast.LENGTH_SHORT);
				FieldFragment.pager.setCurrentItem(2, true);
				FieldFragment.header.setImageResource(R.drawable.arrowcl3);
				dialog.dismiss();
			}
		});
        
        
        
    	return dialog;
    }
}
