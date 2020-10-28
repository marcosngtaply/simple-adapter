package com.example.projetoandroidfaculdade.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.projetoandroidfaculdade.R;
import com.example.projetoandroidfaculdade.adapter.PostAdapter;
import com.example.projetoandroidfaculdade.debug.DebugActivity;
import com.example.projetoandroidfaculdade.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostActivity extends DebugActivity {

    EditText txtUserId;
    EditText txtTitle;
    EditText txtBody;
    ListView listViewPost;

    /*SimpleAdapter
      Trabalha com List<HashMap>*/
    List<HashMap<String, String>> lista = new ArrayList<>(); //pega a lista de dados enviada pelo usuário
    /*ArrayAdapter
      Trabalha apenas com a Lista o objeto preterido.(Post)*/
    List<Post> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    public void adicionarPost(View view) {
        //------------------- Entrada
        txtUserId = findViewById(R.id.txtUserId);
        txtTitle = findViewById(R.id.txtTitle);
        txtBody = findViewById(R.id.txtBody);

        //------------------ Processamento
        String userId, title, body;
        userId = txtUserId.getText().toString();
        title = txtTitle.getText().toString();
        body = txtBody.getText().toString();

//        simpleAdapter(userId, title, body);
//        arrayAdapter(userId, title, body);
        baseAdapter(userId, title, body);
    }

    /**
     * BaseAdapter método responsável de exibir registro de forma customizada e enxuta (prática)
     * @param userId
     * @param title
     * @param body
     */
    private void baseAdapter(String userId, String title, String body) {
        preencherObjetoLista(userId, title, body);

        listViewPost = findViewById(R.id.listViewPost);

        PostAdapter postAdapter = new PostAdapter(this, postagens);
        listViewPost.setAdapter(postAdapter);
    }
    /**
     * ArrayAdapter trabalha com uma lista 'tipada'
     * @param userId
     * @param title
     * @param body
     */
    public void arrayAdapter(String userId, String title, String body) {
        preencherObjetoLista(userId, title, body);

        //Procurar a refência da listaViewna tela desta Atividade para imprimir dados na lista;
        listViewPost = findViewById(R.id.listViewPost);

        //Imprimir o ArrayAdapter
        ArrayAdapter<Post> arrayAdapter = new ArrayAdapter<Post>(this, android.R.layout.simple_list_item_1, postagens);
        listViewPost.setAdapter(arrayAdapter);
    }

    private void preencherObjetoLista(String userId, String title, String body) {
        //Criar Objeto
        Post post = Post.builder()
                .userId(Integer.parseInt(userId))
                .title(title)
                .body(body)
                .build();

        //Adicionar o objeto na lista de post
        postagens.add(post);
    }

    private void simpleAdapter(String userId, String title, String body) {
        //Agora se inicia o trabalho de SimpleAdapter
        //SimpleAdapter precisa de um List<? extends HasMap> nesse caso Map<String, ?>
        /*
        List<String> tal = new ArrayList<>(); //List trabalha com indice NUMÉRICO (posição 0, 1, 2, 3)
        tal.add("Uma String");// 0
        tal.add("Uma String");// 1
        tal.add("Uma String");// 2
        tal.add("Uma String");// 3

        HashMap<String, String> mapExemplo = new HashMap<>(); //HashMap trabalha com indice "associativo", geralmente ("index", "valor")
        mapExemplo.put("index1", "valor1");
        mapExemplo.put("index2", "valor2");
        mapExemplo.put("index3", "valor3");
        mapExemplo.put("index4", "valor4");

        mapExemplo.get("index3"); //retorna valor3
        */
        HashMap<String, String> map = new HashMap<>(); //armazena as informações do usuário num map (mapa de valores)
        map.put("userId", userId);
        map.put("title", title);
        map.put("body", body);

        lista.add(map);

        //SimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to)
        //Mapear o layout do tipo "item" com os dados contidos dentro do List<HashMap<String, String>>

        //------------------ Saída
        String[] from = {"userId", "title", "body"}; //chaves do meu Map
        int[] to = {R.id.txtItemUserId, R.id.txtItemTitle, R.id.txtItemBody}; //ids do layout tipo do "item"

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lista, R.layout.item_post, from, to);

        //Procurar a referência da listView para que essa possa imprimir os dados utilizando o padrão ADAPTER
        //------------------ Exibir Dados
        listViewPost = findViewById(R.id.listViewPost);
        listViewPost.setAdapter(simpleAdapter);
    }
}