package com.abimanyu.quizp7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abimanyu.quizp7.ui.theme.QuizP7Theme

class MyScheduleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizP7Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScheduleMain { onBack() }
                }
            }
        }
    }

    private fun onBack() {
        finish()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScheduleMain(onBackPressedCallback: () -> Unit = { }) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.surface,
                ),
                title = {
                        Text(
                            "Jadwal Kuliah Saya di Semester 5",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressedCallback() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back to Overview",
                            tint = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                MyScheduleMainContent()
            }
        }
    )
}

@Composable
fun MyScheduleMainContent() {
    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Senin\t\t\t: Pemrograman Mobile dan Pembelajaran Mesin")
        Text("Selasa\t\t: Pembangunan Perangkat Lunak Berorientasi Service, Realitas Virtual dan Dealitas Augmentasi, Prakikum Pembelajaran Mesin, dan Bahasa Inggris")
        Text("Rabu\t\t\t: Praktikum Pemrograman Mobile dan Visualisasi Data")
        Text("Kamis\t\t: Sistem Terdistribusi dan Internet of Things")
    }
}

// For displaying preview in
// the Android Studio IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreviewWebView() {
    MyScheduleMain()
}