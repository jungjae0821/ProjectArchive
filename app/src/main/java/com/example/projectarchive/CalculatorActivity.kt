package com.example.projectarchive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
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
    var input1 by remember { mutableStateOf(TextFieldValue("")) }
    var input2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "계산기", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = input1,
            onValueChange = { input1 = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        BasicTextField(
            value = input2,
            onValueChange = { input2 = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Button(
            onClick = {
                val num1 = input1.text.toDoubleOrNull() ?: 0.0
                val num2 = input2.text.toDoubleOrNull() ?: 0.0
                result = "결과: ${num1 + num2}"
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "더하기")
        }

        Text(text = result, fontSize = 18.sp)
    }
}
