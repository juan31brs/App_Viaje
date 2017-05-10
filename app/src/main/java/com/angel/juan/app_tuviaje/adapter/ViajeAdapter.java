package com.angel.juan.app_tuviaje.adapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angel.juan.app_tuviaje.R;
import com.angel.juan.app_tuviaje.databinding.TemplateViajeBinding;
import com.angel.juan.app_tuviaje.util.Data;

//Adapter el cual vincula la lista RecyclerView, por medio del View Holder,
//Tiene 3 metodos

public class ViajeAdapter extends RecyclerView.Adapter<ViajeAdapter.ViajeViewHolder>{

    //Defino el metodo con esta clase interface, este es el contrato
    //Defino el parqueadero que debe tener en este caso los metodos
    public interface OnViajeListener{
        void onViaje(View v);
    }

    LayoutInflater inflater;//Para el constructor del Adaptador
    OnViajeListener onViajeListener;//declaro un objeto de la inteface


    public ViajeAdapter(LayoutInflater inflater, OnViajeListener onViajeListener) {
        this.onViajeListener = onViajeListener;//se lo asigno a la variable o el objeto declarado
        this.inflater = inflater;
    }

    //se retorna con las vistas, se llama por vista
    @Override
    public ViajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Hacemos el inflate, obtengo el layout, el contenedor y el false para que no este anidado
        View v = inflater.inflate(R.layout.template_viaje, parent, false);
        //creamos el ViewHolder
        ViajeViewHolder holder = new ViajeViewHolder(v);
        return holder;
    }

    //le coloca los datos a la vista
    @Override
    public void onBindViewHolder(ViajeViewHolder holder, int position) {
        holder.binding.setViajes(Data.data.get(position));
        //fijo la variable handler
        holder.binding.setHandler(this);
    }

    //tamaño de los datos
    @Override
    public int getItemCount() {
        return Data.data.size();
    }

    //cada ves que le demos click invocamos el metodo y le mandamos la informacion
    public void onClickViaje(View v){
        onViajeListener.onViaje(v);

    }



    public static class ViajeViewHolder extends RecyclerView.ViewHolder{

        TemplateViajeBinding binding;

        public ViajeViewHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }
    }
}
