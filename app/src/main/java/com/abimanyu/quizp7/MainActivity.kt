package com.abimanyu.quizp7

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abimanyu.quizp7.ui.theme.QuizP7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizP7Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.surface,
                ),
                title = {
                    Text(
                        "Abimanyu Damarjati",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            )
        },
        content = { padding -> ProfileContent(padding) }
    )
}

@Composable
fun ProfileContent(paddingValues: PaddingValues) {
    val context = LocalContext.current
    val painter = painterResource(R.drawable.foto_keluarga)

    Column(
        Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
        ) {
            Image(
                painter,
                contentDescription = "Foto Keluarga",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Column(
            Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("My Profile", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                Text("Passionate in solving problems and love working with server-side technologies. When faced with a challenge, I tap into my inner artist and use my creativity to develop innovative solutions. Overall, I am a driven and versatile developer with love for technology and flair for the creative.")
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Detail", fontWeight = FontWeight.SemiBold)
                    Text("Name\t\t: Abimanyu Damarjati")
                    Text("NIM\t\t\t\t: 2110511110")
                    Text("Major\t\t\t: Informatics")
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(ButtonDefaults.IconSpacing)
            ) {
                Image(
                    painter = painterResource(R.drawable.foto),
                    contentDescription = "Abimanyu Damarjati",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                )

                Text("Abimanyu Damarjati")
            }
            Button(
                onClick = {
                    context.startActivity(Intent(context, MyScheduleActivity::class.java))
                },
                Modifier
                    .fillMaxWidth()
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(ButtonDefaults.IconSpacing)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar_clock),
                        contentDescription = "Calendar  Clock",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                    )
                    Text("My Schedule")
                }
            }
        }
    }
}

// For displaying preview in
// the Android Studio IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}