package com.example.jogodaforca;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class TelaJogo02 extends AppCompatActivity implements View.OnClickListener {

    private Button btnCadastro, btnListar;
    private EditText caixaPalarvra;
    private RadioGroup grupo;
    private String categoriaSelecionada, palavraDigitada;
    private BD bd;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogo02);
        btnCadastro = findViewById(R.id.button28);
        btnCadastro.setOnClickListener(this);
        btnListar = findViewById(R.id.button29);
        btnListar.setOnClickListener(this);
        categoriaSelecionada = "Objeto Escolar";
        caixaPalarvra = findViewById(R.id.editTextText);
        grupo = findViewById(R.id.id_grupo);
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int i) {
                if(group == grupo){
                    if(i == R.id.radioButton6)
                    {
                        categoriaSelecionada = "Frutas";
                    }
                    if(i == R.id.radioButton7)
                    {
                        categoriaSelecionada = "Ferrramentas";
                    }
                    if(i == R.id.radioButton8)
                    {
                        categoriaSelecionada = "Objeto Escolar";
                    }
                    if(i == R.id.radioButton9)
                    {
                        categoriaSelecionada = "Eletrodoméstico";
                    }
                    if(i == R.id.radioButton10)
                    {
                        categoriaSelecionada = "Esportes";
                    }
                }
                Toast.makeText(TelaJogo02.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        bd = new BD(TelaJogo02.this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnCadastro){
            palavraDigitada = caixaPalarvra.getText().toString();
            Palavra p =new Palavra();
            p.setNome(palavraDigitada);
            p.setCategoria(categoriaSelecionada);
            bd.salvarPalavra(p);
            Toast.makeText(this,"Salvo!",Toast.LENGTH_SHORT).show();
        }
        if(v == btnListar){
            ArrayList<Palavra> lista = new ArrayList<Palavra>();
            lista = bd.listarPalavras();
            String stringao = new String();
            for(int  i =0; i<lista.size();i++){
                stringao += lista.get(i).getNome() +"|"+lista.get(i).getCategoria()+"";
            }
            Toast.makeText(this,stringao,Toast.LENGTH_SHORT).show();
            }
    }
}