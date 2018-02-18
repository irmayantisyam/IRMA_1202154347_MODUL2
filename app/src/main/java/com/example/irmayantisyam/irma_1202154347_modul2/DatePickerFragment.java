package com.example.irmayantisyam.irma_1202154347_modul2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import java.util.Calendar;

/**
 * Created by IRMAYANTI SYAM on 2/17/2018.
 */

public class DatePickerFragment  extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {//menampilkan kalender
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR); //variabel year menyimpan int untuk tahun
        int month = c.get(Calendar.MONTH); //variabel month menyimpan int untuk bulan
        int day = c.get(Calendar.DAY_OF_MONTH); //variabel day menyimpan int untuk hari atau tanggal

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        TakeAway activity = (TakeAway) getActivity();
        activity.processDatePickerResult(i, i1, i2); //pemanggilan method processDatePickerResult pada take away
    }
}