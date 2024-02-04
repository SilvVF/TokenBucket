package io.silv.tokenbucket

internal actual fun platformNanoTime(): Long = System.nanoTime()

internal actual inline fun assert(value: Boolean, lazyMessage:() -> String) {
    kotlin.assert(value, lazyMessage)
}