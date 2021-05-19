package com.bosko.androidzadatak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bosko.androidzadatak.R;
import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.ArrayList;
import java.util.List;

public class ZaposleniAdapter extends RecyclerView.Adapter<ZaposleniAdapter.ZaposleniHolder>{
    private List<Zaposleni> zaposleniList = new ArrayList<>();

    @NonNull
    @Override
    public ZaposleniAdapter.ZaposleniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.zaposleni_item, parent, false);
        return new ZaposleniAdapter.ZaposleniHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ZaposleniAdapter.ZaposleniHolder holder, int position) {
        Zaposleni currentZaposleni = zaposleniList.get(position);
        holder.textViewName.setText(currentZaposleni.getName());
    }

    @Override
    public int getItemCount() {
        return zaposleniList.size();
    }

    public void setZaposleniList(List<Zaposleni> zaposleniList) {
        this.zaposleniList = zaposleniList;
        notifyDataSetChanged();
    }

    class ZaposleniHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;

        public ZaposleniHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
        }
    }

}
