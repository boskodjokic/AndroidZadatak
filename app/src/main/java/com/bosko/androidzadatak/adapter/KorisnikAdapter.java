package com.bosko.androidzadatak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bosko.androidzadatak.R;
import com.bosko.androidzadatak.entity.Korisnik;

import java.util.ArrayList;
import java.util.List;

public class KorisnikAdapter extends RecyclerView.Adapter<KorisnikAdapter.KorisnikHolder> {

    private List<Korisnik> korisniks = new ArrayList<>();

    @NonNull
    @Override
    public KorisnikHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.korisnik_item, parent, false);
        return new KorisnikHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KorisnikHolder holder, int position) {
        Korisnik currentKorisnik = korisniks.get(position);
        holder.textViewName.setText(currentKorisnik.getName());
        holder.textViewUser.setText(currentKorisnik.getUser());
        holder.textViewPass.setText(String.valueOf(currentKorisnik.getPassword()));
    }

    @Override
    public int getItemCount() {
        return korisniks.size();
    }

    public void setKorisniks(List<Korisnik> korisniks) {
        this.korisniks = korisniks;
        notifyDataSetChanged();
    }

    class KorisnikHolder extends RecyclerView.ViewHolder {
        private TextView textViewUser;
        private TextView textViewPass;
        private TextView textViewName;

        public KorisnikHolder(View itemView) {
            super(itemView);
            textViewUser = itemView.findViewById(R.id.text_view_user);
            textViewPass = itemView.findViewById(R.id.text_view_pass);
            textViewName = itemView.findViewById(R.id.text_view_name);
        }
    }
}
