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
                '나기사', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test1', 
                'Time On Target', 'Afternoon Tea', 'Pride of Tea Party', 'Noblesse oblige'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미나', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test2', 
                '용호상박', '파죽지세', '일전불사', '기호지세'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미네', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test3', 
                '신념과 긍지', '준엄한 선고', '기사단의 의지', '불굴의 용기'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '사오리', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test4', 
                'et omnia vanitas!', '지향 사격', '훈련의 성과', '리더로서의 책임감'
            )
        """.trimIndent())

            db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아루', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test5', 
                '하드보일드 샷', '느와르 어택', '사장님의 위엄', '무법자의 길'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '슌', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test6', 
                '나쁜 아이는 어디있나요?', '모두 집중하세요!', '교관의 품격', '매화원의 훈육법'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '시로코', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test7', 
                '드론 소환: 화력 지원', '수류탄 투척', '약점 노리기', '고속 연사'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '우이', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test8', 
                '고서 전문가', '지식전수', '문가의 날카로움', '신경과민'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이즈미', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test9', 
                '치즈 초콜릿 햄버거~', '준비하고, 빠앙!', '또 뭘 먹지?', '맛있는 게 최고야~'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '코하루', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test10', 
                '성스러운 수류탄', '치료해주겠다고!', '치료해주겠다고!', '엘리트니까!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '토키', 
                '폭발/탄력장갑', 
                'android.resource://com.example.projectarchive/drawable/test11', 
                '<시스템: 아비 에슈흐>', '전술적 판단', '전술적 판단', '눈에는 눈'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히나', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test12', 
                '이스보셋', '리로드 앤 디스트로이', '선도부의 냉철', '철두철미'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히비키', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test13', 
                '아플 확률이 높아', '화력은 충분할지도', '위험할지도 몰라', '도움이 되길 바라'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히요리', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test14', 
                '지, 지금 지원할게요!', '마, 많이 아플 거에요!', '마, 많이 아플 거에요!', '부록의 힘이에요!'
            )
        """.trimIndent())

            db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아즈사', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test15', 
                'intulit mortem', 'sagitta mortis', '가혹한 훈련', '약점 조준'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test84', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test85', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test86', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test87', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test88', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test89', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test90', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test91', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test92', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test93', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test94', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test95', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test96', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test97', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test98', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test99', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test100', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test101', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test102', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test103', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test104', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test105', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test106', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test107', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test108', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test109', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test110', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test111', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test112', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test113', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test114', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test115', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test116', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test117', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test118', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test119', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test120', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test121', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test122', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test123', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test124', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test125', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test126', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test127', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test128', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test129', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test130', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test131', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test132', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test133', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test134', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test135', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test136', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test137', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test138', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test139', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test140', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '관통/', 
                'android.resource://com.example.projectarchive/drawable/test141', 
                '', '', '', ''
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
