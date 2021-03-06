package com.example.adrin.location;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adrin.location.ResideMenu.MainActivity;
import com.example.adrin.location.welcomeActivity;
import com.example.adrin.location.model.Usuario;
import com.example.adrin.location.service.UserClient;
import com.google.android.gms.vision.text.Text;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FinalPartida extends AppCompatActivity {

    String baseUrl = "https://dry-sierra-56010.herokuapp.com/location/api/GestionDeJuego/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_partida);

        final int scoreFinal = CorrectoActivity.resultado;


        final TextView finalScore = (TextView) findViewById(R.id.resultadoFinal);

        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(0, scoreFinal);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                finalScore.setText(String.valueOf(animation.getAnimatedValue()));
            }
        });
        animator.setEvaluator(new TypeEvaluator<Integer>() {
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return Math.round(startValue + (endValue - startValue) * fraction);
            }
        });
        animator.setDuration(1000);
        animator.start();

        Button end = (Button) findViewById(R.id.buttonEnd);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent reg = new Intent(FinalPartida.this, selectWhere.class);
//             //   reg.putExtra("Score", scoreFinal);
//                startActivity(reg);

                //Envío de puntuación al servidor.
               sendNetworkPuntuacion( scoreFinal);
            }
        });



}

    private void sendNetworkPuntuacion(int scoreFinal) {

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("" + baseUrl).addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        String usernameFinal = LoginActivity.usernameFinal;
        Log.d("Usuario: " , usernameFinal);

        //Obtenemos el cliente y llamamos un request al objeto
        UserClient client = retrofit.create(UserClient.class);
        Map<String, Integer> puntuacion = new HashMap<>();
        puntuacion.put("puntuacion", scoreFinal);
        Call<Boolean> envioPuntuacion= client.envioPuntuacion(usernameFinal,puntuacion);

        envioPuntuacion.enqueue(new Callback<Boolean>() {
            @SuppressLint("ResourceType")
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                if(response.code()== 200) {

                    Toast.makeText(FinalPartida.this, "Puntuación enviada correctamente! :D", Toast.LENGTH_SHORT).show();

                   Intent reg = new Intent(FinalPartida.this, MainActivity.class);
                   startActivity(reg);
                    finish();
                }else if (response.code()==400){
                    Toast.makeText(FinalPartida.this, "No se envió la puntuación....", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(FinalPartida.this, "Puntuación enviada correctamente! :D", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

                Toast.makeText(FinalPartida.this, "Algo salió mal...  :( ", Toast.LENGTH_LONG).show();

            }
        });

    }


}