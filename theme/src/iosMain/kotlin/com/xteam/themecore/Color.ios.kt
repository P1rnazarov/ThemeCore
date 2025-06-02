package com.xteam.themecore

actual class Color(
    actual val hex: String
) {
    actual companion object {
        actual fun fromHex(hex: String): Color {
            return Color(hex)
        }
    }
}