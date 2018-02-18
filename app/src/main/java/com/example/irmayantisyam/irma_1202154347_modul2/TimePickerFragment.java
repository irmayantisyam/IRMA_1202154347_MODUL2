package com.example.irmayantisyam.irma_1202154347_modul2;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by IRMAYANTI SYAM on 2/17/2018.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) { //menampilkan kalender
        final Calendar c = Calendar.getInstance();
        int jam = c.get(Calendar.HOUR_OF_DAY); //variabel jam sbgai inisiasi dari int yang menyimpan informasi jam
        int menit = c.get(Calendar.MINUTE);//variabel menit sbgai inisiasi dari int yang menyimpan menit

        return new TimePickerDialog(getActivity(), this, jam, menit,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

        TakeAway activity = (TakeAway) getActivity();
        activity.processTimePickerResult(i, i1); //pemanggilan method processDatePickerResult pada take away
    }
}