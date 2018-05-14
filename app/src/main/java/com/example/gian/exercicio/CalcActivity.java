package com.example.gian.exercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends SwipeAc {
    Button calc;
    TextView nota;
    EditText lista, prova, proj;
    Double l1,p1,proj1,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        containers();
        funcionamento();
    }

    @Override
    protected void onSwipeRight() {
        Intent tela = new Intent(CalcActivity.this, MainActivity.class);
        finish();
        startActivity(tela);
    }

    @Override
    protected void onSwipeLeft() {
        Intent tela = new Intent(CalcActivity.this, MainActivity.class);
        finish();
        startActivity(tela);
    }
    public void containers() {
        calc = findViewById(R.id.btnCalc);
        nota = findViewById(R.id.txtNota);
        lista = findViewById(R.id.edtLista);
        prova = findViewById(R.id.edtProva);
        proj = findViewById(R.id.edtProjeto);
    }
    public void funcionamento(){
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton();
            }
        });
    }
    public void clickButton(){
        p1 = Double.valueOf(prova.getText().toString());
        l1 = Double.valueOf(lista.getText().toString());
        proj1 = Double.valueOf(proj.getText().toString());
        result = ((p1*0.2)+(l1*0.3)+(proj1*0.5) );
        nota.setText(result.toString());
    }
}
