package dev.aaa1115910.bv.util

import androidx.compose.ui.Modifier

/**
 * Conditionally applies a modifier.
 *
 * @param condition The condition to evaluate.
 * @param modifier The modifier to apply if the condition is true.
 * @return The original modifier with the new modifier applied if the condition is true.
 */
inline fun Modifier.runIf(condition: Boolean, block: Modifier.() -> Modifier): Modifier =
    if (condition) then(block(Modifier)) else this
