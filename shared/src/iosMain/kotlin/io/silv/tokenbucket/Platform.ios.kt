package io.silv.tokenbucket

import kotlin.experimental.ExperimentalNativeApi
import kotlin.time.TimeSource

internal actual fun platformNanoTime(): Long = TimeSource.Monotonic.markNow().elapsedNow().inWholeNanoseconds

@OptIn(ExperimentalNativeApi::class)
internal actual inline fun assert(value: Boolean, lazyMessage:() -> String) {
    kotlin.assert(value, lazyMessage)
}