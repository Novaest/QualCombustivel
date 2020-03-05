package com.example.qualcombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getPercentInstance();

    private TextView GasTextView;
    private TextView priceEthanolTextView;
    private TextView betterUse;


     private ImageView img;


    private double  priceGasoline    = 3.0;
    private double  priceEthanol   = 3.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.wichView);
        betterUse =
                findViewById(R.id.betterUse);


        GasTextView =
                findViewById(R.id.GasTextView);
        priceEthanolTextView =
                findViewById(R.id.priceEthanolTextView);



        //Gasolina
        EditText GasEditText =
                findViewById(R.id.GasEditText);

        SeekBar gasolineSeekBar =
                findViewById(R.id.gasolineSeekBar);

        //ethanol
        EditText ethanolEditText =
                findViewById(R.id.ethanolEditText);

        SeekBar ethanolSeekBar =
                findViewById(R.id.ethanolSeekBar);


        gasolineSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                priceGasoline = progress / 100D;
                GasTextView.setText(currencyFormat.format(priceGasoline));
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        ethanolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                priceEthanol = progress / 100D;
                priceEthanolTextView.setText(currencyFormat.format(priceEthanol));
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        GasEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    priceGasoline = Double.parseDouble(s.toString());
                    calcular();
                }
                catch (NumberFormatException e){
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ethanolEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    priceEthanol = Double.parseDouble(s.toString());
                    calcular();
                }
                catch (NumberFormatException e){

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void calcular (){
        double total = priceEthanol  / priceGasoline;

        if(total >= 0.7){
           img.setImageResource(R.drawable.gasosa);
            betterUse.setText(R.string.gasolina);
        }
        else{
            img.setImageResource(R.drawable.ethanol);
            betterUse.setText(R.string.ethanol);
        }

    }

}
