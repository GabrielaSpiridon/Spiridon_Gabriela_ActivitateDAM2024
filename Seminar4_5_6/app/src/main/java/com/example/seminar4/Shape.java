package com.example.seminar4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Shape extends BaseAdapter {
    private List<Garsoniera> garsoniere; // Lista de garsoniere
    private Context ctx; // Contextul activității
    private int resursaLayout; // Resursa de layout personalizată

    public Shape(List<Garsoniera> garsoniere, Context ctx, int resursaLayout) {
        this.garsoniere = garsoniere;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return garsoniere.size(); // Numărul de elemente din listă
    }

    @Override
    public Object getItem(int position) {
        return garsoniere.get(position); // Elementul de pe poziția specificată
    }

    @Override
    public long getItemId(int position) {
        return position; // Poziția ca identificator unic
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            // Inflatarea layout-ului doar dacă convertView este null
            LayoutInflater inflater = LayoutInflater.from(ctx);
            convertView = inflater.inflate(resursaLayout, parent, false);

            // Inițializarea ViewHolder pentru reutilizare
            viewHolder = new ViewHolder();
            viewHolder.orasTV = convertView.findViewById(R.id.OrasTextView);
            viewHolder.stradaTV = convertView.findViewById(R.id.StradaTextView);
            viewHolder.nrEtajTV = convertView.findViewById(R.id.EtajTextView9);
            viewHolder.nrApartamentTV = convertView.findViewById(R.id.NrApartamentTextView10);
            viewHolder.ocupareTV = convertView.findViewById(R.id.OcupareTextView8);

            convertView.setTag(viewHolder); // Stocarea ViewHolder în convertView
        } else {
            // Reutilizarea ViewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Setarea valorilor în TextView-uri
        Garsoniera garsoniera = (Garsoniera) getItem(position);
        viewHolder.orasTV.setText(garsoniera.getOras());
        viewHolder.stradaTV.setText(garsoniera.getStrada());
        viewHolder.nrEtajTV.setText("Etaj: " + garsoniera.getNrEtaj());
        viewHolder.nrApartamentTV.setText("Apartament: " + garsoniera.getNrApartament());
        viewHolder.ocupareTV.setText(garsoniera.getEsteOcupata() ? "Libera" : "Ocupata");

        return convertView;
    }

    // Clasă statică ViewHolder pentru performanță
    static class ViewHolder {
        TextView orasTV;
        TextView stradaTV;
        TextView nrEtajTV;
        TextView nrApartamentTV;
        TextView ocupareTV;
    }
}
