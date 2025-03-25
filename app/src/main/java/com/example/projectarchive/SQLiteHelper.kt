package com.example.projectarchive

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.text.SimpleDateFormat
import java.util.*

class CurrencyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "currency_db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "currency_data"
        private const val COLUMN_ID = "id"
        private const val COLUMN_DATE = "date"
        private const val COLUMN_AMOUNT = "currency"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_DATE TEXT NOT NULL,
                $COLUMN_AMOUNT INTEGER NOT NULL
            );
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // ✅ 1. 하루 재화 저장 (같은 날짜면 덮어쓰기)
    fun insertOrUpdateCurrency(amount: Int) {
        val db = writableDatabase
        val date = getCurrentDate()

        // 중복된 날짜가 있는지 확인
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_DATE = ?", arrayOf(date))
        val exists = cursor.count > 0
        cursor.close()

        val values = ContentValues().apply {
            put(COLUMN_DATE, date)
            put(COLUMN_AMOUNT, amount)
        }

        if (exists) {
            db.update(TABLE_NAME, values, "$COLUMN_DATE = ?", arrayOf(date))
        } else {
            db.insert(TABLE_NAME, null, values)
        }

        db.close()
    }

    // ✅ 2. 특정 기간 동안의 총합 계산
    fun getTotalCurrency(days: Int): Int {
        val db = readableDatabase
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -days)
        val startDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.time)

        val query = "SELECT SUM($COLUMN_AMOUNT) FROM $TABLE_NAME WHERE $COLUMN_DATE >= ?"
        val cursor = db.rawQuery(query, arrayOf(startDate))
        var total = 0
        if (cursor.moveToFirst()) {
            total = cursor.getInt(0)
        }
        cursor.close()
        db.close()
        return total
    }

    // ✅ 3. 오늘 획득한 재화 불러오기
    fun getTodayCurrency(): Int {
        val db = readableDatabase
        val query = "SELECT $COLUMN_AMOUNT FROM $TABLE_NAME WHERE $COLUMN_DATE = ?"
        val cursor = db.rawQuery(query, arrayOf(getCurrentDate()))

        var amount = 0
        if (cursor.moveToFirst()) {
            amount = cursor.getInt(0)
        }

        cursor.close()
        db.close()
        return amount
    }

    // 현재 날짜 반환 (yyyy-MM-dd)
    private fun getCurrentDate(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }
}
