package com.projeto.emotions.emotions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

public void RegistarEmocao (View view){

    Intent intent = new Intent(this,RegistarEmocao.class);

    startActivity(intent);
}

    public void ConsultarEmocao (View view){

        Intent intent = new Intent(this,ConsultarRegistoDiario.class);

        startActivity(intent);
    }

    public void InserirEmocao (View view){

        Intent intent = new Intent(this,Inserir_Emocao.class);

        startActivity(intent);
    }
}
