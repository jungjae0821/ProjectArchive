package com.example.projectarchive

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableScreen()
        }
    }
}

@Composable
fun TableScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // 전체 중앙 정렬
    ) {
        // 타이틀
        Text(
            text = "유용한 정보모음",
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        HelpLinksList()
    }
}

@Composable
fun HelpLinksList() {
    val context = LocalContext.current

    val links = listOf(
        "뉴비 가이드" to "https://gall.dcinside.com/m/projectmx/10386680",
        "학생 생일표" to "https://arona.ai/table/birthday",
        "인게임 BGM 들으러 가기" to "https://arona.ai/jukebox",
        "미래시 가이드" to "https://gall.dcinside.com/m/projectmx/11714202",
        "학생스탯 상세조회" to "https://arona.ai/students",
        "스페셜 학생 공격력" to "https://arona.ai/table/specialatk"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "원하는 정보를 누르면 해당 링크로 이동합니다.",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        links.forEach { (title, url) ->
            val annotatedString = buildAnnotatedString {
                pushStringAnnotation(tag = "URL", annotation = url)
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF1E88E5),
                        textDecoration = TextDecoration.Underline,
                        fontSize = 20.sp
                    )
                ) {
                    append("• $title")
                }
                pop()
            }

            ClickableText(
                text = annotatedString,
                onClick = { offset ->
                    annotatedString.getStringAnnotations("URL", offset, offset)
                        .firstOrNull()?.let { annotation ->
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                            context.startActivity(intent)
                        }
                },
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
