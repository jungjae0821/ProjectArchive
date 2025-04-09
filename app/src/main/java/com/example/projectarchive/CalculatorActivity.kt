package com.example.projectarchive

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorScreen()
        }
    }
}

@Composable
fun CalculatorScreen() {
    val context = LocalContext.current
    val dbHelper = remember { CurrencyDatabaseHelper(context) }

    val weeklyCurrency = dbHelper.getWeeklyCurrency() // ✅ 주간 획득 가능 재화
    var weeksInput by remember { mutableStateOf("") } // 입력: 주 단위
    var totalCurrency by remember { mutableStateOf(0) } // 출력: 총 재화

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "청휘석 계산기",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "주간 획득 가능한 청휘석: $weeklyCurrency 개",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 입력 필드
        OutlinedTextField(
            value = weeksInput,
            onValueChange = { weeksInput = it },
            label = { Text("계산할 기간 (주)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // 계산 버튼
        Button(
            onClick = {
                val weeks = weeksInput.toIntOrNull()
                if (weeks != null && weeks > 0) {
                    totalCurrency = weeklyCurrency * weeks
                    Toast.makeText(context, "계산 완료!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "올바른 주 수를 입력하세요.", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("계산")
        }

        // 결과 표시
        if (totalCurrency > 0) {
            Text(
                text = "총 획득 가능한 재화: $totalCurrency 개",
                fontSize = 20.sp
            )
        }
    }
}
