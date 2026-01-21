package com.wuan.pmdm_ud4_pev

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@Composable
fun ImagesPracticeScreen(navController: NavController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(40.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "Catalogo peliculas",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Predator: Badlands",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { navController.navigate("video") }) {
                Text(text = "Trailer")
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(onClick = {
                navController.navigate("audio1")
            }) {
                Text(text = "Podcast")
            }
        }

        Text(
            text = "Avatar: Fuego y ceniza",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            textAlign = TextAlign.Center
        )

        AsyncImage(
            model = ImageRequest.Builder(context)
                .data("https://lumiere-a.akamaihd.net/v1/images/image_8ac3fa97.jpeg?region=0%2C0%2C540%2C810")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            error = painterResource(R.drawable.error),
            contentDescription = "Avatar: Fuego y ceniza",
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { navController.navigate("video") }) {
                Text(text = "Trailer")
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(onClick = {
                navController.navigate("audio2")
            }) {
                Text(text = "Podcast")
            }
        }



        Text(
            text = "Padre no hay mas que uno 5",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.local_image2),
            contentDescription = "Padre no hay mas que uno 5",
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { navController.navigate("video") }) {
                Text(text = "Trailer")
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(onClick = {
                navController.navigate("audio3")
            }) {
                Text(text = "Podcast")
            }
        }
    }
}