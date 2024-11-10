package com.example.adpatedlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private List<ItemModel> itemList;

    public ItemAdapter(Context context, List<ItemModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ItemModel item = itemList.get(position);

        // Referências para os elementos da UI
        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView textView = convertView.findViewById(R.id.item_text);
        TextView valueView = convertView.findViewById(R.id.item_value);

        // Passando diretamente o ID da imagem para o setImageResource
        imageView.setImageResource(item.getImagem());  // Exibindo a imagem

        // Setando o texto e valor
        textView.setText(item.getTexto());
        valueView.setText(item.getValor());

        return convertView;
    }
}
