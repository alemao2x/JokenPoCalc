package com.example.gian.exercicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends SwipeAc {
    String P1, P2;
    Double esc;
    Button btnPedraP1, btnPapelP1, btnTesouraP1, btnResult;
    TextView txtResult, txtPC, txtP1;
    Intent tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botoes();
        view();
        funcionamentoBotoes();

    }

    @Override
    protected void onSwipeRight() {
        tela = new Intent(MainActivity.this, CalcActivity.class);
        finish();
        startActivity(tela);
    }

    @Override
    protected void onSwipeLeft() {
        tela = new Intent(MainActivity.this, CalcActivity.class);
        finish();
        startActivity(tela);
    }

    public void botoes() {
        btnPedraP1 = (Button) findViewById(R.id.btnPedraP1);
        btnPapelP1 = (Button) findViewById(R.id.btnPapelP1);
        btnTesouraP1 = (Button) findViewById(R.id.btnTesouraP1);
        btnResult = (Button) findViewById(R.id.btnResult);
    }

    public void funcionamentoBotoes() {
        btnTesouraP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                P1 = "Tesoura";
                txtP1.setText("O jogador escolheu Tesoura!");
                txtPC.setText("Escolha celular");
                escolhaPC();
            }
        });
        btnPapelP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                P1 = "Papel";
                txtP1.setText("O jogador escolheu Papel!");
                txtPC.setText("Escolha celular");
                escolhaPC();
            }
        });
        btnPedraP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                P1 = "Pedra";
                txtP1.setText("O jogador escolheu Pedra!");
                txtPC.setText("Escolha celular");
                escolhaPC();
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPC.setText("O computador escolheu " + P2 + "!");
                jokenPo();
            }
        });
    }

    public void view() {
        txtResult = (TextView) findViewById(R.id.txtResult);
        txtPC = findViewById(R.id.txtViewPC);
        txtP1 = findViewById(R.id.txtPlayer);
    }

    public void escolhaPC() {
        esc = Math.random();
        if (esc <= 0.34) {
            P2 = "Pedra";
        } else if (esc <= 0.67) {
            P2 = "Papel";
        } else {
            P2 = "Tesoura";
        }
    }

    public void jokenPo() {
        if (P1 == P2) {
            txtResult.setText("O resultado é um empate!");
        } else if (P1 == "Pedra") {
            if (P2 == "Tesoura") {
                txtResult.setText("Pedra vence!");
            } else {
                txtResult.setText("Papel vence!");
            }
        } else if (P1 == "Papel") {
            if (P2 == "Pedra") {
                txtResult.setText("Papel vence!");
            } else {
                txtResult.setText("Tesoura vence!");
            }
        } else if (P1 == "Tesoura") {
            if (P2 == "Pedra") {
                txtResult.setText("Pedra vence!");
            } else {
                txtResult.setText("Tesoura vence!");
            }
        }
    }
}