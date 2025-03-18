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
    val students by remember { mutableStateOf(dbHelper.getAllStudents()) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "학생 명부", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn {
            items(students) { student ->
                StudentItem(student.first, student.second)
            }
        }
    }
}

@Composable
fun StudentItem(name: String, birthday: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "이름: $name", fontSize = 18.sp)
            Text(text = "생일: $birthday", fontSize = 16.sp)
        }
    }
}
