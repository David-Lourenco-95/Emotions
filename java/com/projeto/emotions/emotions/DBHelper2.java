package com.projeto.emotions.emotions;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper2 extends SQLiteOpenHelper {

    // Criação da base de dados
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NOME = "DBEmocao11.db";

    // Defenição da tabela emoção e as respetivas tabelas
    protected static final String TABLE_EMOTION = "Emocao";
    protected static final String VALOR = "Valor";
    protected static final String NAME = "Name";

    // Defenição da tabela registo e as respetivas tabelas
    protected static  final String TABLE_REGISTO = "Registo";
    protected static final String REGISTO_ID = "Registo_ID";
    protected static final String HORA_REGISTO = "Hora";
    protected static final String SEMANA_REGISTO = "Semana";
    protected static final String DIA_REGISTO = "Dia";
    protected static final String MES_REGISTO = "Mes";
    protected static final  String ANO_REGISTO = "Ano";
    protected static final String VALOR_REGISTO = "Valor";

    // Criação da tabela emoção e as respetivas tabelas
    protected  static final String CREATE_TABLE_EMOTIONS =
            "CREATE TABLE " + TABLE_EMOTION  + " (" +
                    VALOR + " INT PRIMARY KEY NOT NULL, "+
                    NAME + " VARCHAR(30) NOT NULL);";

    // Criação da tabela registo e as respetivas tabelas
    protected  static final String CREATE_TABLE_REGISTO =
            "CREATE TABLE " + TABLE_REGISTO  + " (" +
                    REGISTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    HORA_REGISTO + " INT NOT NULL, "+
                    DIA_REGISTO + " INT NOT NULL, " +
                    SEMANA_REGISTO + " INT NOT NULL, " +
                    MES_REGISTO + " INT NOT NULL, " +
                    ANO_REGISTO + " INT NOT NULL, "+
                    VALOR_REGISTO + " INT NOT NULL, " +
                    "FOREIGN KEY(Valor) REFERENCES Emocao(Valor));";

    protected static final String EMOTION_TABLE_DROP =
            "DROP TABLE " + TABLE_EMOTION + ";";

    protected static final String EMOTION_TABLE_TEMP =
            "CREATE TEMP TABLE EmotionAux AS SELECT * FROM " +
                    TABLE_EMOTION + ";";
    protected static final String EMOTION_TABLE_INSERT =
            "INSERT INTO " + TABLE_EMOTION +
                    "(" + VALOR + "," + NAME + ")" +
                    "SELECT * FROM " + EMOTION_TABLE_TEMP + ";";

    protected static final String REGISTO_TABLE_DROP =
            "DROP TABLE " + TABLE_REGISTO + ";";

    protected static final String REGISTO_TABLE_TEMP =
            "CREATE TEMP TABLE RegistoAux AS SELECT * FROM " +
                    TABLE_REGISTO + ";";
    protected static final String REGISTO_TABLE_INSERT =
            "INSERT INTO " + TABLE_REGISTO +
                    "(" + REGISTO_ID + "," + HORA_REGISTO + "," + DIA_REGISTO + "," + MES_REGISTO + ")" +
                    "SELECT * FROM " + REGISTO_TABLE_TEMP + ";";

    // Criar as tabelas no OnCreate ao executar a apliacação

    public DBHelper2(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSION);
}

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_EMOTIONS);
        db.execSQL(CREATE_TABLE_REGISTO);

        // DADOS HARDCODED presentes na tabela Emoção
        ContentValues values = new ContentValues();

        values.put(NAME,"Infeliz");
        values.put(VALOR,new Integer(0));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Infeliz");
        values.put(VALOR,new Integer(0));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Desesperado");
        values.put(VALOR,new Integer(10));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Raiva");
        values.put(VALOR,new Integer(20));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Triste");
        values.put(VALOR,new Integer(30));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Nervoso");
        values.put(VALOR,new Integer(40));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Apático");
        values.put(VALOR,new Integer(50));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Animado");
        values.put(VALOR,new Integer(60));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Alegre");
        values.put(VALOR,new Integer(70));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Entusiasmado");
        values.put(VALOR,new Integer(80));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Apaixonado");
        values.put(VALOR,new Integer( 90));
        db.insert(TABLE_EMOTION,null,values);

        values.put(NAME,"Feliz");
        values.put(VALOR,new Integer(100));
        db.insert(TABLE_EMOTION,null,values);

        // Dados presentes na tabela de Registo de emoções que
        // servem meramente para testes da aplicação
        ContentValues values2 = new ContentValues();

        values2.put(HORA_REGISTO,new Integer(14));
        values2.put(DIA_REGISTO,new Integer(24));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(30));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(17));
        values2.put(DIA_REGISTO,new Integer(24));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(0));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(19));
        values2.put(DIA_REGISTO,new Integer(24));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(30));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(7));
        values2.put(DIA_REGISTO,new Integer(25));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(50));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(10));
        values2.put(DIA_REGISTO,new Integer(25));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(60));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(13));
        values2.put(DIA_REGISTO,new Integer(25));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(50));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(15));
        values2.put(DIA_REGISTO,new Integer(25));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(60));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(12));
        values2.put(DIA_REGISTO,new Integer(26));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(70));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(17));
        values2.put(DIA_REGISTO,new Integer(26));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(80));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(20));
        values2.put(DIA_REGISTO,new Integer(26));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(100));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(14));
        values2.put(DIA_REGISTO,new Integer(22));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(50));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(18));
        values2.put(DIA_REGISTO,new Integer(22));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(50));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(23));
        values2.put(DIA_REGISTO,new Integer(22));
        values2.put(SEMANA_REGISTO,new Integer(47));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(60));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(8));
        values2.put(DIA_REGISTO,new Integer(28));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(100));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(12));
        values2.put(DIA_REGISTO,new Integer(28));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(90));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(18));
        values2.put(DIA_REGISTO,new Integer(28));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(100));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(10));
        values2.put(DIA_REGISTO,new Integer(30));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(40));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(14));
        values2.put(DIA_REGISTO,new Integer(30));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(30));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(19));
        values2.put(DIA_REGISTO,new Integer(30));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(11));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(50));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(9));
        values2.put(DIA_REGISTO,new Integer(2));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(20));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(15));
        values2.put(DIA_REGISTO,new Integer(2));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(0));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(21));
        values2.put(DIA_REGISTO,new Integer(2));
        values2.put(SEMANA_REGISTO,new Integer(48));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(30));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(7));
        values2.put(DIA_REGISTO,new Integer(5));
        values2.put(SEMANA_REGISTO,new Integer(49));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(70));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(17));
        values2.put(DIA_REGISTO,new Integer(5));
        values2.put(SEMANA_REGISTO,new Integer(49));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(50));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(15));
        values2.put(DIA_REGISTO,new Integer(7));
        values2.put(SEMANA_REGISTO,new Integer(49));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(100));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(16));
        values2.put(DIA_REGISTO,new Integer(7));
        values2.put(SEMANA_REGISTO,new Integer(49));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(60));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(23));
        values2.put(DIA_REGISTO,new Integer(7));
        values2.put(SEMANA_REGISTO,new Integer(49));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(80));
        db.insert(TABLE_REGISTO,null,values2);

        values2.put(HORA_REGISTO,new Integer(9));
        values2.put(DIA_REGISTO,new Integer(8));
        values2.put(SEMANA_REGISTO,new Integer(49));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(50));
        db.insert(TABLE_REGISTO,null,values2);


        values2.put(HORA_REGISTO,new Integer(9));
        values2.put(DIA_REGISTO,new Integer(8));
        values2.put(SEMANA_REGISTO,new Integer(49));
        values2.put(MES_REGISTO,new Integer(12));
        values2.put(ANO_REGISTO,new Integer(2018));
        values2.put(VALOR_REGISTO,new Integer(30));
        db.insert(TABLE_REGISTO,null,values2);

        // Fim dos dados presentes na tabela de Registo de emoções que
        // servem meramente para testes da aplicação
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(EMOTION_TABLE_TEMP);
        db.execSQL(EMOTION_TABLE_DROP);
        db.execSQL(CREATE_TABLE_EMOTIONS);
        db.execSQL(EMOTION_TABLE_INSERT);

        db.execSQL(REGISTO_TABLE_TEMP);
        db.execSQL(REGISTO_TABLE_DROP);
        db.execSQL(CREATE_TABLE_REGISTO);
        db.execSQL(REGISTO_TABLE_INSERT);
    }
}
