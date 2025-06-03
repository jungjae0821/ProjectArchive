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
                '네루', 
                '관통/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test16', 
                '아앙~? 죽인다?', '아앙~? 까불지마!', '코드명 더블오', '분노 강화'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '레이사', 
                '관통/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test17', 
                '도전장을 받으세요!', '승리의 포즈!', '하루 종일도 할 수 있습니다', '우자와 레이사의 존재감'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '마코토', 
                '관통/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test18', 
                '시, 실수했다!', '제대로 들어 두도록!', '만마전의 위대한 의장님', '천하무적! 게헨나를 이끄는 진정한 리더!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미야코', 
                '관통/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test19', 
                '섬광 드론 전개', '클레이모어 격발', '특수 방탄판 장착', '교란작전'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미카', 
                '관통/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test20', 
                'Kyrie Eleison', '별의 부름', 'Gloria Patri', 'Benedictio'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이오리', 
                '관통/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test21', 
                '일망타진', '현상수배', '일발필중', '선도부원의 담력'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '유즈', 
                '관통/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test22', 
                '게임, 스타트!', '연쇄 콤보 달성!', '디버깅 체크 중…', '부끄럼쟁이의 용기'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '체리노', 
                '관통/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test23', 
                '친위대 소환!', '저 녀석, 숙청이야!', '수염의 힘!', '이것이 수염의 권위다!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '카린', 
                '관통/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test24', 
                '대상, 삭제', '화력, 지원', '무장, 강화', '아군, 지원'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '카즈사', 
                '관통/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test25', 
                '달콤한 포화', '예전 습관', '슈가 하이', '퍼스트 테이스트'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '칸나', 
                '관통/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test26', 
                '공안국장의 수완', '가혹한 취조', '미친개의 집념', '공안국 특제 탄약'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '코코나', 
                '관통/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test27', 
                '참 잘했어요', '다음에도 기대할게요', '교관의 책임감', '매화원의 지도법'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '호시노', 
                '관통/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test28', 
                '전술 진압', '응급 치료', '대책위원회의 부장', '진압 숙련'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히마리', 
                '관통/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test29', 
                '후후, 실력을 보여드리죠.', '살짝 놀랄지도 모르겠네요.', '청초한 절벽 위의 꽃', '초천재병약미소녀해커의 진면목'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히후미', 
                '관통/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test30', 
                '도와줘요, 페로로 님!', '페로로 님의 응원', '수집가의 근성', '민첩한 수집가'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '노아', 
                '신비/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test31', 
                '기록의 생명은 속도랍니다', '허점 발견!', '서기의 여유', '서기의 고집'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '리오', 
                '신비/탄력장갑', 
                'android.resource://com.example.projectarchive/drawable/test32', 
                '빅 시스터', '유일한 진실', '별을 쫓는 자', '아방가르드'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '사쿠라코', 
                '신비/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test33', 
                '세례의 증표', '시스터의 몸가짐', '죄악을 심판하는 자', '빛이 함께하시라'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아리스', 
                '신비/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test34', 
                '밸런스 붕괴', '빛이여!', '강화 마법입니다!', '슈퍼 노바, 각성입니다!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아코', 
                '신비/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test35', 
                '정찰의 결과입니다.', '보급 작전 플랜B', '보급 지원, 시작합니다.', '전술 보조, 시작합니다.'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '와카모', 
                '신비/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test36', 
                '진홍빛 꽃점', '흩날리는 꽃보라', '피어난 파괴충동', '만개한 투쟁본능'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이로하', 
                '신비/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test37', 
                '갑니다. 토라마루', '귀찮네요…….', '어쩔 수 없네요.', '다들 제대로 해주세요.'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이즈나', 
                '신비/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test38', 
                '이즈나 인법첩!', '비기! 폭발수리검!', '이즈나류 인법! 따끔따끔의 술!', '이즈나류 인법! 무럭무럭의 술!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '츠쿠요', 
                '신비/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test39', 
                '츠, 츠쿠요 인법첩…이에요!', '수리검, 잔뜩 연습했어요!', '저, 덩치가 크니까요….', '아, 아직 쓰러질 수 없어요!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '카호', 
                '신비/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test40', 
                '팬으로서의 몸가짐', '시작 전의 마음가짐', '한결같은 열정', '고요한 여유'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '코유키', 
                '신비/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test41', 
                '뜻 밖의 변수', '하나? 혹은 둘!', '기적을 믿나요?', '나비효과'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '하루나', 
                '신비/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test42', 
                '꿰뚫는 엘레강스', '폭발하는 엑조틱', '미식가의 기품', '미식가의 신중함'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히나타', 
                '신비/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test43', 
                '마지막 대화수단', '우선 대화를…!', '뜻밖의 전개', '무거운 건 맡겨주세요!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '나츠', 
                '신비/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test44', 
                '비장의 수단', '한 입씩!', '든든하게!', '입안에 쌓이는 행복'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '세나', 
                '신비/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test45', 
                '응급차량 출동', '에너지제 주입', '응급 지원', '가급적 신속하게'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '레이', 
                '진동/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test46', 
                '밀레니엄의 4번 타자!', '파인 플레이', '내일의 슬러거', '쓰리 아웃 체인지'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '렌게', 
                '진동/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test47', 
                '백화요란식 사격술', '불타오르는 열정', '백화요란의 귀신 교관', '돌격대장으로서의 본분'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '유카리', 
                '진동/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test48', 
                '올곧게 피어난 결의', '애타게 기다려온 재회', '백화요란의 엘리~트', '고개 들어 마주한 책무'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이치카', 
                '진동/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test49', 
                '잠깐 부탁하겠슴다', '정의실현부의 연락망', '예리한 본성', '그럴 수도 있죠'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '치아키', 
                '진동/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test50', 
                '그게 정말 사실인가요?', '자 여기 보세요!', '탐사보도입니다!', '네! 황송합니다!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '카스미', 
                '진동/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test51', 
                '자이언트 힐 크러시', '중요한 건 메시지야', '미치광이 전략', '굴착기는 소음을 멈췄나?'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '키라라', 
                '진동/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test52', 
                '게헨나의 셀러브리티!', '언제나 반짝반짝하게!', '크레이프의 달콤함', '두근두근☆이란 느낌?'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '키사키', 
                '진동/탄력장갑', 
                'android.resource://com.example.projectarchive/drawable/test53', 
                '조령: 격물치지', '칙령: 수신제가', '제령: 극기복례', '포고천하'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '키쿄', 
                '진동/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test54', 
                '신기묘산의 한 수', '지피지기 백전불태', '작전참모로서의 소양', '풍림화산의 계책'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '모미지', 
                '진동/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test55', 
                '위대한 소통법', '위대한 소통법', '수집가의 의지', '여정의 시작'
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
