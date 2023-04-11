package com.example.blogit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class BlogitApplication
{
	@GetMapping("a")
	fun helloWorld() = "Hello blogit"
}

fun main(args: Array<String>) {
	runApplication<BlogitApplication>(*args)
}
