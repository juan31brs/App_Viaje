package com.angel.juan.app_tuviaje.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.angel.juan.app_tuviaje.databinding.TemplateReservaBinding;
import com.angel.juan.app_tuviaje.models.Reserva;

import java.util.List;

import com.angel.juan.app_tuviaje.R;




public class ReservaAdapter extends BaseAdapter {

    LayoutInflater inflater;
    List<Reserva> data;

    public ReservaAdapter(LayoutInflater inflater, List<Reserva> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null)
            v = inflater.inflate(R.layout.template_reserva, parent, false);

        TemplateReservaBinding binding = DataBindingUtil.bind(v);
        binding.setReserva(data.get(position));

        return binding.getRoot();
    }

    public void setData(List<Reserva> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
