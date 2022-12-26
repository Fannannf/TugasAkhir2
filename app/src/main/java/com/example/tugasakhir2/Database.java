package com.example.tugasakhir2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "laundry.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table laundry(nama text null,kaos text null,jeans text null, jaket text null, bedcover text null, total text null);";
        Log.d("Data","OnCreate "+sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists laundry");
    }

    public boolean insertlaundry(String nama,String kaos,String jeans,String jaket,String bedcover,String total){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama",nama);
        contentValues.put("kaos",kaos);
        contentValues.put("jeans",jeans);
        contentValues.put("jaket",jaket);
        contentValues.put("bedcover",bedcover);
        contentValues.put("total",total);
        Long result = db.insert("laundry",null,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }
    
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from laundry",null);
        return cursor;
    }

    public int delete(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("laundry",null,null);
    }
}
