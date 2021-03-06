package com.example.memebox.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MemeDatabase extends SQLiteOpenHelper {
    public static String DatabaseName = "Data.db";
    private static String TableName = "ImageData";
    public static String COL1 = "SerialNo";
    public static String COL2 = "Image";
    public static String COL3 = "Category";

    public MemeDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TableName + "(SerialNo INTEGER primary key,Image INTEGER, Category TEXT)");

    }

    private void insertDate(int SerialNo, int Image, String Category, SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SerialNo", SerialNo);
        contentValues.put("KEY_IMAGE", Image);
        contentValues.put("Category", Category);
        sqLiteDatabase.insert(TableName, null, contentValues);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
