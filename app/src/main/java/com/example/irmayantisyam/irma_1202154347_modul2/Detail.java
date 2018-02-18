package com.example.irmayantisyam.irma_1202154347_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    private TextView satu, dua, tiga;
    private ImageView gbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        satu = findViewById(R.id.namamakanan);
        dua = findViewById(R.id.harga);
        tiga = findViewById(R.id.isinya);
        gbr = findViewById(R.id.gbrMenu);

        Intent c = getIntent();
        //melakukan get data dari class sebelumnya

        String menu1 = c.getStringExtra("nama");
        String hrga = c.getStringExtra("harga");
        String kmposisi = c.getStringExtra("komposisi");
        Integer gmbr = c.getIntExtra("gambar", 0);

        //set text dan setimage dibawa dari class sebelumnya
        satu.setText(menu1);
        dua.setText(hrga);
        tiga.setText(kmposisi);
        gbr.setImageResource(gmbr);


    }
}