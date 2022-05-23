package com.dkb.url.shorten.controller

import com.dkb.url.shorten.model.ShortUrl
import com.dkb.url.shorten.model.ShortUrlRequest
import com.dkb.url.shorten.service.UrlShorteningService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/dbk/api")
class UrlShorteningController(
    private val urlShorteningService: UrlShorteningService
) {
    @PostMapping("/urlshortening")
    fun generateShortUrl(@RequestBody shortUrlRequest: ShortUrlRequest) : ResponseEntity<ShortUrl> {
        val shortUrl : Optional<ShortUrl> = urlShorteningService.generateShortUrl(shortUrlRequest)
        if(shortUrl.isPresent) {
            return ResponseEntity<ShortUrl>(shortUrl.get(), HttpStatus.CREATED)
        }
        return ResponseEntity<ShortUrl>(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @GetMapping("/urlshortening/{identifier}")
    fun resolveOriginalUrlById(@PathVariable identifier: String) : ResponseEntity<ShortUrl> {
        val shortUrl : Optional<ShortUrl> = urlShorteningService.resolveOriginalUrlById(identifier)
        if(shortUrl.isPresent) {
            return ResponseEntity<ShortUrl>(shortUrl.get(), HttpStatus.OK)
        }
        return ResponseEntity<ShortUrl>(HttpStatus.NOT_FOUND)
    }
}