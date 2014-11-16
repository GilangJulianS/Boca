package com.gilang.boca.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.boca.R;
import com.gilang.boca.main.DataField;

public class FieldDialogFragment extends DialogFragment {
	
	DataField datField;
	Dialog dialog;
	
    public FieldDialogFragment(DataField datField) {
    	this.datField = datField;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	dialog = new Dialog(getActivity());
    	dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_dialogfield);
        TextView fieldName = (TextView)dialog.findViewById(R.id.fieldName);
        ImageView fieldImage = (ImageView)dialog.findViewById(R.id.fieldImage);
        TextView fieldAddress = (TextView)dialog.findViewById(R.id.fieldAdress);
        TextView fieldPhone = (TextView)dialog.findViewById(R.id.fieldPhone);
        TextView fieldPrice = (TextView)dialog.findViewById(R.id.fieldPrice);
        fieldName.setText(datField.getFieldName());
        fieldImage.setImageResource(datField.getFieldImageResId());
        fieldAddress.setText(datField.getFieldAddress());
        fieldPhone.setText(datField.getFieldPhone());
        fieldPrice.setText(datField.getFieldPrice());
        
        ImageView buttonSelectField = (ImageView)dialog.findViewById(R.id.imageSelectField);
        buttonSelectField.setClickable(true);
        buttonSelectField.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FieldFragment.pager.setCurrentItem(1, true);
				FieldFragment.header.setImageResource(R.drawable.arrowcl2);
				dialog.dismiss();
			}
		});
        
    	return dialog;
    }

}
