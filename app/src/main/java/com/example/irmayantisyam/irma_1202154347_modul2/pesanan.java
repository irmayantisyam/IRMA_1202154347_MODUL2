package com.example.irmayantisyam.irma_1202154347_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class pesanan extends AppCompatActivity {

    private Button pesan;
    private RadioGroup pilihan;
    private RadioButton dine, tAway;
    //mendeklarasikan button, radio group, dan radio button yang disimpan pada masing-masing variabel yang telah ditentukan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        pesan = (Button) findViewById(R.id.btPesan);
        pilihan = (RadioGroup) findViewById(R.id.pilih);
        dine = (RadioButton) findViewById(R.id.rbDineIn);
        tAway = (RadioButton) findViewById(R.id.rbTakeAway);
        //diatas merupakan inisiasi dari id yang terdapat di layout untuk masing-masing button, radio group, dan radio button
    }

    public void pesan(View view) {
        pilihan = (RadioGroup) findViewById(R.id.pilih);
        dine = (RadioButton) findViewById(R.id.rbDineIn);
        tAway = (RadioButton) findViewById(R.id.rbTakeAway);

        int selecteditem = pilihan.getCheckedRadioButtonId(); //membuat radio button dapat dipilih
        if (selecteditem == dine.getId()) {
            Toast.makeText(this, "Anda Memilih Dine In", Toast.LENGTH_LONG).show();
            Intent a = new Intent(pesanan.this, DineIn.class); //intent yang beralih ke halaman dine in class
            startActivity(a); //akan menampilkan toast "memilih dine in" ketika memilih radiobutton dine in
        } else if (selecteditem == tAway.getId()) {
            Toast.makeText(this, "Anda Memilih Take Away", Toast.LENGTH_LONG).show();
            Intent a = new Intent(pesanan.this, TakeAway.class);// intent yang beralih ke halaman take away class
            startActivity(a);//akan menampilkan toast "memilih take awal" ketika memilih radiobutton take away
        }
    } //merupakan method yang akan dijalankan ketika memilih button
}