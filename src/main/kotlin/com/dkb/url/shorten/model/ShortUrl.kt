package com.dkb.url.shorten.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "SHORT_URL")
data class ShortUrl(
    @Id
    var short_url: String,
    var original_url: String,
    var creation_datetime: String
)
