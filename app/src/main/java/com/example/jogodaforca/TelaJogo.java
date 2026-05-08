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
    private TextView txAcerto, txErro;
    private int acerto, erro;
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
        acerto = 0;
        erro = 0;
        listaImagem = new ArrayList<Integer>();
        listaImagem.add(R.drawable.forca_1_9);
        listaImagem.add(R.drawable.forca_2_9);
        listaImagem.add(R.drawable.forca_3_9);
        listaImagem.add(R.drawable.forca_4_9);
        listaImagem.add(R.drawable.forca_5_9);
        listaImagem.add(R.drawable.forca_6_9);
        listaImagem.add(R.drawable.forca_7_9);
        listaImagem.add(R.drawable.forca_9_9);
        listaImagem.add(R.drawable.forca_10_9);
        listaImagem.add(R.drawable.forca_11_9);

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
        txAcerto = findViewById(R.id.textAcerto);
        txErro = findViewById(R.id.textErro);

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
        indiceImagem = 0;
        acerto = 0;
        erro = 0;
        //palavra recebe uma nova sorteada
        palavra = sorteiaPalavra();
        //instancio o vetor de char pela qtd de caracteres da palavra
        estado = new char[palavra.length()];
        //monta o vetor de char com _ (oculto)
        for(int i =0; i<estado.length;i++){
            estado[i] = '_';
        }
        atualizaTexto();

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
    public void atualizaTexto(){
        //preparar o texto para exibir, incluindo um espaço entre os _
        String temp = "";
        for (int j=0; j<estado.length;j++){
            temp += estado[j]+ "";
        }
        //exibe a palavra
        texto.setText(palavra);
    }
    public void verificaLetra(char c){
        boolean status = false;
        for(int i = 0; i<palavra.length();i++){
           if(palavra.charAt(i)==c){
               status = true;
               estado[i] = c;
           }
        }
        if(status == false){
            atualizaImagem();
            erro++;
            txErro.setText(Integer.toString(erro)+"/"+Integer.toString(listaImagem.size()));
        }else{
            atualizaTexto();
            acerto++;
            txAcerto.setText(Integer.toString(acerto));
        }
    }

    public void checaTermino(){
        boolean verifica = false;
        for (int i = 0; i<estado.length; i++){
            if(estado[i]=='_'){
                verifica = true;
            }
        }
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        b.setEnabled(false);
        verificaLetra(b.getText().toString().charAt(0));
    }
}