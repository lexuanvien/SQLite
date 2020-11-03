package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "SinhVien";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "Name";
    private static final String COL_3 = "Toan";
    private static final String COL_4 = "Li";
    private static final String COL_5 = "Hoa";
    private static final String COL_6 = "Van";
    private static final String COL_7 = "Anh";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_2 + " TEXT, " + COL_3 +"INTEGER, "+ COL_4 +"INTEGER, " + COL_5 + " INTEGER, " + COL_6 + " INTEGER, " + COL_7 + " INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String toan, String li, String hoa, String van, String anh) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, name);
        values.put(COL_3, toan);
        values.put(COL_4, li);
        values.put(COL_5, hoa);
        values.put(COL_6, van);
        values.put(COL_7, anh);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    public boolean updateData(String id, String name, String toan, String li, String hoa, String van, String anh) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1, id);
        values.put(COL_2, name);
        values.put(COL_3, toan);
        values.put(COL_4, li);
        values.put(COL_5, hoa);
        values.put(COL_6, van);
        values.put(COL_7, anh);
        long result = db.update(TABLE_NAME, values , COL_1 + "=?", new String[]{id});
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, COL_1 + "=?", new String[]{id});
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }
}
