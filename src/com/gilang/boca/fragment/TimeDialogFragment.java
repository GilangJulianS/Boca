package com.gilang.boca.fragment;

import com.gilang.boca.R;
import com.gilang.boca.main.DataField;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

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
        
        ImageView buttonSelectField = (ImageView)dialog.findViewById(R.id.chooseTime);
        buttonSelectField.setClickable(true);
        buttonSelectField.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FieldFragment.pager.setCurrentItem(2, true);
				FieldFragment.header.setImageResource(R.drawable.arrowcl2);
				dialog.dismiss();
			}
		});
        
    	return dialog;
    }
}
