package com.example.adpatedlist;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ItemAdapter itemAdapter;
    private List<ItemModel> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando o ListView
        listView = findViewById(R.id.list_view_main);

        // Inicializando a lista de itens
        itemList = new ArrayList<>();

        // Configurando o adapter com a lista de itens
        itemAdapter = new ItemAdapter(this, itemList);
        listView.setAdapter(itemAdapter);

        // Recuperando dados do Firebase
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("items");  // Referência ao nó "items"

        // Listener para mudanças no banco de dados
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                itemList.clear();  // Limpa a lista antes de adicionar os novos dados

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Obtendo dados do Firebase e criando o ItemModel
                    String nomeItem = snapshot.child("nome").getValue(String.class);
                    String valorItem = snapshot.child("valor").getValue(String.class);
                    String imagemNome = snapshot.child("imagem").getValue(String.class); // Nome da imagem

                    // Obtendo o ID do recurso da imagem
                    int imagemId = getResources().getIdentifier(imagemNome, "drawable", getPackageName());

                    // Criando o item e adicionando à lista
                    // Passando o ID da imagem como um inteiro (imagemId)
                    ItemModel item = new ItemModel(imagemId, nomeItem, valorItem);
                    itemList.add(item);  // Adiciona o item à lista
                }

                itemAdapter.notifyDataSetChanged();  // Notifica o adapter para atualizar a lista
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Lida com erros de leitura no banco de dados
            }
        });
    }
}
