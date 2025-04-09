package com.example.projectarchive

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues

class CurrencyDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "currency.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "currency"
        private const val COLUMN_ID = "id"
        private const val COLUMN_AMOUNT = "amount"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_AMOUNT INTEGER NOT NULL
            )
        """.trimIndent()
        db.execSQL(createTableQuery)

        // ✅ 기본 주간 획득 가능 재화 저장 ✅
        val defaultWeeklyAmount = 3500 // 예: 하루 500 × 7일 = 3500
        val values = ContentValues().apply {
            put(COLUMN_AMOUNT, defaultWeeklyAmount)
        }
        db.insert(TABLE_NAME, null, values)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // ✅ 주간 획득 재화 가져오기 ✅
    fun getWeeklyCurrency(): Int {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT $COLUMN_AMOUNT FROM $TABLE_NAME LIMIT 1", null)
        var amount = 0
        if (cursor.moveToFirst()) {
            amount = cursor.getInt(0)
        }
        cursor.close()
        return amount
    }
}
