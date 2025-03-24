package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    val greetingText = remember { mutableStateOf("Boa tarde João, Edgard e filhotes!") }
    val showList = remember { mutableStateOf(false) }


    val timesDeFutebol = listOf(
        "Palmeiras", "Flamengo", "São Paulo", "Corinthians", "Fluminense",
        "Vasco da Gama", "Grêmio", "Internacional", "Atlético Mineiro", "Cruzeiro",
        "Santos", "Botafogo", "Bahia", "Athletico Paranaense", "Ceará",
        "Fortaleza", "Gremio", "Sport Recife", "Fluminense", "Goias",
        "Coritiba", "Chapecoense", "Vitória", "Atlético Goianiense", "Bragantino"
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = greetingText.value,
            style = MaterialTheme.typography.headlineLarge.copy(
                color = Color(0xFF6200EE),
                fontSize = 24.sp,
                letterSpacing = 1.2.sp,
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { showList.value = !showList.value },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(top = 16.dp)
            
        ) {
            Text(
                if (showList.value) "Esconder Lista" else "Mostrar Lista",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (showList.value) {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(timesDeFutebol.size) { index ->
                    Text(
                        text = "${index + 1}. ${timesDeFutebol[index]}",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 18.sp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DefaultPreview() {
    Greeting()
}





