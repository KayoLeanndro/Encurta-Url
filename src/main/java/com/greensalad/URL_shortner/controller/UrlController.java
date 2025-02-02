package com.greensalad.url_shortner.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.greensalad.url_shortner.model.Url;
import com.greensalad.url_shortner.service.UrlService;

@RestController
@RequestMapping("url/shortner")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String originalUrl) {
        String shortUrl = urlService.shortenUrl(originalUrl);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortCode)
            throws IOException {
        Optional<Url> url = urlService.findByShortCode(shortCode);
        if (url.isPresent()) {
            return ResponseEntity.status(302)// Codigo de redirecionamento
                    .location(URI.create(url.get().getOriginalurl()))
                    .build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
