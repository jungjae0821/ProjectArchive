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

    var currencyInput by remember { mutableStateOf("") } // 사용자가 입력한 재화 값
    var todayCurrency by remember { mutableStateOf(dbHelper.getTodayCurrency()) } // 오늘 획득한 재화
    var weeklyTotal by remember { mutableStateOf(dbHelper.getTotalCurrency(7)) } // 최근 7일 총합
    var monthlyTotal by remember { mutableStateOf(dbHelper.getTotalCurrency(30)) } // 최근 30일 총합

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "일일 퀘스트 계산기", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        // ✅ 재화 입력 필드 ✅
        OutlinedTextField(
            value = currencyInput,
            onValueChange = { currencyInput = it },
            label = { Text("오늘 획득한 재화 입력") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // ✅ 저장 버튼 ✅
        Button(
            onClick = {
                val amount = currencyInput.toIntOrNull()
                if (amount != null && amount >= 0) {
                    dbHelper.insertOrUpdateCurrency(amount)
                    todayCurrency = dbHelper.getTodayCurrency()
                    weeklyTotal = dbHelper.getTotalCurrency(7)
                    monthlyTotal = dbHelper.getTotalCurrency(30)
                    currencyInput = ""
                    Toast.makeText(context, "저장되었습니다!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "올바른 값을 입력하세요.", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text("저장")
        }

        // ✅ 데이터 표시 ✅
        Text(text = "오늘 획득한 재화: $todayCurrency 개", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "최근 7일 총합: $weeklyTotal 개", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "최근 30일 총합: $monthlyTotal 개", fontSize = 18.sp)
    }
}
