package com.example.irmayantisyam.irma_1202154347_modul2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Toast.makeText(SplashScreen.this,"Irmayanti Syam_1202154347",Toast.LENGTH_SHORT).show();
        //menampilkan pesan Toast dengan NAMA_NIM

        new Handler().postDelayed(new Runnable() {
            //membuat handler yang berfungsi untuk menahan perintah selama interval yang telah ditentukan
            @Override
            public void run() {
                Intent splash = new Intent(SplashScreen.this,pesanan.class);
                //mendeklarasikan intent yang disimpan ke dalam vaiabel dinamakan "splash"
                //menghubungkan class SplashScreen dengan class pesanan untuk perpindahan halaman
                startActivity(splash);
                //memulai intent
                this.finish();
            }
            private void finish (){
             }},
                3000); //interval waktu intent dimunculkan dalam satuan milisecond
    };
}
