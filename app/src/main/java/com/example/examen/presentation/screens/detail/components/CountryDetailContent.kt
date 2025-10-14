package com.example.examen.presentation.screens.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.examen.domain.model.Country

@Suppress("ktlint:standard:function-naming")
@Composable
fun CountryDetailContent(country: Country) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = country.flagUrl,
            contentDescription = country.name,
            modifier = Modifier.size(200.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = country.name,
            style = MaterialTheme.typography.headlineMedium,
        )

        Spacer(modifier = Modifier.height(8.dp))

        country.capital?.let { capital ->
            Text(
                text = "Capital: $capital",
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        country.region?.let { region ->
            Text(
                text = "Region: $region",
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            country.population?.let { population ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Population")
                    Text("$population")
                }
            }
            country.area?.let { area ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Area")
                    Text("$area km²")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        country.borders?.let { borders ->
            if (borders.isNotEmpty()) {
                Text("Borders", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = borders.joinToString(", "),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}