package com.projeto.emotions.emotions;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Inserir_Emocao extends AppCompatActivity {

    DBHelper2 db;
    SQLiteDatabase sqLiteDatabase;
    EditText nome_emocao;
    EditText valor_emocao;
    Button btn;
    int teste = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir__emocao);

        db = new DBHelper2(this);

        nome_emocao = (EditText) findViewById(R.id.NomeEmocao);
        valor_emocao = (EditText) findViewById(R.id.ValorEmocao);
        btn = (Button) findViewById(R.id.btnNovaEmocao);

        AddData();
    }

    // Função que insere os valores introduzidos nas EditText na base de dados
    public void AddData() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nome_emocao.getText().toString().equals("") && valor_emocao.getText().toString().equals("")){

                    Toast.makeText(Inserir_Emocao.this, "Insira dados nos campos", Toast.LENGTH_SHORT).show();
                }
                else{

                    boolean result = InsertData(nome_emocao.getText().toString(), valor_emocao.getText().toString());

                    if (result == true)
                        Toast.makeText(Inserir_Emocao.this, "Emoção inserida com sucesso", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Inserir_Emocao.this, "Emoção já existente", Toast.LENGTH_SHORT).show();
            }}
        });


    }

    // Função que permite inserir uma nova emoção na base de dados
    public boolean InsertData(String nome, String valor) {

        sqLiteDatabase = db.getWritableDatabase();

        String q = "Select * FROM Emocao";

        Cursor cursor = sqLiteDatabase.rawQuery(q, null);

       while (cursor.moveToNext()) {

            String Valor = cursor.getString(0);
            String Nome = cursor.getString(1);

            // Verifica se os dados a inserir já constam na base de dados
          if (Valor.equals(valor_emocao) || Nome.equals(nome_emocao))
              teste = 0;


        }
        // Insere os valores na tabela Emoção casos não existam
        if (teste != 0) {
            ContentValues values = new ContentValues();

            values.put(db.VALOR, valor);
            values.put(db.NAME, nome);

            long result = sqLiteDatabase.insert(db.TABLE_EMOTION, null, values);

            // Obtem a data atual
           Calendar cal = Calendar.getInstance();
            String dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
            String mes  = String.valueOf(cal.get(Calendar.MONTH) +1);
            String ano = String.valueOf(cal.get(Calendar.YEAR));

            String semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

            // Obtem a hora atual
           String hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

           // Insere a informação na Tabela Registos
           String insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                    "VALUES" +
                    "(?, ?, ?, ?, ?, ?);";

            sqLiteDatabase.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor});

            if (result == -1)
                return false;
            else return true;
        }
       else{
            return false;
        }
    }
}
