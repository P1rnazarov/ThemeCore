package com.xteam.themecore

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object ThemeManager {
    private val _themeFlow = MutableStateFlow(LightTheme)
    val themeFlow: StateFlow<ThemeType> = _themeFlow

    val currentTheme: ThemeType
        get() = _themeFlow.value

    fun setTheme(theme: ThemeType) {
        _themeFlow.value = theme
    }

    fun toggleDarkMode() {
        _themeFlow.value = if (_themeFlow.value.isDark) LightTheme else DarkTheme
    }

    fun setColors(
        primary: Color? = null,
        background: Color? = null,
        onBackground: Color? = null,
        surface: Color? = null,
        onPrimary: Color? = null
    ) {
        val old = _themeFlow.value
        _themeFlow.value = old.copy(
            primary = primary ?: old.primary,
            background = background ?: old.background,
            onBackground = onBackground ?: old.onBackground,
            surface = surface ?: old.surface,
            onPrimary = onPrimary ?: old.onPrimary
        )
    }
}