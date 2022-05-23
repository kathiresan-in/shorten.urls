package com.dkb.url.shorten.service.impl

import com.dkb.url.shorten.model.ShortUrl
import com.dkb.url.shorten.model.ShortUrlRequest
import com.dkb.url.shorten.repository.ShortUrlRepository
import com.dkb.url.shorten.service.UrlShorteningService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.Optional

@Service
class UrlShorteningServiceImpl (
    private val shortUrlRepository: ShortUrlRepository,
    private val base62UniqueIdGenerator: Base62UniqueIdGenerator
) : UrlShorteningService {

    override fun generateShortUrl(shortUrlRequest: ShortUrlRequest): Optional<ShortUrl> {
        var identifier : String = ""
        do {
            identifier = base62UniqueIdGenerator.generateShortUrlByRandomNumber();
            val shortUrlOp : Optional<ShortUrl> = shortUrlRepository.findById(identifier)
        } while (shortUrlOp.isPresent)
        val shortUrl : ShortUrl = ShortUrl(identifier, shortUrlRequest.original_url, LocalDateTime.now().toString())
        shortUrlRepository.save(shortUrl)
        return Optional.ofNullable(shortUrl)
    }

    override fun resolveOriginalUrlById(identifier: String): Optional<ShortUrl> {
        return shortUrlRepository.findById(identifier)
    }
}