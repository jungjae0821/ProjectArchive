package com.example.projectarchive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

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
    var selectedStudent by remember { mutableStateOf<Triple<String, String, String>?>(null) } // 선택된 학생

    // 검색 필터 적용
    val filteredStudents = allStudents.filter {
        it.first.contains(searchQuery.text, ignoreCase = true)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "학생 명부", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        // 검색창
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("학생 이름 검색") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // 학생 목록
        LazyColumn {
            items(filteredStudents) { student ->
                StudentItem(student) { selectedStudent = student }
            }
        }

        // 학생 상세 정보 다이얼로그
        if (selectedStudent != null) {
            StudentDetailDialog(student = selectedStudent!!, onDismiss = { selectedStudent = null })
        }
    }
}

@Composable
fun StudentItem(student: Triple<String, String, String>, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "이름: ${student.first}", fontSize = 18.sp)
            Text(text = "타입: ${student.second}", fontSize = 16.sp)

            // 이미지 표시
            Image(
                painter = rememberImagePainter(student.third), // Coil로 이미지 로드
                contentDescription = "학생 사진",
                modifier = Modifier.size(100.dp) // 이미지 크기 설정
            )
        }
    }
}

@Composable
fun StudentDetailDialog(student: Triple<String, String, String>, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("학생 정보") },
        text = {
            Column {
                Text("이름: ${student.first}", fontSize = 18.sp)
                Text("타입: ${student.second}", fontSize = 18.sp)

                // 이미지 표시
                Image(
                    painter = rememberImagePainter(student.third), // Coil로 이미지 로드
                    contentDescription = "학생 사진",
                    modifier = Modifier.size(150.dp) // 이미지 크기 설정
                )
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("닫기")
            }
        }
    )
}
