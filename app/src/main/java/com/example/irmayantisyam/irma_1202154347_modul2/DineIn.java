package com.example.irmayantisyam.irma_1202154347_modul2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by IRMAYANTI SYAM on 2/17/2018.
 */

public class DineIn extends AppCompatActivity {
    private EditText user;
    private Spinner cSpinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);

        cSpinner = (Spinner)findViewById(R.id.sMeja); //inisiasi spinner

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //memanggil array untuk menampung data yang ada pada spinner

        if (cSpinner != null) {
            cSpinner.setAdapter(adapter);
        } //melakukan pengecekan spinner tidak kosong (sesuai yang telah dimasukkan ke string.xml)

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void pilihpesanan (View view) { //method yang berjalan ketika button diklik
        String test = cSpinner.getSelectedItem().toString(); //string test untuk spinnernya dapat dipilih nanti
        user = (EditText) findViewById(R.id.name);//inisiasi untuk edit text

        if (user.getText().toString().length()==0 || test.equalsIgnoreCase("Pilih Meja")) {
            testing();
        } //kondisi ketika nama tidak diinputkan


        else if (test.equalsIgnoreCase("Meja 1")){
            String nama = user.getText().toString();
            Toast.makeText(this, nama + " memilih meja 1", Toast.LENGTH_LONG).show();//menampilkan toast
            Intent satu = new Intent(DineIn.this,DaftarMenu.class); //berpindah ke halaman daftar menu
            startActivity(satu);
        }//kondisi memilih meja 1
        else if (test.equalsIgnoreCase("Meja 2")){
            String nama = user.getText().toString();
            Toast.makeText(this, nama + " memilih meja 2", Toast.LENGTH_LONG).show();//menampilkan toast
            Intent dua = new Intent(DineIn.this,DaftarMenu.class);//berpindah ke halaman daftar menu
            startActivity(dua);
        } //kondisi memilih meja 2
        else if (test.equalsIgnoreCase("Meja 3")){
            String nama = user.getText().toString();
            Toast.makeText(this, nama + " memilih meja 3", Toast.LENGTH_LONG).show(); //menampilkan toast
            Intent tiga = new Intent(DineIn.this,DaftarMenu.class);//berpindah ke halaman daftar menu
            startActivity(tiga);
        }//kondisi memilih meja 3
    }
    public void testing (){ //method yang dipaki ketika pelanggan tidak memilih meja
        AlertDialog alertDialog = new AlertDialog.Builder(DineIn.this).create(); //memunculkan alert
        alertDialog.setTitle("Pemberitahuan");//judul alert
        alertDialog.setMessage("Silahkan masukkan nama dan pilih nomor meja terlebih dahulu");//isi pesan alert
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",//button pada alertnya
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
