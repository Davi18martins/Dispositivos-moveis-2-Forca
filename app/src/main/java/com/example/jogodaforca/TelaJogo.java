package com.example.jogodaforca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TelaJogo extends AppCompatActivity implements View.OnClickListener {

    private ImageView imagem;
    private ArrayList<Integer> listaImagem;
    private ArrayList<String> listaPalavras;
    private int indiceImagem;
    private Button b1;
    private String palavra;
    private char[] estado;
    private TextView texto;
    private ArrayList<Integer> listaIDsButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogo);

        imagem = findViewById(R.id.imageView2);
        indiceImagem = 0;
        listaImagem = new ArrayList<Integer>();
        listaImagem.add(R.drawable.forca_1_9);
        listaImagem.add(R.drawable.forca_2_9);
        listaImagem.add(R.drawable.forca_3_9);
        listaImagem.add(R.drawable.forca_4_9);
        listaImagem.add(R.drawable.forca_5_9);
        listaImagem.add(R.drawable.forca_6_9);
        listaImagem.add(R.drawable.forca_7_9);
        listaImagem.add(R.drawable.forca_9_9);

        b1 = findViewById(R.id.button2);
        b1.setOnClickListener(this);

        listaPalavras = new ArrayList<String>();
        listaPalavras.add("CASA");
        listaPalavras.add("CAVALO");
        listaPalavras.add("MESA");
        listaPalavras.add("CARRO");
        listaPalavras.add("ASFALTO");
        listaPalavras.add("QUEIJO");
        listaPalavras.add("PESSOA");
        listaPalavras.add("HOMEM");
        listaPalavras.add("MULHER");
        listaPalavras.add("RODA");
        listaPalavras.add("RECRUTA");
        listaPalavras.add("RUA");
        listaPalavras.add("INJEÇÃO");
        listaPalavras.add("GUERREIRO");
        listaPalavras.add("MOTO");

        texto = findViewById(R.id.textView3);
        palavra = new String();

        listaIDsButtons = new ArrayList<Integer>();
        listaIDsButtons.add(R.id.button2);
        listaIDsButtons.add(R.id.button3);
        listaIDsButtons.add(R.id.button4);
        listaIDsButtons.add(R.id.button5);
        listaIDsButtons.add(R.id.button6);
        listaIDsButtons.add(R.id.button7);
        listaIDsButtons.add(R.id.button8);
        listaIDsButtons.add(R.id.button9);
        listaIDsButtons.add(R.id.button10);
        listaIDsButtons.add(R.id.button11);
        listaIDsButtons.add(R.id.button12);
        listaIDsButtons.add(R.id.button13);
        listaIDsButtons.add(R.id.button14);
        listaIDsButtons.add(R.id.button15);
        listaIDsButtons.add(R.id.button16);
        listaIDsButtons.add(R.id.button17);
        listaIDsButtons.add(R.id.button18);
        listaIDsButtons.add(R.id.button19);
        listaIDsButtons.add(R.id.button20);
        listaIDsButtons.add(R.id.button21);
        listaIDsButtons.add(R.id.button22);
        listaIDsButtons.add(R.id.button23);
        listaIDsButtons.add(R.id.button24);
        listaIDsButtons.add(R.id.button25);
        listaIDsButtons.add(R.id.button26);
        listaIDsButtons.add(R.id.button27);

        for(int i = 0; i<listaIDsButtons.size();i++){
            Button b = findViewById(listaIDsButtons.get(i));
            b.setOnClickListener(this);
        }

        inicializaJogo();
    }

    public void inicializaJogo(){
        //volto a imagem sem o boneco enforcado
        imagem.setImageResource(R.drawable.forca_0_9);
        //palavra recebe
        palavra = sorteiaPalavra();
        //
        estado = new char[palavra.length()];
        //
        for(int i =0; i<estado.length;i++){
            estado[i] = '_';
        }
        //
        String temp = "";
        for (int j=0; j<estado.length;j++){
            temp += estado[j]+ "";
        }
        //
        texto.setText(palavra);

        for(int i = 0; i<listaIDsButtons.size();i++){
            Button b = findViewById(listaIDsButtons.get(i));
            b.setEnabled(true);
        }
    }

    public String sorteiaPalavra(){
        String sorteado;
        Collections.shuffle(listaPalavras);
        sorteado = listaPalavras.get(0);
        return sorteado;
    }

    public void atualizaImagem(){
        imagem.setImageResource(listaImagem.get(indiceImagem));
        indiceImagem++;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        b.setEnabled(false);
        texto.setText(b.getText().toString());
    }
}