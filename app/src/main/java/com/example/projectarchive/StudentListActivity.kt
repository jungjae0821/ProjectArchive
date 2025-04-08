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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

// ✅ Student 데이터 클래스 정의
data class Student(
    val name: String,
    val type: String,
    val imagePath: String,
    val skill1: String,
    val skill2: String,
    val skill3: String,
    val skill4: String
)

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
    var selectedStudent by remember { mutableStateOf<Student?>(null) }

    val filteredStudents = allStudents.filter {
        it.name.contains(searchQuery.text, ignoreCase = true)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("학생 명부", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("학생 이름 검색") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        LazyColumn {
            items(filteredStudents) { student ->
                StudentItem(student) { selectedStudent = student }
            }
        }

        if (selectedStudent != null) {
            StudentDetailDialog(student = selectedStudent!!, onDismiss = { selectedStudent = null })
        }
    }
}

@Composable
fun StudentItem(student: Student, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("이름: ${student.name}", fontSize = 16.sp)
            Text("타입: ${student.type}", fontSize = 16.sp)
        }
    }
}

@Composable
fun StudentDetailDialog(student: Student, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("학생 정보") },
        text = {
            Column {
                Image(
                    painter = rememberImagePainter(student.imagePath),
                    contentDescription = "학생 사진",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(bottom = 16.dp)
                )
                Text("이름: ${student.name}", fontSize = 16.sp)
                Text("타입: ${student.type}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("스킬 1: ${student.skill1}")
                Text("스킬 2: ${student.skill2}")
                Text("스킬 3: ${student.skill3}")
                Text("스킬 4: ${student.skill4}")
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("닫기")
            }
        }
    )
}
