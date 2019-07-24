package com.projeto.emotions.emotions;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class Detalhes extends AppCompatActivity {

    ListView lv;
    ArrayList<String> lista;
    ArrayAdapter adapter;
    DBHelper2 db;
    SQLiteDatabase database;
    String dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        lv = ( ListView) findViewById(R.id.lista);

        db = new DBHelper2(getApplicationContext());


        lista = Mostar();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);

        lv.setAdapter(adapter);

    }


    // Criação de uma listView para listar horas e emoções de uma determinada data
    public ArrayList Mostar() {

        ArrayList<String> lista = new ArrayList<>();

        Intent intent = getIntent();

        // Recebe a data selecionada e procura na base de dados
        if (intent != null) {

            Bundle bundle = intent.getExtras();

            if (bundle != null) {

                dia = bundle.getString("dia");
                mes = bundle.getString("mes");
                ano = bundle.getString("ano");
            }
        }

        database = db.getReadableDatabase();

            String q = "SELECT R.Hora,E.Name FROM Registo R,Emocao E where R.Valor=E.Valor" + " AND " + "dia=" + dia + " AND " + "mes=" + mes + " AND " + "ano=" + ano + ";";

        Cursor registos = database.rawQuery(q, null);

        // Se existir informação esta é listada
        if (registos.moveToFirst()) {
            do {

                lista.add("Hora: " + registos.getString(registos.getColumnIndex("Hora")));
                lista.add("Emoção: " + registos.getString(registos.getColumnIndex("Name")));
            } while (registos.moveToNext());
        }
        else { // Caso não exista informação para uma determinada data é retornada uma mensagem
            Toast.makeText(Detalhes.this,"Não existem registos na data selecionada",Toast.LENGTH_SHORT).show();
        }

        return lista;

    }
}
