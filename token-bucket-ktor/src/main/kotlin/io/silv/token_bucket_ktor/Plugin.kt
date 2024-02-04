package io.silv.token_bucket_ktor

import io.ktor.client.plugins.api.ClientPlugin
import io.ktor.client.plugins.api.createClientPlugin
import io.silv.tokenbucket.TokenBuckets
import kotlinx.coroutines.ensureActive
import kotlin.coroutines.coroutineContext

class TokenBucketPluginConfig {
    var consumptionAmount: Long = 1L
    var bucket: TokenBuckets.Builder.() -> Unit = {}
}

val TokenBucketPlugin: ClientPlugin<TokenBucketPluginConfig> =
    createClientPlugin("TokenBucketPlugin", ::TokenBucketPluginConfig) {

    val numTokens = pluginConfig.consumptionAmount
    val bucket = TokenBuckets.Builder().apply(pluginConfig.bucket).build()

    onRequest { _, _->

        coroutineContext.ensureActive()

        bucket.consume(numTokens)

        coroutineContext.ensureActive()
    }
}