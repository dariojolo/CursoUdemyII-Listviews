package com.dariojolo.cursoudemyii_listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> nombres;

    public MyAdapter(Context context, int layout, List<String>nombres){
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
    }
    @Override
    public int getCount() {
        return this.nombres.size();
    }

    @Override
    public Object getItem(int position) {
        return this.nombres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Metodo CLAVE!!!!!

        //ViewHolder pattern
        ViewHolder holder;

        if (convertView == null) {
            //inflamos la vista que nos ha llegado con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            //Referenciamos el elemento a modificar y lo rellenamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textito);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }


        //Nos traemos el valor actual dependiente de la posicion
        String currentName = nombres.get(position);

        holder.nameTextView.setText(currentName);
        //Devolvemos la vista inflada y modificada con nuestros datos
        return convertView;

    }
    static class ViewHolder{
        private TextView nameTextView;

    }
}
