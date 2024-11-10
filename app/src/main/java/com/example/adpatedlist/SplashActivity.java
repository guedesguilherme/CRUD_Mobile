package com.example.adpatedlist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Redireciona para a Tela de Cadastro após 3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, CadastroActivity.class);
                startActivity(intent);
                finish(); // Fecha a SplashActivity
            }
        }, 3000); // 3 segundos de exibição da Splash
    }
}
