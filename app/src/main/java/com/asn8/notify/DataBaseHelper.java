package com.asn8.notify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String NOTES_TABLE = "NOTES_TABLE";
    public static final String _ID = "ID";
    public static final String _HEADING = "HEADING";
    public static final String _TEXT_ISH = "TEXT_ISH";


    public DataBaseHelper(@Nullable Context context) {
        super(context, "notes.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String notesTableCreator = "CREATE TABLE " + NOTES_TABLE + " ( " + _HEADING + "TEXT ," + _TEXT_ISH + "TEXT )";
        sqLiteDatabase.execSQL(notesTableCreator);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addOne(String heading ,String text_ish){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(_HEADING , heading);
        contentValues.put(_TEXT_ISH,text_ish);
        sqLiteDatabase.insert(NOTES_TABLE,null,contentValues);
    }

    public void deleteOne(String heading){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String stringQuery = "DELETE FROM "+ NOTES_TABLE + " WHERE " + _HEADING +" = "+heading;
        sqLiteDatabase.rawQuery(stringQuery, null);

    }

    public Cursor getEveryone(){
        String stringQuery = "SELECT * FROM "+NOTES_TABLE;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(stringQuery,null);
        return cursor;
    }
}
