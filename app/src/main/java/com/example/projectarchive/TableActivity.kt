package com.example.projectarchive

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.text.withStyle

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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "테이블 화면", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        HelpLinksList() // 링크 리스트 호출
    }
}

@Composable
fun HelpLinksList() {
    val context = LocalContext.current

    val links = listOf(
        "청휘석 가이드" to "https://gamewiki.example.com/currency-guide",
        "캐릭터 육성 팁" to "https://gamewiki.example.com/character-growth",
        "장비 파밍 루트" to "https://gamewiki.example.com/equipment-farm",
        "이벤트 일정" to "https://gamewiki.example.com/event-calendar"
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("도움이 되는 링크 모음:", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))

        links.forEach { (title, url) ->
            val annotatedString = buildAnnotatedString {
                pushStringAnnotation(tag = "URL", annotation = url)
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF1E88E5),
                        textDecoration = TextDecoration.Underline
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
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}
