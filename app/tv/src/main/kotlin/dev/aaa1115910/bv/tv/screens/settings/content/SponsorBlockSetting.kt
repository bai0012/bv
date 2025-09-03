package dev.aaa1115910.bv.tv.screens.settings.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.aaa1115910.bv.tv.component.settings.SettingsMenuListItem
import dev.aaa1115910.bv.tv.component.settings.SettingsMenuMultiSelectList
import dev.aaa1115910.bv.util.Prefs

@Composable
fun SponsorBlockSetting(
    modifier: Modifier = Modifier
) {
    var sponsorBlockEnabled by remember { mutableStateOf(Prefs.sponsorBlockEnabled) }
    var sponsorBlockAutoSkip by remember { mutableStateOf(Prefs.sponsorBlockAutoSkip) }
    var sponsorBlockShowSkipButton by remember { mutableStateOf(Prefs.sponsorBlockShowSkipButton) }
    var sponsorBlockSkippedToast by remember { mutableStateOf(Prefs.sponsorBlockSkippedToast) }
    var sponsorBlockCategories by remember { mutableStateOf(Prefs.sponsorBlockCategories) }

    val categories = mapOf(
        "sponsor" to "赞助商",
        "selfpromo" to "无偿/自我推广",
        "interaction" to "互动提醒",
        "intro" to "片头",
        "outro" to "片尾",
        "preview" to "前情提要",
        "music_offtopic" to "音乐/非音乐部分",
        "poi_highlight" to "精彩时刻",
        "filler" to "无意义的填充",
        "exclusive_access" to "独家访问",
        "chapter" to "章节"
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SettingsMenuListItem(
            text = "启用 SponsorBlock",
            supportSwitch = true,
            checked = sponsorBlockEnabled,
            onCheckedChange = {
                Prefs.sponsorBlockEnabled = it
                sponsorBlockEnabled = it
            }
        )
        SettingsMenuListItem(
            text = "自动跳过",
            supportSwitch = true,
            checked = sponsorBlockAutoSkip,
            onCheckedChange = {
                Prefs.sponsorBlockAutoSkip = it
                sponsorBlockAutoSkip = it
            },
            enabled = sponsorBlockEnabled
        )
        SettingsMenuListItem(
            text = "显示跳过按钮",
            supportSwitch = true,
            checked = sponsorBlockShowSkipButton,
            onCheckedChange = {
                Prefs.sponsorBlockShowSkipButton = it
                sponsorBlockShowSkipButton = it
            },
            enabled = sponsorBlockEnabled
        )
        SettingsMenuListItem(
            text = "显示已跳过消息",
            supportSwitch = true,
            checked = sponsorBlockSkippedToast,
            onCheckedChange = {
                Prefs.sponsorBlockSkippedToast = it
                sponsorBlockSkippedToast = it
            },
            enabled = sponsorBlockEnabled
        )
        SettingsMenuMultiSelectList(
            text = "选择要跳过的片段类型",
            entries = categories,
            values = sponsorBlockCategories,
            onValuesChange = {
                Prefs.sponsorBlockCategories = it
                sponsorBlockCategories = it
            }
        )
    }
}
