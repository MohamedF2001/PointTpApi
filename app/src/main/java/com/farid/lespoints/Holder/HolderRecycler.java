package com.farid.lespoints.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.farid.lespoints.R;

public class HolderRecycler extends RecyclerView.ViewHolder {

    public TextView txtJudul, txtHarga, serv, horai, telep;

    public HolderRecycler(View itemView) {
        super(itemView);
        txtJudul = (TextView) itemView.findViewById(R.id.txtJudul);
        txtHarga = (TextView) itemView.findViewById(R.id.txtHarga);
        serv = (TextView) itemView.findViewById(R.id.serv);//adress
        horai = (TextView) itemView.findViewById(R.id.horai);//frozen
        telep = (TextView) itemView.findViewById(R.id.telep);//tel
    }
}
