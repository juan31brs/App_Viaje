package com.angel.juan.app_tuviaje.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angel.juan.app_tuviaje.R;
import com.angel.juan.app_tuviaje.databinding.TemplateDestinoBinding;
import com.angel.juan.app_tuviaje.util.Data;


public class DestinoAdapter extends RecyclerView.Adapter<DestinoAdapter.DestinoViewHolder>{

    //Defino el metodo con esta clase interface, este es el contrato
    //Defino el parqueadero que debe tener en este caso los metodos
    public interface OnDestinoListener{
        void onDestino(View v);
    }

    LayoutInflater inflater;//Para el constructor del Adaptador
    OnDestinoListener onDestinoListener;//declaro un objeto de la inteface


    public DestinoAdapter(LayoutInflater inflater, OnDestinoListener onDestinoListener) {
        //public ViajeAdapter(LayoutInflater inflater, OnViajeListener onViajeListener)
        this.onDestinoListener = onDestinoListener;//se lo asigno a la variable o el objeto declarado
        this.inflater = inflater;
    }

    //se retorna con las vistas, se llama por vista
    @Override
    public DestinoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Hacemos el inflate, obtengo el layout, el contenedor y el false para que no este anidado
        View v = inflater.inflate(R.layout.template_destino, parent, false);
        //creamos el ViewHolder
        DestinoViewHolder holder = new DestinoViewHolder(v);
        return holder;
    }

    //le coloca los datos a la vista
    @Override
    public void onBindViewHolder(DestinoViewHolder holder, int position) {
        holder.binding.setDestinos(Data.datade.get(position));
        //fijo la variable handler
        holder.binding.setHandler(this);
    }

    //tamaño de los datos
    @Override
    public int getItemCount() {
        return Data.datade.size();
    }

    //cada ves que le demos click invocamos el metodo y le mandamos la informacion
    public void onClickDestino(View v){
        onDestinoListener.onDestino(v);

    }



    public static class DestinoViewHolder extends RecyclerView.ViewHolder{

        TemplateDestinoBinding binding;

        public DestinoViewHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }
    }
}

