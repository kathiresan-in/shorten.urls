package com.dkb.url.shorten.service.impl

import com.dkb.url.shorten.model.ShortUrl
import com.dkb.url.shorten.model.ShortUrlRequest
import com.dkb.url.shorten.service.UrlShorteningService

class UrlShorteningServiceImpl : UrlShorteningService {

    override fun generateShortUrl(shortUrlRequest: ShortUrlRequest): ShortUrl {
        TODO("Not yet implemented")
    }

    override fun resolveOriginalUrlById(identifier: String): ShortUrl {
        TODO("Not yet implemented")
    }
}