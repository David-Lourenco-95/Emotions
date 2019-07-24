package com.projeto.emotions.emotions;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RegistarEmocao extends AppCompatActivity {

   DBHelper2 db;
   SQLiteDatabase database;

    RadioGroup rg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_emocao);
        db = new DBHelper2(this);

        onClickSubmitAccount();
    }
// Função que regista uma emoção ao clicar no botão
    public void onClickSubmitAccount(){
        rg = (RadioGroup) findViewById(R.id.emocoes);
        btn = (Button) findViewById(R.id.btnregistar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal;
                String dia,mes,ano, semana;
                String valor_Registo="";
                String valor,hora;
                String insertSQL;
                Cursor cursor;

               database =db.getWritableDatabase();

                int selectedId = rg.getCheckedRadioButtonId();


                    // Usa-se um switch para uma determinada ação em cada caso
                    switch (selectedId) {

                        // Caso a Emoção escolhida conste no RadioButton, vai se pesquisar
                        // o valor da emoção e inserir na tabela registo para ser usado
                        // futuramente para o calculo das médias
                        case R.id.infeliz:

                            valor = "SELECT Valor FROM Emocao where Name='Infeliz'";

                            // Usa-se um cursor para pesquisar na base de dados
                            // e retornar a informação pretendida
                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            // Guadar-se a data atual, no momento do registo
                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            // Guarda-se a semana do ano
                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            // Guarda-se a hora atua, no momento do registo
                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            // Insere-se a informação na tabela Registo
                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();

                            break;

                            // O resto do código tem a mesma logica que o explicado anteriormente
                            // aplicado a cada emoção selecionada
                        case R.id.desesperado:

                            valor = "SELECT Valor FROM Emocao where Name='Desesperado'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.raiva:

                            valor = "SELECT Valor FROM Emocao where Name='Raiva'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;


                        case R.id.triste:

                            valor = "SELECT Valor FROM Emocao where Name='Triste'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;


                        case R.id.nervoso:

                            valor = "SELECT Valor FROM Emocao where Name='Nervoso'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.apatico:

                            valor = "SELECT Valor FROM Emocao where Name='Apático'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.animado:

                            valor = "SELECT Valor FROM Emocao where Name='Animado'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.alegre:

                            valor = "SELECT Valor FROM Emocao where Name='Alegre'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.entusiasmo:

                            valor = "SELECT Valor FROM Emocao where Name='Entusiasmado'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.apaixonado:

                            valor = "SELECT Valor FROM Emocao where Name='Apaixonado'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.Feliz:

                            valor = "SELECT Valor FROM Emocao where Name='Feliz'";

                            cursor = database.rawQuery(valor, null);

                            if (cursor.moveToFirst()) {

                                do {

                                    valor_Registo = cursor.getString(cursor.getColumnIndex("Valor"));

                                } while (cursor.moveToNext());
                            }
                            cursor.close();

                            cal = Calendar.getInstance();
                            dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
                            ano = String.valueOf(cal.get(Calendar.YEAR));

                            semana = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

                            hora = new java.text.SimpleDateFormat("HH", Locale.getDefault()).format(new Date());

                            insertSQL = "INSERT INTO " + db.TABLE_REGISTO +
                                    "(Hora, Dia, Semana, Mes, Ano, Valor)" +
                                    "VALUES" +
                                    "(?, ?, ?, ?, ?, ?);";

                            database.execSQL(insertSQL, new String[]{hora, dia, semana, mes, ano, valor_Registo});

                            Toast.makeText(RegistarEmocao.this, "Emoção registada com sucesso", Toast.LENGTH_SHORT).show();
                            break;

                            // Caso não se selecione uma emoção é retornada uma mensagem
                        default :   Toast.makeText(RegistarEmocao.this,"Escolha uma emoção",Toast.LENGTH_SHORT).show();

                    }
            }
        });
    }
}
