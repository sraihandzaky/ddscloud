package com.example.veradebora.dds.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.veradebora.dds.R;

/**
 * Created by Vera Debora on 8/20/2018.
 */

public class TopUpDialog extends AppCompatDialogFragment {

    private EditText Amount,BankName,NoRek;
    private TopUpDialogListener topUpDialogListener;
    public String NamaBank;
    public int Nominal, RekNum, Uid;


    @Override
    public void onStart() {
        super.onStart();
        AlertDialog alertDialog = (AlertDialog)getDialog();
        if (alertDialog != null){
            Button positiveButton = (Button) alertDialog.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(v -> {
                Boolean closedialog = false;
                if (isNotEmpty(Amount)
//                            && isNotEmpty(BankName)
                        && isNotEmpty(NoRek)) {
                    Nominal = Integer.parseInt(Amount.getText().toString());
//                        NamaBank = BankName.getText().toString();
                    NamaBank = "t-money";
                    RekNum = Integer.parseInt(NoRek.getText().toString());
                    topUpDialogListener.applyTexts(Nominal, NamaBank, RekNum);
                    closedialog = true;
                }
                else {
                    Toast.makeText(getActivity(),"All Field Must Be Filled!",Toast.LENGTH_SHORT).show();
                }

                if (closedialog){
                    Toast.makeText(getActivity(), "Top Up Has Been Requested!", Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            });
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.topupdialog, null);

        builder.setView(view)
                .setTitle("TopUp Request")
                .setCancelable(true)
                .setNegativeButton("Cancel", (dialogInterface, i) -> {

                })
                .setPositiveButton("Ok", (dialogInterface, i) -> {

                });

        Amount = view.findViewById(R.id.amount);
//        BankName = view.findViewById(R.id.BankName);
        NoRek = view.findViewById(R.id.NoRek);
        return builder.create();
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        try {
            topUpDialogListener = (TopUpDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    "Must implement TopUpDialogListener");
        }
    }

    public interface TopUpDialogListener{
        void applyTexts(int Nominal, String NamaBank, int RekNum);

    }

    private boolean isNotEmpty(EditText etText) {
        return etText.getText().toString().trim().length() > 0;
    }

}
