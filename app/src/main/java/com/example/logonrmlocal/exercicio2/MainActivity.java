package com.example.logonrmlocal.exercicio2;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultadoGasTextView;

    private SeekBar gasolinaSeekbar;

    private TextView resultadoEtanolTextView;

    private SeekBar etanolSeekBar;

    private TextInputEditText answerTextInputEditText;

    private ImageView combustivelImageView;

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private double valorGasolina = 0.0;

    private double valorEtanol = 0.0;

    public class SeekbarChangeListener implements SeekBar.OnSeekBarChangeListener{
        @Override
        public void onProgressChanged(SeekBar seekBar, int aumento, boolean fromUser) {

            if (seekBar.getId() == R.id.gasolinaSeekBar) {
                valorGasolina = aumento / 1.0;
                resultadoGasTextView.setText(currencyFormat.format(valorGasolina));
            } else if (seekBar.getId() == R.id.etanolSeekBar) {
                valorEtanol = aumento / 1.0;
                resultadoEtanolTextView.setText(currencyFormat.format(valorEtanol));
            }
            calculoCombustivel();

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    }

    private void calculoCombustivel() {
        if ((valorEtanol/valorGasolina) >= 0.7) {
            answerTextInputEditText.setText(R.string.gasolina);
            combustivelImageView.setImageResource(R.drawable.combustivel);
        } else {
            answerTextInputEditText.setText(R.string.etanol);
            combustivelImageView.setImageResource(R.drawable.combustivel_et);
        }

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultadoGasTextView = findViewById(R.id.resultadoGasTextView);
        gasolinaSeekbar = findViewById(R.id.gasolinaSeekBar);
        resultadoEtanolTextView = findViewById(R.id.resultadoEtanolTextView);
        etanolSeekBar = findViewById(R.id.etanolSeekBar);
        answerTextInputEditText = findViewById(R.id.answerTextInputEditText);
        combustivelImageView = findViewById(R.id.combustivelImageView);


        resultadoGasTextView.setText(currencyFormat.format(0));
        resultadoEtanolTextView.setText(currencyFormat.format(0));

        gasolinaSeekbar.setOnSeekBarChangeListener(new SeekbarChangeListener());
        etanolSeekBar.setOnSeekBarChangeListener(new SeekbarChangeListener());




    }
}
