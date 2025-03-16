package com.example.projectarchive

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainMenuScreen()
        }
    }
}

@Composable
fun MainMenuScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Project Archive",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1565C0) // 파란색 계열
        )

        Spacer(modifier = Modifier.height(24.dp))

        MenuCard("학생 명부", StudentListActivity::class.java)
        MenuCard("계산기", CalculatorActivity::class.java)
        MenuCard("테이블", TableActivity::class.java)
    }
}

@Composable
fun MenuCard(title: String, targetActivity: Class<*>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                // 화면 이동
                val context = androidx.compose.ui.platform.LocalContext.current
                val intent = Intent(context, targetActivity)
                context.startActivity(intent)
            },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)) // 연한 파란색
    ) {
        Box(
            modifier = Modifier.padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Medium)
        }
    }
}
