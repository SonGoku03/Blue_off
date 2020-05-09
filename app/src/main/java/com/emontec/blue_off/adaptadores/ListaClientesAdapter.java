package com.emontec.blue_off.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emontec.blue_off.R;
import com.emontec.blue_off.entidades.Clientes;

import java.util.ArrayList;



/**
 * Created by CHENAO on 8/07/2017.
 */

public class ListaClientesAdapter extends RecyclerView.Adapter<ListaClientesAdapter.PersonasViewHolder> {

    ArrayList<Clientes> listaClientes;

    public ListaClientesAdapter(ArrayList<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_clientes,null,false);
        return new PersonasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonasViewHolder holder, int position) {
        holder.cardCode.setText(listaClientes.get(position).getCardCode().toString());
        holder.cardFName.setText(listaClientes.get(position).getCardFName());
        holder.cardName.setText(listaClientes.get(position).getCardName());
        holder.listNum.setText(listaClientes.get(position).getListNum());
        holder.email.setText(listaClientes.get(position).getEmail());
        holder.memo.setText(listaClientes.get(position).getMemo());
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView cardCode,cardFName,cardName,listNum,email,memo;

        public PersonasViewHolder(View itemView) {
            super(itemView);
            cardCode = (TextView) itemView.findViewById(R.id.cardcode);
            cardFName = (TextView) itemView.findViewById(R.id.cardFName);
            cardName = (TextView) itemView.findViewById(R.id.cardname);
            listNum = (TextView) itemView.findViewById(R.id.listnum);
           email = (TextView) itemView.findViewById(R.id.email);
            memo = (TextView) itemView.findViewById(R.id.memo);
        }
    }
}
