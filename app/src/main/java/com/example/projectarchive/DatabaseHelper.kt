package com.example.projectarchive

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.Cursor

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createStudentTable = """
            CREATE TABLE $TABLE_STUDENTS (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                type TEXT NOT NULL,
                image_path TEXT NOT NULL,
                skill1 TEXT NOT NULL,
                skill2 TEXT NOT NULL,
                skill3 TEXT NOT NULL,
                skill4 TEXT NOT NULL
            );
        """.trimIndent()
        db.execSQL(createStudentTable)

        // ✅ 샘플 데이터 삽입
        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '김철수', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test1', 
                '화염탄', '강화탄환', '폭발 범위 증가', '기절 유발'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이영희', 
                '관통/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/student2', 
                '관통 사격', '빠른 재장전', '명중률 향상', '치명타 확률 증가'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '박민수', 
                '신비/중장갑', 
                'android.resource://com.example.projectarchive/drawable/student3', 
                '에너지 볼트', '방어막 생성', '이동 속도 감소', '스턴 공격'
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENTS")
        onCreate(db)
    }

    // ✅ Student 리스트로 반환
    fun getAllStudents(): List<Student> {
        val studentList = mutableListOf<Student>()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery(
            "SELECT name, type, image_path, skill1, skill2, skill3, skill4 FROM $TABLE_STUDENTS", null
        )

        while (cursor.moveToNext()) {
            val student = Student(
                name = cursor.getString(0),
                type = cursor.getString(1),
                imagePath = cursor.getString(2),
                skill1 = cursor.getString(3),
                skill2 = cursor.getString(4),
                skill3 = cursor.getString(5),
                skill4 = cursor.getString(6)
            )
            studentList.add(student)
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
