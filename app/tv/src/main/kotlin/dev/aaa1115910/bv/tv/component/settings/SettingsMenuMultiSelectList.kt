package dev.aaa1115910.bv.tv.component.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsMenuMultiSelectList(
    modifier: Modifier = Modifier,
    text: String,
    supportSwitch: Boolean = false,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    enabled: Boolean = true,
    entries: Map<String, String>,
    values: Set<String>,
    onValuesChange: (Set<String>) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var currentValues by remember { mutableStateOf(values) }

    SettingsMenuListItem(
        modifier = modifier,
        text = text,
        supportSwitch = supportSwitch,
        checked = checked,
        onCheckedChange = onCheckedChange,
        enabled = enabled,
        onClick = { showDialog = true }
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = text) },
            text = {
                Column {
                    entries.forEach { (key, value) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = currentValues.contains(key),
                                onCheckedChange = {
                                    currentValues = if (currentValues.contains(key)) {
                                        currentValues - key
                                    } else {
                                        currentValues + key
                                    }
                                }
                            )
                            Text(
                                text = value,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onValuesChange(currentValues)
                        showDialog = false
                    }
                ) {
                    Text(text = "确定")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text(text = "取消")
                }
            }
        )
    }
}
