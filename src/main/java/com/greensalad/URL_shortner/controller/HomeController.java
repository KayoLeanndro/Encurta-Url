package com.greensalad.url_shortner.controller;

import java.util.List;
import java.util.Optional;

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
    public String index() {
        return "index"; // Retorna a página principal
    }

    @PostMapping("/url/shortner")
    public String shortenUrl(@RequestParam String url, Model model) {
        // Gera o código curto e armazena a URL original
        String shortCode = urlService.shortenUrl(url);

        // Monta a URL encurtada com o endpoint de redirecionamento
        String shortUrl = "http://localhost:8085/url/shortner/" + shortCode;

        // Adiciona a URL encurtada ao modelo
        model.addAttribute("shortUrl", shortUrl);

        // Retorna a página principal com a URL encurtada
        return "index";
    }

    @GetMapping("/findAllUrls")
    public String findAllUrls(Model model) {
        List<Url> urls = urlService.findAllUrls();
        urls.forEach(url -> System.out.println("Original: " + url.getOriginalUrl() + ", Short: " + url.getShortCode()));
        model.addAttribute("urls", urls);
        return "all_url";
    }

}
