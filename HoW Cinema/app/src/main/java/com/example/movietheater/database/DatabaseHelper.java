package com.example.movietheater.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.fragment.app.FragmentActivity;

import com.example.movietheater.client.Client;
import com.example.movietheater.poltrona.Poltrona;
import com.example.movietheater.R;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cinema";
    private static final String TABLE_POLTRONA ="poltrona";
    private static final String TABLE_CLIENTE ="cliente";
//    private static final String TABLE_SESSOES ="sessoes";
//    private static final String TABLE_SALA ="Sala";

    private static final String CREATE_TABLE_POLTRONA = "CREATE TABLE " + TABLE_POLTRONA + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Disponivel varchar(10))";


    private static final String CREATE_TABLE_CLIENTE = "CREATE TABLE " + TABLE_CLIENTE + "("+
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "idade INTEGER, " +
            "_id_poltrona INTEGER," +
            "CONSTRAINT fk_cliente_poltrona FOREIGN KEY (_id_poltrona) REFERENCES poltrona (_id))";

//    private static final String CREATE_TABLE_SESSOES = "CREATE TABLE " + TABLE_SESSOES + "("+
//            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            "idade INTEGER," +
//            "CONSTRAINT fk_id_cliente FOREIGN KEY (_id) REFERENCES cliente (_id))";
//
//    private static final String CREATE_TABLE_SALA = "CREATE TABLE " + TABLE_SALA + "("+
//            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            "CONSTRAINT fk_id_poltrona FOREIGN KEY (id) REFERENCES poltrona (id))";


    private static final String DROP_TABLE_POLTRONA = "DROP TABLE IF EXISTS " + TABLE_POLTRONA;
    private static final String DROP_TABLE_CLIENTE= "DROP TABLE IF EXISTS " + TABLE_CLIENTE;
//    private static final String DROP_TABLE_SESSOES= "DROP TABLE IF EXISTS " + TABLE_SESSOES;
//    private static final String DROP_TABLE_SALA= "DROP TABLE IF EXISTS " + TABLE_SALA;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_POLTRONA);
        db.execSQL(CREATE_TABLE_CLIENTE);
//        db.execSQL(CREATE_TABLE_SESSOES);
//        db.execSQL(CREATE_TABLE_SALA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_POLTRONA);
        db.execSQL(DROP_TABLE_CLIENTE);
//        db.execSQL(DROP_TABLE_SESSOES);
//        db.execSQL(DROP_TABLE_SALA);

        onCreate(db);
    }
    /* INICIO CRUD POLTRONA */
    public long createpoltronaDisponivel (Poltrona p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Disponivel", p.getDisponivel());
        long id = db.insert(TABLE_POLTRONA, null, cv);
        db.close();
        return id;
    }
    public long updatedPoltronaDisponivel (Poltrona p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Disponivel", p.getDisponivel());
        long id = db.update(TABLE_POLTRONA,cv,"_id = ?", new String[]{String.valueOf(p.getId())});
        db.close();
        return id;
    }
    public long deletePoltronaDisponivel (Poltrona p) {
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.delete(TABLE_POLTRONA, "_id = ?",
                new String[]{String.valueOf(p.getId())});
        db.close();
        return id;
    }

    public void getAllPoltronas (Context context, ListView lv) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "Disponivel"};
        Cursor data = db.query(TABLE_POLTRONA, columns, null, null,
                null, null, "_id");
        int[] to = {R.id.textview_listar_poltrona, R.id.textViewPoltronaDisponivel};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context,
                R.layout.poltrona_item_list_view, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
            db.close();
    }

    public Poltrona getPoltronaId (int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "Disponivel"};
        String[] args = {String.valueOf(id)};
        Cursor data = db.query(TABLE_POLTRONA, columns, "_id = ?", args,
                null, null, null);
        data.moveToFirst();
        Poltrona p = new Poltrona();
        p.setId(data.getInt(0));
        p.setDisponivel(data.getString(1));
        data.close();
        db.close();
        return p;
    }
//    FIM CRUD POLTRONA

    /* INICIO CRUD CLIENTE */

    public long createClientDisponivel (Poltrona p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("idade", p.getDisponivel());
        long id = db.insert(TABLE_CLIENTE, null, cv);
        db.close();
        return id;
}
    public long updatedClientDisponivel (Poltrona p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("idade", p.getDisponivel());
        long id = db.update(TABLE_CLIENTE,cv,"_id = ?", new String[]{String.valueOf(p.getId())});
        db.close();
        return id;
    }
    public long deleteClientDisponivel (Poltrona p) {
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.delete(TABLE_CLIENTE, "_id = ?",
                new String[]{String.valueOf(p.getId())});
        db.close();
        return id;
    }

    public void getAllCLients (Context context, ListView lv) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "idade", "id_poltrona"};
        Cursor data = db.query(TABLE_CLIENTE, columns, null, null,
                null, null, "_id");
        int[] to = {R.id.textViewClientDisponivel, R.id.textViewClientDisponivel};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context,
                R.layout.client_item_list_view, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();
    }

    public Client getClientId (int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "idade","id_poltrona"};
        String[] args = {String.valueOf(id)};
        Cursor data = db.query(TABLE_CLIENTE, columns, "_id = ?", args,
                null, null, null);
        data.moveToFirst();
        Client c = new Client();
        c.setId(data.getInt(0));
        c.setAge(data.getInt(0));
        c.setId_poltrona(data.getInt(0));
        data.close();
        db.close();
        return c;
    }


}

