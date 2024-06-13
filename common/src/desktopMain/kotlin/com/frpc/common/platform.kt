package com.frpc.common

import androidx.compose.runtime.Composable
import kotlinx.serialization.json.JsonObject
public actual fun getPlatformName(): String {
    return "demo"
}

actual fun getFrpcVersion(): String {
    return "Frpclib Version()!!"
}

actual fun updateIniFile(
    filePath: String,
    json: JsonObject
): Int {
    TODO("Not yet implemented")
}

actual fun getRandom():Int {
    val random = (0..100).random()
    return random
}

@Composable
public fun UIShow() {
    App()
}