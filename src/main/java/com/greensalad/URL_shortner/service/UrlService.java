package com.greensalad.url_shortner.service;

import com.google.common.hash.Hashing;
import com.greensalad.url_shortner.model.Url;
import com.greensalad.url_shortner.repository.UrlRepository;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String getOriginlUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public static String getShortUrl(String url) {
        String shortUrl = Hashing.murmur3_32_fixed()
                .hashString(url, StandardCharsets.UTF_8)
                .toString();
        return shortUrl;
    }

    public static boolean isUrlValid(String url) {
        UrlValidator urlValidator = new UrlValidator(
                new String[] { "http", "https" });
        boolean result = urlValidator.isValid(url);
        return result;
    }

    public Url generateShortUrl(String url) {
        if (!isUrlValid(url)) {
            System.out.println("URL is not valid");
            return null;
        }

        Url urlObject = new Url();
        urlObject.setOriginalurl(url);
        urlObject.setShorturl(getShortUrl(url));

        return urlRepository.save(urlObject);
    }

}
