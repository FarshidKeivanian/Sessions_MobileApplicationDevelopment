package com.example.sharedpreferencesexample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "MyDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    fun insertUser(name: String) {
        writableDatabase.execSQL("INSERT INTO users(name) VALUES(?)", arrayOf(name))
    }

    fun getAllUsers(): List<String> {
        val cursor = readableDatabase.rawQuery("SELECT name FROM users", null)
        val names = mutableListOf<String>()
        while (cursor.moveToNext()) {
            names.add(cursor.getString(0))
        }
        cursor.close()
        return names
    }
}
