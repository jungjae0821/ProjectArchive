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
                type TEXT NOT NULL
            );
        """.trimIndent()
        db.execSQL(createStudentTable)

        // 데이터 추가
        db.execSQL("INSERT INTO $TABLE_STUDENTS (name, type) VALUES ('김철수', '폭발/경장갑')")
        db.execSQL("INSERT INTO $TABLE_STUDENTS (name, type) VALUES ('이영희', '관통/특수장갑')")
        db.execSQL("INSERT INTO $TABLE_STUDENTS (name, type) VALUES ('박민수', '신비/중장갑')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENTS")
        onCreate(db)
    }

    // 학생 목록 불러오기
    fun getAllStudents(): List<Pair<String, String>> {
        val studentList = mutableListOf<Pair<String, String>>()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT name, type FROM $TABLE_STUDENTS", null)

        while (cursor.moveToNext()) {
            val name = cursor.getString(0)
            val type = cursor.getString(1)
            studentList.add(Pair(name, type))
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