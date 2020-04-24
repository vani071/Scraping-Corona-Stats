package com.teknosob.scrapingcorona.controller;

import com.teknosob.scrapingcorona.response.CoronaStatResponse;
import com.teknosob.scrapingcorona.service.ScrapingService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
@RequestMapping("/scrp")
public class ScrapingController {

    @Autowired
    ScrapingService scrapingService;

    @GetMapping("/corona")
    public CoronaStatResponse getCoronaData() throws IOException {
        return scrapingService.getScrapingData();
    }
}
