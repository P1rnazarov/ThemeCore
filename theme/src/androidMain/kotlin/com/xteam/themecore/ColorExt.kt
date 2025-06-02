package com.xteam.themecore

import androidx.compose.ui.graphics.Color as ComposeColor
import android.graphics.Color.parseColor

fun Color.toCompose(): ComposeColor {
    return ComposeColor(parseColor(this.hex))
}