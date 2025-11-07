package dev.aaa1115910.bv.mobile.screen.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.aaa1115910.bv.util.Prefs

@Composable
fun SponsorBlockSettingsScreen() {
    val categories = listOf(
        "sponsor",
        "poi_highlight",
        "interaction",
        "intro",
        "outro",
        "music_offtopic",
        "preview",
        "filler"
    )
    val enabledCategories = remember { mutableStateOf(Prefs.sponsorBlockEnabledCategories) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Sponsor Block Settings")
        categories.forEach { category ->
            var isEnabled by remember { mutableStateOf(enabledCategories.value.contains(category)) }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isEnabled,
                    onCheckedChange = {
                        isEnabled = it
                        if (isEnabled) {
                            enabledCategories.value = enabledCategories.value + category
                        } else {
                            enabledCategories.value = enabledCategories.value - category
                        }
                        Prefs.sponsorBlockEnabledCategories = enabledCategories.value
                    }
                )
                Text(text = category)
            }
        }
    }
}
