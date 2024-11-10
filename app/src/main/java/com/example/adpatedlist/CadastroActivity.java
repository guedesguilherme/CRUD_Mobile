package com.example.adpatedlist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextNome, editTextValor;
    private Button buttonSalvar;
    private ListView listViewItens;
    private ArrayList<ItemModel> listaItens; // Agora com a classe importada
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Inicializando os componentes
        editTextNome = findViewById(R.id.edit_text_nome);
        editTextValor = findViewById(R.id.edit_text_valor);
        buttonSalvar = findViewById(R.id.button_salvar);
        listViewItens = findViewById(R.id.list_view_itens);

        // Inicializando a lista de itens e o adaptador
        listaItens = new ArrayList<>();
        itemAdapter = new ItemAdapter(this, listaItens);
        listViewItens.setAdapter(itemAdapter);

        // Definindo ação do botão "Salvar"
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeItem = editTextNome.getText().toString();
                String valorItem = editTextValor.getText().toString();

                if (!nomeItem.isEmpty() && !valorItem.isEmpty()) {
                    // Adiciona o item à lista
                    int imagem = R.drawable.image1; // Substitua com a imagem desejada
                    ItemModel item = new ItemModel(imagem, nomeItem, valorItem); // Verifique se está criando corretamente
                    listaItens.add(item);
                    itemAdapter.notifyDataSetChanged(); // Atualiza o ListView

                    // Limpa os campos de entrada
                    editTextNome.setText("");
                    editTextValor.setText("");
                }
            }
        });
    }
}
