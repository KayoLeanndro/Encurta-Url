package com.greensalad.url_shortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greensalad.url_shortner.model.Url;
import com.greensalad.url_shortner.service.UrlService;

@Controller
public class HomeController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("url", new Url());
        return "index";
    }

    @PostMapping("home/url/shortner")
    public String generateShortUrl(@RequestParam String url, Model model) {

        Url shortUrl = urlService.generateShortUrl(url);

        if (shortUrl == null) {
            model.addAttribute("erro", "Url invalida");
            return "error";
        }

        model.addAttribute("shortUrl", shortUrl.getShorturl());
        return "shortUrl";

    }

}
