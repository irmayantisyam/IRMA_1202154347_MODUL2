package com.example.irmayantisyam.irma_1202154347_modul2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by IRMAYANTI SYAM on 2/17/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> rvData,rvHarga;
    private ArrayList<Integer> gambar;


    public RecyclerViewAdapter(ArrayList<String> inputData, ArrayList<String> dataHarga, ArrayList<Integer> gmbr) {
        rvData = inputData;
        rvHarga = dataHarga;
        gambar = gmbr;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView title2;
        public ImageView a;
        private RelativeLayout ItemList;

        private Context context; //menghubungkan dan mendapatkan context dari class pesanan

        public ViewHolder(View v) {
            super(v);
            context = itemView.getContext();
            //melakukan inisiasi terhadap textview, imageview, dan linear layout
            title = (TextView) v.findViewById(R.id.tv_title);
            title2 = (TextView) v.findViewById(R.id.tv_subtitle);
            a = (ImageView) v.findViewById(R.id.icon);
            ItemList = v.findViewById(R.id.list);
            ItemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,Detail.class);
                    String ingredient ="";
                    switch (getAdapterPosition()){ //pengkondisian
                        case 0 :
                            intent.putExtra("nama1",rvData.get(getAdapterPosition()));
                            intent.putExtra("harga",rvHarga.get(getAdapterPosition()));
                            intent.putExtra("gambar",gambar.get(getAdapterPosition()));
                            ingredient = "Garam, bayam, ayam";
                            intent.putExtra("komposisi",ingredient);
                            context.startActivity(intent);
                            break;
                        case 1 :
                            intent.putExtra("nama1",rvData.get(getAdapterPosition()));
                            intent.putExtra("harga",rvHarga.get(getAdapterPosition()));
                            intent.putExtra("gambar",gambar.get(getAdapterPosition()));
                            ingredient = "Gula, kecap, bayam, kangkung";
                            intent.putExtra("komposisi",ingredient);
                            context.startActivity(intent);
                            break;

                        case 2 :
                            intent.putExtra("nama1",rvData.get(getAdapterPosition()));
                            intent.putExtra("harga",rvHarga.get(getAdapterPosition()));
                            intent.putExtra("gambar",gambar.get(getAdapterPosition()));
                            ingredient = "Beras, telur, seledri";
                            intent.putExtra("komposisi",ingredient);
                            context.startActivity(intent);
                            break;

                }
            }
            });
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coba, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //inisiasi String untuk variabel nama dan harga, serta integer untuk test
        final String name = rvData.get(position);
        final String harga = rvHarga.get(position);
        final Integer test = gambar.get(position);
        holder.title.setText(name);
        holder.title2.setText(harga);
        holder.a.setImageResource(test);
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }
}
