package io.silv.tokenbucket

internal expect fun platformNanoTime(): Long

internal expect inline fun assert(value: Boolean, lazyMessage: () -> String)