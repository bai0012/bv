package dev.aaa1115910.bv.mobile.component.preferences.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
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
fun MultiSelectListPreference(
    title: String,
    summary: String? = null,
    entries: Map<String, String>,
    values: Set<String>,
    onValuesChange: (Set<String>) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var currentValues by remember { mutableStateOf(values) }

    BaseListItem(
        modifier = Modifier.clickable { showDialog = true },
        title = title,
        summary = summary
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = title) },
            text = {
                Column {
                    entries.forEach { (key, value) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    currentValues = if (currentValues.contains(key)) {
                                        currentValues - key
                                    } else {
                                        currentValues + key
                                    }
                                },
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
