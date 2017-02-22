package com.example.adrin.location;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class EuropeActivity extends AppCompatActivity {


    public static int partidas =5;
    public static int score;
    int lastResult = CorrectoActivity.resultado;
    int bestResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_europe);

        final TextView bestScore = (TextView) findViewById(R.id.bestResult);


        if (lastResult ==0){
           int bestResult=lastResult;
        }else if (bestResult < lastResult){
            bestResult=lastResult;
        }





        bestScore.setText(" "+bestResult +" ");

        final Button botonPartida = (Button) findViewById(R.id.TryAgainButton);

        botonPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int score = 0;

                int min = 1;
                int max = 12;

                Random r = new Random();
                int number = r.nextInt(max - min + 1) + min;
                final String result = String.valueOf(number);

                if (result.equals("1")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Madrid");
                    // reg.putExtra("Score", score);
                    startActivity(reg);
                } else if (result.equals("2")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Paris");
                    //  reg.putExtra("Score", score);
                    startActivity(reg);

                } else if (result.equals("3")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Basilea");
                    //  reg.putExtra("Score", score);
                    startActivity(reg);

                } else if (result.equals("4")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Barcelona");
                    //  reg.putExtra("Score", score);
                    startActivity(reg);

                } else if (result.equals("5")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Berlin");
                    // reg.putExtra("Score", score);
                    startActivity(reg);

                } else if (result.equals("6")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Dublin");
                    //   reg.putExtra("Score", score);
                    startActivity(reg);


                } else if (result.equals("7")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Roma");
                    //  reg.putExtra("Score", score);
                    startActivity(reg);

                } else if (result.equals("8")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Pompeya");
                    // reg.putExtra("Score", score);
                    startActivity(reg);
                } else if (result.equals("9")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Praga");
                    //  reg.putExtra("Score", score);
                    startActivity(reg);
                } else if (result.equals("10")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Cuidad", "Valencia");
                    ///  reg.putExtra("Score", score);
                    startActivity(reg);
                } else if (result.equals("11")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Venecia");
                    // reg.putExtra("Score", score);
                    startActivity(reg);
                } else if (result.equals("12")) {

                    Intent reg = new Intent(EuropeActivity.this, EuropaPartida.class);
                    reg.putExtra("Ciudad", "Londres");
                    //  reg.putExtra("Score", score);
                    startActivity(reg);

                } else {
                    System.out.println("ERROR");
                }
            }
        });

    }


}