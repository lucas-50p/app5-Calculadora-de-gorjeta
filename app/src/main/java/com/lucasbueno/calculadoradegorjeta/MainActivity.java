package com.lucasbueno.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekGorjeta;

    private double porcentagem = 0; //porcetagem inicial da gorjeta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textGorjeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal =findViewById(R.id.textTotal);
        seekGorjeta = findViewById(R.id.seekGorjeta);


        //Controlar seekbar
        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = seekBar.getProgress();
                textPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
    //Recuperar valor digitado
    public  void calcular(){
        Double valorDigitado = Double.parseDouble(editValor.getText().toString());

    //calcular a gorjeta total
        double gorjeta = valorDigitado * (porcentagem/100);
        double total = gorjeta + valorDigitado;

     //exibe a gorjeta total
     textGorjeta.setText("R$ " + Math.round(gorjeta) );
     textTotal.setText("R$ " + total);
    }


}
