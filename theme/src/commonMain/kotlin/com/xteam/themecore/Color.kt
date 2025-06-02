package com.xteam.themecore

expect class Color {
    val hex: String
    companion object {
        fun fromHex(hex: String): Color
    }
}