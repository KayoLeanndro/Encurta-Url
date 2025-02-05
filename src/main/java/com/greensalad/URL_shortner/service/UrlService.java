package com.greensalad.url_shortner.service;

import com.greensalad.url_shortner.model.Url;
import com.greensalad.url_shortner.repository.UrlRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String shortenUrl(String originalUrl) {

        if (!isValidUrl(originalUrl)) {
            throw new RuntimeErrorException(null, "URL is not valid");
        }

        String shortCode = generateShortCode();
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);
        urlRepository.save(url);
        return shortCode;
    }

    private String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 6); // Código curto de 6 caracteres
    }

    public String getOriginalUrl(String shortCode) {
        return urlRepository.findByShortCode(shortCode)
                .map(Url::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL não encontrada"));
    }

    public boolean isValidUrl(String url) {
        if (url.startsWith("http") || url.startsWith("https")) {
            return true;
        }
        return false;
    }

    public Optional<Url> findByShortCode(String code) {
        return urlRepository.findByShortCode(code);
    }

    public List<Url> findAllUrls() {
        return urlRepository.findAllUrls();
    }

}