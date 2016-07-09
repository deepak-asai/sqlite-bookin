package com.example.deepak.sqlite_booking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deepak on 6/7/16.
 */
public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static  final String DATABASE_NAME="movieDB.db";
    public static final String table="movie";
    public static final String col_id="id";
    public static final String col_name="moviename";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+table+"("+
                col_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                col_name+" TEXT "+
                ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+table );
        onCreate(db);
    }

    public void addMovie(Movie movie){

        ContentValues values = new ContentValues();
        values.put(col_name, movie.getName());
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(table, null, values);
        db.close();

    }

    public void deleteMovie(String name){
        //String query="DELETE FROM "+table+" WHERE "+col_name+" =\""+name+"\";";
        SQLiteDatabase db=getWritableDatabase();;
        db.execSQL("DELETE FROM "+table+" WHERE "+col_name+" =\""+name+"\";");;
        //db.close();
    }

    public String databasetostring(){
        SQLiteDatabase db=this.getWritableDatabase();
        String dbString=" ";

        String query ="SELECT * FROM "+table+";";

        Cursor c=db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("moviename")) != null){

                dbString+=c.getString(c.getColumnIndex("moviename"));
                dbString+="\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
