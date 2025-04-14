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
                '네루(바니걸)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test2', 
                '거기 꼼짝말고 있어!', '구경 났어!?', '까칠함', '특별히 더 아프게'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '노노미(수영복)', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test3', 
                '시원해질 시간이에요~♣', '다 같이 신나게!', '기다릴 수 없어요~♧', '차가울 거에요~!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '노도카', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test4', 
                '관측 지원', '집요한 감시', '관측의 미학', '특별반의 유대'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '노도카(온천)', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test5', 
                '227호 온천장, 개장합니다!', '여주인의 접객', '탕치의 효능', '온천의 열기'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '루미', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test6', 
                '천하일미!', '영업상 안전규정', '상인회장의 자부심', '기억에 남는 맛'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '마리(아이돌)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test7', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '폭발/', 
                'android.resource://com.example.projectarchive/drawable/test8', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '폭발/', 
                'android.resource://com.example.projectarchive/drawable/test9', 
                '넘치는 하트', '자애의 키스 날리기', '끊임없는 노력', '힘든 것도 잊어요'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '마시로', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test10', 
                '정의의 일격', '정의의 심판', '정의의 숨결', '정의의 결속'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '폭발/', 
                'android.resource://com.example.projectarchive/drawable/test11', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '마키(캠핑)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test12', 
                '조금, 조금만 더…!', '예술의 흔적', '활기찬 휴일', '일출의 반짝임'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '폭발/', 
                'android.resource://com.example.projectarchive/drawable/test13', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '메구', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test14', 
                '화끈한 거, 좋아하지?', '따끈하게 해줄까?', '이 정도는 거뜬하지!', '아~ 시원하다!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '무츠키', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test15', 
                '작열의 세레나데', '폭열의 아리아', '재미있게 놀자!', '신나게 가볼까?'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미나', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test16', 
                '용호상박', '파죽지세', '일전불사', '기호지세'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미네', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test17', 
                '신념과 긍지', '준엄한 선고', '기사단의 의지', '불굴의 용기'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미네(아이돌)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test18', 
                '슈퍼 아이돌 랜딩', '콕 찍어 가리키기', '장시간 라이브', '팬들의 성원'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미노리', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test19', 
                '전진 또 전진!', '하나 된 의지', '손에 손잡고', '노동의 결실'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미사키', 
                '폭발/', 
                'android.resource://com.example.projectarchive/drawable/test20', 
                '헛된 세계', '빨리 끝내고 싶어', '의미 없이 익힌 기술', '등가교환'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미야코(수영복)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test21', 
                '비행 드론 가동', '자외선 대책', '꾸준한 훈련', '전술 기동'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '미유(수영복)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test22', 
                '갈매기의 습격', '은밀한 일격', '수중용 복합탄환', '관측 상황 보고'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '사야', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test23', 
                '나님의 걸작이라고!', '새로운 실험이야!', '나님은 역시 위대해!', '나님만 믿으라고!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '사오리', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test24', 
                'et omnia vanitas!', '지향 사격', '훈련의 성과', '리더로서의 책임감'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '사츠키', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test25', 
                '강해진 기분이 든다~', '타겟 정보 수집', 'NK 울트라 프로젝트', '만마전에 충성하도록'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '사쿠라코(아이돌)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test26', 
                '갭 모에 아이돌', '사실 누구보다 귀여워', '지켜보고 있어요', '서로 응원하기'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '사키(수영복)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test27', 
                '신호조명탄, 투척!', '엄호사격', '정밀한 정비', '전우애'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '세리카', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test28', 
                '걸리적거리잖아!', '조준 사격', '알바생의 근성', '대책위의 분노'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '쇼쿠호 미사키', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test29', 
                '멘탈 아웃', '잠시 도와주겠어?', '토키와다이의 여왕', '나는 두뇌파라서 말이야'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '슌', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test30', 
                '나쁜 아이는 어디있나요?', '모두 집중하세요!', '교관의 품격', '매화원의 훈육법'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '슌(어린이)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test31', 
                '나쁜 어른은 어디 있나요?', '때찌, 할 거에요!', '활기찬 어린이', '무거운 총'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '스즈미', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test32', 
                '사제 섬광탄', '순찰자의 저력', '긴급 회피', '순찰자의 맹습'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '시구레', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test33', 
                '시구레 특제 보틀 그레네이드', '한 잔, 어때?', '달콤한 발효', '야생의 감 '
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '시로코', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test34', 
                '드론 소환: 화력 지원', '수류탄 투척', '약점 노리기', '고속 연사'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '시미코', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test35', 
                '지식의 방패', '마음의 양식', '지식을 쌓읍시다!', '아는 만큼 보입니다!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아루', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test36', 
                '하드보일드 샷', '느와르 어택', '사장님의 위엄', '무법자의 길'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아스나(교복)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test37', 
                '여기야, 여기!', '함께 찰칵!', '힘내!', '이쪽으로!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아이리', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test38', 
                '아깝지만, 에잇!', '머리가 띵해질지도…?', '디저트의 힘', '아이리의 응원'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아이리(밴드)', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test39', 
                '행복한 멜로디', '초코민트 스케일', '더 크게 더 멀리', '스며드는 감정'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '', 
                '폭발/', 
                'android.resource://com.example.projectarchive/drawable/test40', 
                '', '', '', ''
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아즈사', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test40', 
                'intulit mortem', 'sagitta mortis', '가혹한 훈련', '약점 조준'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아츠코', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test41', 
                '이것도 나의 힘……?', '숨을게', '가르침에서 배운 것', '가르침에서 배운 것'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아카리', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test42', 
                '유탄 일발, 가득 담아서!', '매콤하게, 한 그릇 더!', '잘 먹었습니다!', '아직 더 먹을 수 있어요!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '아코(드레스)', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test43', 
                '완벽한 에이전트', '타깃은 놓치지 않습니다!', '요원으로서의 자신감', '작전의 성과'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '에이미', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test44', 
                '불굴의 의지', '집념의 맹격', '스페셜리스트의 휴식', '강인한 정신력'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '요시미(밴드)', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test45', 
                '폭발적인 클라이막스', '비주얼 메이커', '로큰롤', '스위트 하모닉스'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '우이', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test46', 
                '고서 전문가', '지식전수', '문가의 날카로움', '신경과민'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '유우카', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test47', 
                'Q.E.D', 'I.F.F', '최적해 도출', '고속 암산'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '유우카(파자마)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test48', 
                '위기일발 페로로님', '숙면을 위한 케어', '달콤한 속잠', '휴식 뒤의 나른함'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '유즈(메이드)', 
                '폭발/탄력장갑', 
                'android.resource://com.example.projectarchive/drawable/test49', 
                '잠입, 스타트!', '하이 스코어 어택', '섬세한 코딩', '게임개발부의 유대'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이오리(수영복)', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test50', 
                '질풍노도', '질풍노도', '정밀조준', '스페셜리스트의 위압'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이즈미', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test51', 
                '치즈 초콜릿 햄버거~', '준비하고, 빠앙!', '또 뭘 먹지?', '맛있는 게 최고야~'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이즈미(새해)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test52', 
                '모두를 위한 타코야키!', '찹쌀떡이야!', '찹쌀떡이야!', '함께 떠나자!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '이즈미(수영복)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test53', 
                '시원한 코코넛 주스!', '새콤달콤 와삭와삭!', '자, 먹고 힘내자~!', '맛있는 만큼 어질어질!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '주리', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test54', 
                '주리의 요리 시간!', '최선의 요리', '의욕만만!', '주리의 식사 시간!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '체리노(온천)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test55', 
                '숙청군 1호, 출격이다!', '조준, 숙청!', '수염의 분노!', '이것이 수염의 위력이다!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '카린(교복)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test56', 
                '위기에서 빛나는 가이드', '먼 곳에서의 지원', '항상 살피는 눈', '인기 있는 가이드'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '카에데', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test57', 
                '신호탄, 발사!!', '신호탄, 발사!!', '치유의 파동! 이야압!', '아직 열심히 할 수 있어!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '카요코', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test58', 
                '패닉 브링거', '패닉샷', '무서운 얼굴', '어쩔 수 없네'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '카즈사(밴드)', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test59', 
                '역사적인 첫 소절', '베이스 튜닝', '무대 체질', '달콤한 목소리'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '칸나(수영복)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test60', 
                '수상안전, 실시!', '철저한 준비운동', '라이프가드의 마음가짐', '어색한 미소'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '코타마', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test61', 
                '감청 개시', '약점 도청', '약점 도청', '전파 확산'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '코토리(응원단)', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test62', 
                '축포 세례', '아, 그건 말이죠!', '아, 그건 말이죠!', '도움이 돼서 기뻐요!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '코하루', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test63', 
                '성스러운 수류탄', '치료해주겠다고!', '치료해주겠다고!', '엘리트니까!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '키리노', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test64', 
                '협상은 없습니다!', '폭력은 제압합니다!', '회복은 신속하게!', '쉴 틈은 없습니다!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '토키', 
                '폭발/탄력장갑', 
                'android.resource://com.example.projectarchive/drawable/test65', 
                '<시스템: 아비 에슈흐>', '전술적 판단', '전술적 판단', '눈에는 눈'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '토키(바니걸)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test66', 
                '<특수무장: 암기어>', '에이전트의 비밀도구', '에이전트의 비밀도구', '무장을 다루는 방법'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '하나에', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test67', 
                '치료시간이에요~', '쓰러지면 안 돼요!', '치료 숙달', '모두 힘내세요~!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '하레', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test68', 
                'EMP 드론 전개', '파괴 공작: 플랜 A', '무장 강화: 플랜 B', '요격 시스템 가동'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '하레(캠핑)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test69', 
                '모닥불 안의 별미', '퍼지는 온기', '디톡스 효과', '캠핑의 묘미'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '하루나(새해)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test70', 
                '미식가의 분노', '미식가의 신념', '신년의 비앙드', '송별의 데세르'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '하루카', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test71', 
                '펌프패닝', '트리거 오버', '히, 힘내겠습니다!', '으아아아아아-?!'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '하루카(새해)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test72', 
                '누가 허락했죠…!?', '확실하게 인사하기', '용서못해용서못해', '모두를 위한 마음'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '하츠네 미쿠', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test73', 
                '이 순간순간에, 마음을 담아서!', '하츠네 미쿠의 열정', '하츠네 미쿠의 응원', '하츠네 미쿠의 축복'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '호시노(수영복)', 
                '폭발/특수장갑', 
                'android.resource://com.example.projectarchive/drawable/test74', 
                '수상 지원', '수상 습격', '더위 참기', '해변의 즐거움'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '후부키(수영복)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test75', 
                '시원한 꼼수', '꼭 해야 해?', '땡땡이의 미학', '부탁 좀 할게~'
            )
        """.trimIndent())
        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '후우카', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test76', 
                '급식 시간!', '급양부의 배려', '신선한 재료 수급!', '급양부의 긍지'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히나', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test77', 
                '이스보셋', '리로드 앤 디스트로이', '선도부의 냉철', '철두철미'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히나(드레스)', 
                '폭발/탄력장갑', 
                'android.resource://com.example.projectarchive/drawable/test78', 
                '이스보셋', '빈틈없는 준비', '연주에 임하는 마음', '전하고픈 진심을 이곳에'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히나(수영복)', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test79', 
                '해변의 이스보셋', '쓰로우 앤 녹아웃', '쓰로우 앤 녹아웃', '풍기집행'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히나타(수영복)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test80', 
                '조금 과한 물세례', '시원한 물세례', '원정대의 열정', '모두를 돕는 손'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히비키', 
                '폭발/중장갑', 
                'android.resource://com.example.projectarchive/drawable/test81', 
                '아플 확률이 높아', '화력은 충분할지도', '위험할지도 몰라', '도움이 되길 바라'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히비키(응원단)', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test82', 
                '조금 뜨거울지도 몰라', '이 목소리가 닿는다면', '열정은 충분해', '어쩐지 부끄러워…'
            )
        """.trimIndent())

        db.execSQL("""
            INSERT INTO $TABLE_STUDENTS (name, type, image_path, skill1, skill2, skill3, skill4)
            VALUES (
                '히요리', 
                '폭발/경장갑', 
                'android.resource://com.example.projectarchive/drawable/test83', 
                '지, 지금 지원할게요!', '마, 많이 아플 거에요!', '마, 많이 아플 거에요!', '부록의 힘이에요!'
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
