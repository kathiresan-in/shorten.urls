package com.dkb.url.shorten.service

import com.dkb.url.shorten.model.ShortUrl
import com.dkb.url.shorten.model.ShortUrlRequest
import java.util.Optional

interface UrlShorteningService {
    fun generateShortUrl(shortUrlRequest: ShortUrlRequest) : Optional<ShortUrl>
    fun resolveOriginalUrlById(identifier: String) : Optional<ShortUrl>
}