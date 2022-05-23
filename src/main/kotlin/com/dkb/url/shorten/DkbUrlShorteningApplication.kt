package com.dkb.url.shorten

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DkbUrlShortenerApplication

fun main(args: Array<String>) {
	runApplication<DkbUrlShortenerApplication>(*args)
}
