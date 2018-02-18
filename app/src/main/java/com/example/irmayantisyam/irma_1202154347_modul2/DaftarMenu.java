package com.example.irmayantisyam.irma_1202154347_modul2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

/**
 * Created by IRMAYANTI SYAM on 2/17/2018.
 */

public class DaftarMenu extends AppCompatActivity {
    private RecyclerView rvView;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList <String> dNama;
    private ArrayList<String> dHarga;
    private ArrayList<Integer> dImage;

    //array untuk daftar menu makanan, harga , serta gambarnya
    private String[] nama = {"Sayur asem", "sayur manis", "bubur"};
    private String[] harga = {"Rp 15.000", "Rp 20.000", "Rp 25.000"};
    private int[] gbr = {R.drawable.satu, R.drawable.dua, R.drawable.tigas};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);

        //mendeklarasikan array list untuk menu, harga, dan gambar
        dNama =new ArrayList<>();
        dHarga= new ArrayList<>();
        dImage = new ArrayList<>();
        DaftarItem();

        rvView = (RecyclerView) findViewById(R.id.rvMenu);
        rvView.setHasFixedSize(true);
        //menyimpan id rvMenu ke dalam variabel rvView
        layoutManager = new LinearLayoutManager(this);
        //inisiasi layout manager
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(dNama, dHarga, dImage);
        rvView.setAdapter(adapter);
}

    private void DaftarItem (){//mengambil data dari variabel gambar, nama, harga, dan memasukkan pd list yang terhubung dengan class adapter
     for (int i=0; i<nama.length; i++){
        dNama.add(nama[i]);
        dHarga.add(harga[i]);
        dImage.add(gbr[i]);

        }
    }
}