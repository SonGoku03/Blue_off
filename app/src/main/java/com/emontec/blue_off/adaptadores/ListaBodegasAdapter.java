package com.emontec.blue_off.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emontec.blue_off.R;
import com.emontec.blue_off.entidades.Bodegas;
import com.emontec.blue_off.entidades.Clientes;

import java.util.ArrayList;


/**
 * Created by CHENAO on 8/07/2017.
 */

public class ListaBodegasAdapter extends RecyclerView.Adapter<ListaBodegasAdapter.PersonasViewHolder> {

    ArrayList<Bodegas> listaClientes;

    public ListaBodegasAdapter(ArrayList<Bodegas> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_bodegas,null,false);
        return new PersonasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonasViewHolder holder, int position) {
        holder.elemento.setText(listaClientes.get(position).getElemento().toString());
        holder.valor.setText(listaClientes.get(position).getValor());
        holder.series.setText(listaClientes.get(position).getSeries());

    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView elemento,valor,series;

        public PersonasViewHolder(View itemView) {
            super(itemView);
            elemento = (TextView) itemView.findViewById(R.id.elemento);
            valor = (TextView) itemView.findViewById(R.id.valor);
            series = (TextView) itemView.findViewById(R.id.series);
          }
    }
}
