package com.dkb.url.shorten.repository

import com.dkb.url.shorten.model.ShortUrl
import org.springframework.data.jpa.repository.JpaRepository

interface ShortUrlRepository : JpaRepository<ShortUrl, String> {
}