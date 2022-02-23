package com.farid.lespoints.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

import com.farid.lespoints.Holder.HolderRecycler;
import com.farid.lespoints.ItemObject;
import com.farid.lespoints.R;

public class AdapterRecycler extends RecyclerView.Adapter<HolderRecycler> {

    private List<ItemObject> recyclerList;
    private Context context;

    public AdapterRecycler(Context context, List<ItemObject> recyclerList) {
        this.context = context;
        this.recyclerList = recyclerList;
    }

    @Override
    public HolderRecycler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carditem, null);
        return new HolderRecycler(view);
    }

    @Override
    public void onBindViewHolder(HolderRecycler holder, int position) {
        holder.txtJudul.setText(recyclerList.get(position).resto);//nom
        String harga = recyclerList.get(position).description;//descrip
        holder.txtHarga.setText("--. " + harga + ",-");
        holder.serv.setText(recyclerList.get(position).adresse);//adre
        holder.horai.setText(recyclerList.get(position).horaires);//frozen
        holder.telep.setText(recyclerList.get(position).tel);//tel
    }

    @Override
    public int getItemCount() {
        return recyclerList.size();
    }
}
