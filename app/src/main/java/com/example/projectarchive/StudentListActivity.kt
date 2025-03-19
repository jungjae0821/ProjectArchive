package com.example.projectarchive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class StudentListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentListScreen()
        }
    }
}

@Composable
fun StudentListScreen() {
    val context = LocalContext.current
    val dbHelper = remember { DatabaseHelper(context) }
    val allStudents by remember { mutableStateOf(dbHelper.getAllStudents()) }

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    // 검색어에 따라 필터링된 학생 목록
    val filteredStudents = allStudents.filter {
        it.first.contains(searchQuery.text, ignoreCase = true) // 이름 검색
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "학생 명부", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        // 검색창 추가
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("학생 이름 검색") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // 검색 결과를 리스트로 표시
        LazyColumn {
            items(filteredStudents) { student ->
                StudentItem(student.first, student.second)
            }
        }
    }
}

@Composable
fun StudentItem(name: String, type: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "이름: $name", fontSize = 18.sp)
            Text(text = "타입: $type", fontSize = 16.sp)
        }
    }
}
