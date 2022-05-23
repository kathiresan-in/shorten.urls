package com.dkb.url.shorten.service.impl

import org.springframework.stereotype.Component
import java.util.Random
@Component
class Base62UniqueIdGenerator(
    private val base62Chars : String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",
    private val bound : Int = 999999,
    private val random: Random = Random()
) {
    fun generateShortUrlByRandomNumber() : String {
        val shortUrl : StringBuilder = StringBuilder()
        var uniqueIdentifier : Int = random.nextInt(bound)
        while (uniqueIdentifier > 0) {
            val digit = uniqueIdentifier % 10
            uniqueIdentifier /= 10
            shortUrl.append(base62Chars.get(digit))
        }
        return shortUrl.reverse().toString()
    }
}