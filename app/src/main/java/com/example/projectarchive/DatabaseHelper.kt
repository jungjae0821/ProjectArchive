package com.example.projectarchive

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.Cursor

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createStudentTable = """
            CREATE TABLE $TABLE_STUDENTS (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                birthday TEXT NOT NULL
            );
        """.trimIndent()
        db.execSQL(createStudentTable)

        // 샘플 데이터 추가
        db.execSQL("INSERT INTO $TABLE_STUDENTS (name, birthday) VALUES ('김철수', '2003-04-12')")
        db.execSQL("INSERT INTO $TABLE_STUDENTS (name, birthday) VALUES ('이영희', '2004-07-25')")
        db.execSQL("INSERT INTO $TABLE_STUDENTS (name, birthday) VALUES ('박민수', '2005-02-10')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENTS")
        onCreate(db)
    }

    // 학생 목록 불러오기
    fun getAllStudents(): List<Pair<String, String>> {
        val studentList = mutableListOf<Pair<String, String>>()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT name, birthday FROM $TABLE_STUDENTS", null)

        while (cursor.moveToNext()) {
            val name = cursor.getString(0)
            val birthday = cursor.getString(1)
            studentList.add(Pair(name, birthday))
        }
        cursor.close()
        db.close()
        return studentList
    }

    companion object {
        private const val DATABASE_NAME = "project_archive.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_STUDENTS = "students"
    }
}
