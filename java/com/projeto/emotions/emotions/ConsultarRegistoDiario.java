package com.projeto.emotions.emotions;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import 	java.lang.Math;


import java.util.ArrayList;
import java.util.Calendar;

public class ConsultarRegistoDiario extends AppCompatActivity {

    private CalendarView Calendario2;
    DBHelper2 db;
    SQLiteDatabase database;
    TextView nome_emocao_diaria,nome_emocao_mensal,valor_media_diaria, valor_media_mensal, valor_media_semanal, nome_media_semanal;
    String dia, mes, ano, week;
    Button btnDetalhe;
    String valor_Tabela_Emocao, nome_media_mensal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_registo_diario);

        Calendario2 = (CalendarView) findViewById(R.id.Calendario);
        nome_emocao_diaria = (TextView) findViewById(R.id.emocao);
        valor_media_diaria = (TextView) findViewById(R.id.media);
        nome_media_semanal = (TextView) findViewById(R.id.emocaoSemanal);
        valor_media_semanal = (TextView) findViewById(R.id.mediaSemanal);
        nome_emocao_mensal = (TextView) findViewById(R.id.emocao2);
        valor_media_mensal = (TextView) findViewById(R.id.media2);
        btnDetalhe = (Button) findViewById(R.id.detalhe);

        db = new DBHelper2(this);
        database = db.getReadableDatabase();

        // Guarda o data selecionada no calendário, respetivamente o dia,mês e ano
        Calendario2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                dia = String.valueOf(i2);

                mes = String.valueOf(i1 +1);

                ano = String.valueOf(i);

                // Guarda uma determinada semana do ano
               Calendar cal = Calendar.getInstance();
                cal.set(i, i1, i2);
               week = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

               // Vai pesquisar o valor da media semanal selecionada
               String semana = "SELECT AVG(Valor) FROM Registo where " + "Semana=" + week;

                //Vai pesquisar o valor da média semanal a mostrar numa textview
                String emocao_semana = "SELECT AVG(Valor) FROM Registo where " + "Semana=" + week;

                // Vai pesquisar o valor da média diária a mostrar numa textview
                String media = "SELECT AVG(Valor) FROM Registo where " + "dia=" + dia + " AND" + " mes="+ mes + " AND" + " ano=" + ano;

                // Vai pesquisar o valor da média mensal a mostrar numa textview
                String meses = "SELECT AVG(Valor) FROM Registo where " + " mes=" + mes + " AND" + " ano=" + ano;

               // Vai pesquisar o valor da média mensal
                String meses_media = "SELECT AVG(Valor) FROM Registo where " + " mes=" + mes + " AND" + " ano=" + ano;

                // Vai pesquisar o valor da média diária
               String media_Emocao = "SELECT AVG(Valor) FROM Registo where " + "dia=" + dia + " AND" + " mes="+ mes + " AND" + " ano=" + ano;

               // Usa-se o cursor para executar as querys anteriores
                Cursor cursor = database.rawQuery(media, null);

                Cursor cursor1 = database.rawQuery(meses, null);

                Cursor cursor2 = database.rawQuery(media_Emocao, null);

               Cursor cursor3 = database.rawQuery(meses_media, null);

             Cursor cursor4 = database.rawQuery(semana,null);

             Cursor cursor5 = database.rawQuery(emocao_semana,null);


               // Procura pela media diaria na base de dados
              if (cursor.moveToFirst()) {

                    do {
                        String mediaDiaria = (cursor.getString(0));
                        // Se a média for nula retorna NULL
                      if(mediaDiaria==null) {
                          valor_media_diaria.setText("");
                      }
                      else{ // Arendonda o valor da média diária
                          Double b = Math.ceil(Double.parseDouble(mediaDiaria));
                          Integer x = b.intValue();
                          valor_media_diaria.setText("" + x);
                      }
                    } while (cursor.moveToNext());
                }
                cursor.close();

                // Procura pela media Mensal na base de dados
                if (cursor1.moveToFirst()) {

                    do {

                        String mediaMensal = (cursor1.getString(0));
                        // Se a média for nula retorna NULL
                        if(mediaMensal==null){
                            valor_media_mensal.setText("");
                        }
                        else{ // Arredonda o valor da média mensal
                            Double b = Math.ceil(Double.parseDouble(mediaMensal));
                            Integer x = b.intValue();
                            valor_media_mensal.setText("" + x);
                        }

                    } while (cursor1.moveToNext());
                }
                cursor1.close();

                // Procura pela media semanal na base de dados
                if (cursor4.moveToFirst()) {

                    do {
                        String mediaSemanal = (cursor4.getString(0));
                        // Se a média for nula retorna NULL
                        if(mediaSemanal==null) {
                            valor_media_semanal.setText("");
                        }
                        else{ // Aredonda o valor da média diária
                            Double b = Math.ceil(Double.parseDouble(mediaSemanal));
                            Integer x = b.intValue();
                            valor_media_semanal.setText("" + x);
                        }
                    } while (cursor4.moveToNext());
                }
                cursor4.close();

                if (cursor2.moveToFirst()) {

                    do {
                        // Vai calcular a media diaria e guardar numa variavel
                     valor_Tabela_Emocao = (cursor2.getString(0));


                        // Verifica se a variavel é diferente de null, e arredonda
                        if(valor_Tabela_Emocao != null) {
                            Double x = Math.ceil(Double.parseDouble(valor_Tabela_Emocao));
                            Integer a = x.intValue();
                            // Se o valor da média estiver entre um determinado intervalo
                            // Então coresponde a uma emoção

                            if (a >= 0 && a <= 4) {

                                nome_emocao_diaria.setText("Infeliz");

                            } else if (a >= 5 && a <= 14) {

                                nome_emocao_diaria.setText("Desesperado");
                            } else if (a >= 15 && a <= 24) {

                                nome_emocao_diaria.setText("Raiva");
                            }
                            else if (a >= 25 && a <= 34) {

                                nome_emocao_diaria.setText("Triste");
                            }
                            else if (a >= 35 && a <= 44) {

                                nome_emocao_diaria.setText("Nervoso");
                            }
                            else if (a >= 45 && a <= 54) {

                                nome_emocao_diaria.setText("Apático");
                            }
                            else if (a >= 55 && a <= 64) {

                                nome_emocao_diaria.setText("Animado");
                            }
                            else if (a >= 65 && a <= 74) {

                                nome_emocao_diaria.setText("Alegre");
                            }
                            else if (a >= 75 && a <= 84) {

                                nome_emocao_diaria.setText("Entusiasmado");
                            }
                            else if (a >= 85 && a <= 94) {

                                nome_emocao_diaria.setText("Apaixonado");
                            }
                            else if(a >= 95 && a <= 100){
                                nome_emocao_diaria.setText("Feliz");
                            }

                        }
                        else {
                                nome_emocao_diaria.setText("");
                        }

                    } while (cursor2.moveToNext());
                }

                cursor2.close();

                if (cursor3.moveToFirst()) {

                    do {

                        // Vai calcular a media mensal e guardar numa variavel
                       nome_media_mensal = (cursor3.getString(0));

                        // Verifica se a variavel é diferente de null e arredonda o valor
                        if(nome_media_mensal != null) {
                            Double x = Math.ceil(Double.parseDouble(nome_media_mensal));
                            Integer a = x.intValue();
                            // Se o valor da média estiver entre um determinado intervalo
                            // Então coresponde a uma emoção
                            if (a >= 0 && a <= 4) {

                                nome_emocao_mensal.setText("Infeliz");

                            } else if (a >= 5 && a <= 14) {

                                nome_emocao_mensal.setText("Desesperado");
                            } else if (a >= 15 && a <= 24) {

                                nome_emocao_mensal.setText("Raiva");
                            }
                            else if (a >= 25 && a <= 34) {

                                nome_emocao_mensal.setText("Triste");
                            }
                            else if (a >= 35 && a <= 44) {

                                nome_emocao_mensal.setText("Nervoso");
                            }
                            else if (a >= 45 && a <= 54) {

                                nome_emocao_mensal.setText("Apático");
                            }
                            else if (a >= 55 && a <= 64) {

                                nome_emocao_mensal.setText("Animado");
                            }
                            else if (a >= 65 && a <= 74) {

                                nome_emocao_mensal.setText("Alegre");
                            }
                            else if (a >= 75 && a <= 84) {

                                nome_emocao_mensal.setText("Entusiasmado");
                            }
                            else if (a >= 85 && a <= 94) {

                                nome_emocao_mensal.setText("Apaixonado");
                            }
                            else if(a >= 95 && a <= 100){
                                nome_emocao_mensal.setText("Feliz");
                            }

                        }
                        else {
                            nome_emocao_mensal.setText("");
                        }

                    } while (cursor3.moveToNext());
                }
                cursor3.close();


                if (cursor5.moveToFirst()) {

                    do {

                        // Vai guadar o valor da media num variavel
                        nome_media_mensal = (cursor5.getString(0));

                        // Verifica se a variavel é diferente de null e arredonda
                        if(nome_media_mensal != null) {
                            Double x = Math.ceil(Double.parseDouble(nome_media_mensal));
                            Integer a = x.intValue();
                            // Se o valor da média estiver entre um determinado intervalo
                            // Então coresponde a uma emoção
                            if (a >= 0 && a <= 4) {

                                nome_media_semanal.setText("Infeliz");

                            } else if (a >= 5 && a <= 14) {

                                nome_media_semanal.setText("Desesperado");

                            } else if (a >= 15 && a <= 24) {

                                nome_media_semanal.setText("Raiva");
                            }
                            else if (a >= 25 && a <= 34) {

                                nome_media_semanal.setText("Triste");
                            }
                            else if (a >= 35 && a <= 44) {

                                nome_media_semanal.setText("Nervoso");
                            }
                            else if (a >= 45 && a <= 54) {

                                nome_media_semanal.setText("Apático");
                            }
                            else if (a >= 55 && a <= 64) {

                                nome_media_semanal.setText("Animado");
                            }
                            else if (a >= 65 && a <= 74) {

                                nome_media_semanal.setText("Alegre");
                            }
                            else if (a >= 75 && a <= 84) {

                                nome_media_semanal.setText("Entusiasmado");
                            }
                            else if (a >= 85 && a <= 94) {

                                nome_media_semanal.setText("Apaixonado");
                            }
                            else if(a >= 95 && a <= 100){
                                nome_media_semanal.setText("Feliz");
                            }

                        }
                        else {
                            nome_media_semanal.setText("");
                        }

                    } while (cursor5.moveToNext());
                }
                cursor5.close();

            }
        });

        // Nesta função vai se pesquisar na base de dados e procurar pelas horas e emoções
        // registadas numa determinada data
        btnDetalhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = db.getReadableDatabase();

                String q = "SELECT R.Hora,E.Name FROM Registo R,Emocao E where R.Valor=E.Valor" + " AND " + "dia=" + dia + " AND " + "mes=" + mes + " AND " + "ano=" + ano + ";";

                Cursor registos = database.rawQuery(q, null);

                if (registos.moveToFirst()) {
                    do {

                        registos.getString(registos.getColumnIndex("Hora"));
                        registos.getString(registos.getColumnIndex("Name"));
                    } while (registos.moveToNext());

                    // Neste intento é enviada a data para a classe Detalhes.java
                    Intent iActivity = new Intent(getApplicationContext(),Detalhes.class);

                    Bundle bundle = new Bundle();

                    bundle.putString("dia",dia);
                    bundle.putString("mes",mes);
                    bundle.putString("ano",ano);

                    iActivity.putExtras(bundle);

                    startActivity(iActivity);
                }
                // Caso não existam registos numa determinada data, é mostrado uma mensagem
                else {
                    Toast.makeText(ConsultarRegistoDiario.this,"Não existem registos diários na data selecionada",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

