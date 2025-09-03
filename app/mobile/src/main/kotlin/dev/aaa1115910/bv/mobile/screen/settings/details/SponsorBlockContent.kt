package dev.aaa1115910.bv.mobile.screen.settings.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.aaa1115910.bv.mobile.component.preferences.PreferenceGroup
import dev.aaa1115910.bv.mobile.component.preferences.items.MultiSelectListPreference
import dev.aaa1115910.bv.mobile.component.preferences.items.SwitchPreference
import dev.aaa1115910.bv.util.Prefs

@Composable
fun SponsorBlockContent(
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
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        PreferenceGroup(
            title = "常规"
        ) {
            SwitchPreference(
                title = "启用 SponsorBlock",
                checked = sponsorBlockEnabled,
                onCheckedChange = {
                    Prefs.sponsorBlockEnabled = it
                    sponsorBlockEnabled = it
                }
            )
            SwitchPreference(
                title = "自动跳过",
                summary = "当进入片段时自动跳过",
                checked = sponsorBlockAutoSkip,
                onCheckedChange = {
                    Prefs.sponsorBlockAutoSkip = it
                    sponsorBlockAutoSkip = it
                },
                enabled = sponsorBlockEnabled
            )
            SwitchPreference(
                title = "显示跳过按钮",
                summary = "在屏幕上显示一个用于跳过片段的按钮",
                checked = sponsorBlockShowSkipButton,
                onCheckedChange = {
                    Prefs.sponsorBlockShowSkipButton = it
                    sponsorBlockShowSkipButton = it
                },
                enabled = sponsorBlockEnabled
            )
            SwitchPreference(
                title = "显示已跳过消息",
                summary = "当片段被跳过时显示一条 Toast 消息",
                checked = sponsorBlockSkippedToast,
                onCheckedChange = {
                    Prefs.sponsorBlockSkippedToast = it
                    sponsorBlockSkippedToast = it
                },
                enabled = sponsorBlockEnabled
            )
        }
        PreferenceGroup(
            title = "片段类型"
        ) {
            MultiSelectListPreference(
                title = "选择要跳过的片段类型",
                summary = "选择您希望 SponsorBlock 跳过的片段类型",
                entries = categories,
                values = sponsorBlockCategories,
                onValuesChange = {
                    Prefs.sponsorBlockCategories = it
                    sponsorBlockCategories = it
                }
            )
        }
    }
}
