package com.example.projetoandroidfaculdade.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetoandroidfaculdade.R;
import com.example.projetoandroidfaculdade.debug.DebugActivity;

public class PessoaActivity extends DebugActivity {

    EditText txtNome;
    EditText txtSobreNome;
    EditText txtEmail;
    EditText txtFone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa);
    }

    public void exibir(View view) {
        //------------------- Entrada
        txtNome = findViewById(R.id.txtNome);
        txtSobreNome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtFone = findViewById(R.id.txtFone);

        //------------------ Processamento
        String nome, sobrenome, email, telefone;
        nome = txtNome.getText().toString();
        sobrenome = txtSobreNome.getText().toString();
        email = txtEmail.getText().toString();
        telefone = txtFone.getText().toString();

        //------------------ Saída
        String dados;
        dados = String.format("Os valores informados foram: \n%s\n%s\n%s\n%s", nome, sobrenome, email, telefone);

        //------------------ Exibir Dados
        Toast.makeText(getApplication(), dados, Toast.LENGTH_LONG).show();
    }
}