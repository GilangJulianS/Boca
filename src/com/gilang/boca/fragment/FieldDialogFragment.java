package com.gilang.boca.fragment;

import com.gilang.boca.R;
import com.gilang.boca.main.DataPopUpField;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.ImageView;
import android.widget.TextView;

public class FieldDialogFragment extends DialogFragment {
	
	DataPopUpField datField;
	
    public FieldDialogFragment(DataPopUpField datField) {
    	this.datField = datField;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	Dialog dialog = new Dialog(getActivity());
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
    	return dialog;
    }

}
