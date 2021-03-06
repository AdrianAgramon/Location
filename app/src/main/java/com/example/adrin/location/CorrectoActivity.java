package com.example.adrin.location;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CorrectoActivity extends AppCompatActivity {

    public static int resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correcto);

        final int partidas = getIntent().getExtras().getInt("Partidas")-1;

        final TextView puntuacion = (TextView) findViewById(R.id.puntuacionText) ;
        TextView partRest = (TextView) findViewById(R.id.TextPartidas);

       resultado+=getIntent().getExtras().getInt("score");

       // puntuacion.setText(" "+resultado+" ");

        partRest.setText(""+partidas+"");
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(0, resultado);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                puntuacion.setText(String.valueOf(animation.getAnimatedValue()));
            }
        });
        animator.setEvaluator(new TypeEvaluator<Integer>() {
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return Math.round(startValue + (endValue - startValue) * fraction);
            }
        });
        animator.setDuration(1000);
        animator.start();

        Button otra = (Button) findViewById(R.id.restartbutton);

        otra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int min = 1;
                int max = 12;

                Random r = new Random();
                int number = r.nextInt(max - min + 1) + min;
                final String result = String.valueOf(number);


                switch (result) {
                    case "1": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Madrid");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();

                        break;
                    }
                    case "2": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Berlin");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();

                        break;
                    }
                    case "3": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Roma");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();

                        break;
                    }
                    case "4": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Paris");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();

                        break;
                    }
                    case "5": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Pompeya");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();
                        break;
                    }
                    case "6": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Valencia");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();

                        break;
                    }
                    case "7": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Venecia");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();
                        break;
                    }
                    case "8": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Dublin");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();
                        break;
                    }
                    case "9": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Praga");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();
                        break;
                    }
                    case "10": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Barcelona");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();
                        break;
                    }
                    case "11": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Londres");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        break;
                    }
                    case "12": {

                        Intent reg = new Intent(CorrectoActivity.this, EuropaPartida.class);
                        reg.putExtra("Ciudad", "Basilea");
                        reg.putExtra("Partidas", partidas);
                        startActivity(reg);
                        finish();
                        break;
                    }
                    default:
                        System.out.println("ERROR");
                        break;
                }

            }
        });

    }
}
