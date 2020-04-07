package com.example.qurandemo;

import android.content.Context;

import androidx.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class QuranDatabasehelper extends SQLiteAssetHelper {

        private  static  final  String DATABASE_NAME="Quran.db";
        private  static  final  String TABLE_NAME="sura";
        private  static  final  int VERSION_NUMBER=1;




    public QuranDatabasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }




}
