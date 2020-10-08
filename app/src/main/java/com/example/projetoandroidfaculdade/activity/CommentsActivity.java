package com.example.projetoandroidfaculdade.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.projetoandroidfaculdade.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommentsActivity extends AppCompatActivity {

    EditText txtPostId;
    EditText txtNome;
    EditText txtEmail;
    EditText txtBody;
    ListView listViewComment;

    List<HashMap<String, String>> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
    }

    public void adicionarComment(View view) {
        //------------------- Entrada
        txtPostId = findViewById(R.id.txtPostId);
        txtNome = findViewById(R.id.txtCommentNome);
        txtEmail = findViewById(R.id.txtCommentEmail);
        txtBody = findViewById(R.id.txtCommentBody);

        //------------------ Processamento
        String postId, name, email, body;
        postId = txtPostId.getText().toString();
        name = txtNome.getText().toString();
        email = txtEmail.getText().toString();
        body = txtBody.getText().toString();

        HashMap<String, String> map = new HashMap<>();
        map.put("postId", postId);
        map.put("name", name);
        map.put("email", email);
        map.put("body", body);

        lista.add(map);

        //------------------ Saída
        String[] from = {"postId", "nome", "email", "body"};
        int[] to = {R.id.txtItemPostId, R.id.txtItemNome, R.id.txtItemEmail, R.id.txtItemBody};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lista, R.layout.item_comment, from, to);


        //------------------ Exibir Dados
        listViewComment = findViewById(R.id.listViewComment);
        listViewComment.setAdapter(simpleAdapter);
    }
}