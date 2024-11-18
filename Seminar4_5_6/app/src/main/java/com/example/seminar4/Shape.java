package com.example.seminar4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;
import java.util.List;

public class Shape extends BaseAdapter {
    private List<Garsoniera> garsoniere = null;
    private Context ctx;
    private int resursaLayout;


    public Shape(List<Garsoniera> garsoniere, Context ctx, int resursaLayout) {
        this.garsoniere = garsoniere;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return garsoniere.size();
    }

    @Override
    public Object getItem(int position) {
        return garsoniere.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View v=inflater.inflate(resursaLayout,parent,false);

        TextView orasTV = convertView.findViewById(R.id.OrasTextView);

        TextView stradaTV = convertView.findViewById(R.id.StradaTextView);

        TextView nrEtajTV = convertView.findViewById(R.id.EtajTextView9);

        TextView nrApartamentTV = convertView.findViewById(R.id.NrApartamentTextView10);

        TextView ocupareTV = convertView.findViewById(R.id.OcupareTextView8);

        Garsoniera garsoniera =(Garsoniera)getItem(position);

        orasTV.setText(garsoniera.getOras());
        stradaTV.setText(garsoniera.getStrada());
        nrEtajTV.setText(garsoniera.getNrEtaj());
        nrApartamentTV.setText(garsoniera.getNrApartament());
        if(garsoniera.getEsteOcupata()==true) {
            ocupareTV.setText("Ocupata");
        }
        else{
            ocupareTV.setText("Libera");
        }
        return convertView;
    }
}
