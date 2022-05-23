package com.dkb.url.shorten.service

import com.dkb.url.shorten.model.ShortUrl
import com.dkb.url.shorten.model.ShortUrlRequest

interface UrlShorteningService {
    fun generateShortUrl(shortUrlRequest: ShortUrlRequest) : ShortUrl
    fun resolveOriginalUrlById(identifier: String) : ShortUrl
}