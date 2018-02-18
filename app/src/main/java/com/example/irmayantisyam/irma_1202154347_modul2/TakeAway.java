package com.example.irmayantisyam.irma_1202154347_modul2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TakeAway extends AppCompatActivity {

    EditText nama1, phone1, alamat1, catatan1; //mendeklarasikan edit text pada masing masing variabel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);
        //melakukan inisiasi pada masing-masing variabe;
        nama1 = findViewById(R.id.name);
        phone1 = findViewById(R.id.phone);
        alamat1 = findViewById(R.id.alamat);
        catatan1 = findViewById(R.id.catatan);
    }
    public void pilihpesan(View view) { //method saat memilih pilih pesanan
        //inisiasi pada masing-masing variabel string
        String nama = nama1.getText().toString();
        String telepon = phone1.getText().toString();
        String alamat = alamat1.getText().toString();
        String catatan = catatan1.getText().toString();

        if (nama.isEmpty()|| telepon.isEmpty() || alamat.isEmpty()){
            //kondisi pengecekan tiap edit text agar terisi, kecuali catatanAlertDialog alertDialog = new AlertDialog.Builder(DineIn.this).create(); //memunculkan alert
            AlertDialog alertDialog = new AlertDialog.Builder(TakeAway.this).create(); //memunculkan alert
            alertDialog.setTitle("Pemberitahuan");//judul alert
            alertDialog.setMessage("Nama, Nomor Telepon, dan Alamat wajib diisi");//isi pesan alert
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",//button pada alertnya
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else { //kondisi yang berbeda dengan if
            Intent a = new Intent(TakeAway.this, DaftarMenu.class);
            startActivity(a);
        }
    }
    public void showDatePickerDialog(View v) { //method untuk menampilkan tanggal
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.date_picker));
    }

    public void showTimePickerDialog(View view) { //method untuk menampilkan waktu
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.time_picker));
    }

    public void processDatePickerResult(int year, int month, int day) {//method yang digunakan pada Date Picker Fragment
        nama1 = (EditText) findViewById(R.id.name);
        phone1 = (EditText) findViewById(R.id.phone);

        String nama = nama1.getText().toString();
        String telepon = phone1.getText().toString();

        if (nama.isEmpty() || telepon.isEmpty()) { ///kondisi untuk mengecek nama dan telepon tidak kosong
            Toast.makeText(this, "Harap mengisi terlebih dahulu", Toast.LENGTH_LONG).show();
        } else {

            String month_string = Integer.toString(month + 1);
            String day_string = Integer.toString(day);
            String year_string = Integer.toString(year);
            String dateMessage = (month_string + "/" + day_string + "/" + year_string);
            Toast.makeText(this, "Atas Nama : " + nama + "\n No Telepon : " + telepon + "\n Akan Mengambil pada : " + getString(R.string.date) + dateMessage, Toast.LENGTH_SHORT).show();
        }
    }

    public void processTimePickerResult(int hourOfDay, int minute) { //kondisi untuk mengecek nama dan telepon tidak kosong
        String nama = nama1.getText().toString();
        String telepon = phone1.getText().toString();

        if (nama.isEmpty() || telepon.isEmpty()) {// kondisi untuk mengecek nama dan telepon agar tidak kosong
            Toast.makeText(this, "Harap mengsi terlebih dahulu", Toast.LENGTH_LONG).show();
        } else {
            String hour_string = Integer.toString(hourOfDay);
            String minute_string = Integer.toString(minute);
            String timeMessage = (hour_string + ":" + minute_string);
            Toast.makeText(this, "Atas Nama : " + nama + "\n No Telepon : " + telepon + "\n Akan Mengambil pada : " + getString(R.string.time) + timeMessage, Toast.LENGTH_SHORT).show();
            //manmpilkan toast
        }
    }
}