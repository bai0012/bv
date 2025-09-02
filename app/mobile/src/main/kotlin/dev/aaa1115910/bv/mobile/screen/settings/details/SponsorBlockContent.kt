package dev.aaa1115910.bv.mobile.screen.settings.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
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
import com.fredporciuncula.flow.preferences.compose.rememberFlowPreference
import dev.aaa1115910.bv.mobile.component.preferences.PreferenceSwitch
import dev.aaa1115910.bv.util.PrefKeys
import dev.aaa1115910.bv.util.Prefs

@Composable
fun SponsorBlockContent(
    modifier: Modifier = Modifier
) {
    val sponsorBlockEnabled by rememberFlowPreference(PrefKeys.prefSponsorBlockEnabledRequest)
    var sponsorBlockCategories by remember {
        mutableStateOf(
            runCatching { Prefs.sponsorBlockCategories }.getOrDefault(
                emptyList()
            )
        )
    }

    val allCategories = listOf(
        "sponsor", "intro", "outro", "interaction", "selfpromo",
        "music_offtopic", "preview", "poi_highlight", "filler", "exclusive_access", "chapter"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            PreferenceSwitch(
                title = "启用 SponsorBlock",
                checked = sponsorBlockEnabled,
                onCheckedChange = { Prefs.sponsorBlockEnabled = it }
            )
        }
        item {
            Text("要跳过的分类")
        }
        items(allCategories.size) { index ->
            val category = allCategories[index]
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = sponsorBlockCategories.contains(category),
                    onCheckedChange = {
                        val newCategories = sponsorBlockCategories.toMutableList()
                        if (it) {
                            newCategories.add(category)
                        } else {
                            newCategories.remove(category)
                        }
                        sponsorBlockCategories = newCategories
                        Prefs.sponsorBlockCategories = newCategories
                    }
                )
                Text(text = category)
            }
        }
    }
}
