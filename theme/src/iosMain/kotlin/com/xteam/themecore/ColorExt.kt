package com.xteam.themecore

import kotlinx.cinterop.*
import platform.Foundation.*
import platform.UIKit.*
import platform.darwin.UInt64Var

@OptIn(ExperimentalForeignApi::class)
fun Color.toUIColor(): UIColor {
    val hex = hex.removePrefix("#")
    val scanner = NSScanner(string = hex)

    memScoped {
        val rgbPtr = alloc<UInt64Var>()
        if (scanner.scanHexLongLong(rgbPtr.ptr)) {
            val rgb = rgbPtr.value
            val r = ((rgb and 0xFF0000u) shr 16).toDouble() / 255.0
            val g = ((rgb and 0x00FF00u) shr 8).toDouble() / 255.0
            val b = (rgb and 0x0000FFu).toDouble() / 255.0

            return UIColor(red = r, green = g, blue = b, alpha = 1.0)
        }
    }
    return UIColor.blackColor
}