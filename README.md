Token bucket rate limiting based on https://github.com/bbeck/token-bucket. 
Supports Kotlin Multiplatform and includes plugin for use with KTOR client.

See also:
* [Original implementation](https://github.com/bbeck/token-bucket)
* [Wikipedia - Token Bucket](http://en.wikipedia.org/wiki/Token_bucket)
* [Wikipedia - Leaky Bucket](http://en.wikipedia.org/wiki/Leaky_bucket)

# from original 
Introduction
------------
This library provides an implementation of a token bucket algorithm which is useful for providing rate limited access
to a portion of code.  The implementation provided is that of a "leaky bucket" in the sense that the bucket has a finite
capacity and any added tokens that would exceed this capacity will "overflow" out of the bucket and be lost forever.

In this implementation the rules for refilling the bucket are encapsulated in a provided RefillStrategy instance.  Prior
to attempting to consume any tokens the refill strategy will be consulted to see how many tokens should be added to the
bucket
