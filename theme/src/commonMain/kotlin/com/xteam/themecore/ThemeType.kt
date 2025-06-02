package com.xteam.themecore

data class ThemeType(
    val isDark: Boolean,
    val primary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onPrimary: Color
)

val LightTheme = ThemeType(
    isDark = false,
    primary = Color.fromHex("#6200EE"),
    background = Color.fromHex("#FFFFFF"),
    onBackground = Color.fromHex("#000000"),
    surface = Color.fromHex("#F5F5F5"),
    onPrimary = Color.fromHex("#FFFFFF")
)

val DarkTheme = ThemeType(
    isDark = true,
    primary = Color.fromHex("#BB86FC"),
    background = Color.fromHex("#121212"),
    onBackground = Color.fromHex("#FFFFFF"),
    surface = Color.fromHex("#1E1E1E"),
    onPrimary = Color.fromHex("#000000")
)