package com.wuan.pmdm_ud4_pev

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AudioPracticeScreen1(navController: NavHostController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    val player = remember {
        MediaPlayer.create(context, R.raw.audio1)
    }

    DisposableEffect(Unit) {
        onDispose {
            // Si está sonando, lo paramos y liberamos recursos
            try {
                if (player.isPlaying) {
                    player.stop()
                }
            } catch (_: IllegalStateException) {
                // Por si el estado no permite stop en algún caso puntual
            }
            player.release()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Podcast",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.local_image),
            contentDescription = "Predator: Badlands",
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
            contentScale = ContentScale.Crop
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(
                onClick = {
                    // Play reproduce desde la posición actual
                    if (!player.isPlaying) {
                        player.start()
                    }
                }
            ) {
                Text("Play")
            }

            Button(
                onClick = {
                    // Pause pausa solo si está reproduciendo
                    if (player.isPlaying) {
                        player.pause()
                    }
                }
            ) {
                Text("Pause")
            }

            Button(
                onClick = {
                    // Reiniciar vuelve al inicio sin auto play
                    player.seekTo(0)
                    if (player.isPlaying) {
                        player.pause()
                    }
                }
            ) {
                Text("Reiniciar")
            }
        }

        Button(
            onClick = { navController.navigate("images") },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
        ) {
            Text(text = "Volver Al Inicio")
        }
    }
}