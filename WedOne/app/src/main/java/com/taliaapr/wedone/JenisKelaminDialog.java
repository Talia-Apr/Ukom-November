package com.taliaapr.wedone;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class JenisKelaminDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        String[] jenisKelamin = getActivity().getResources().getStringArray(R.array.jenisKelamin);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Jenis Kelamin");
        builder.setItems(jenisKelamin, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getActivity(), "Kamu memilih "+jenisKelamin[i], Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }
}
