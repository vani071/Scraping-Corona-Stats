package com.teknosob.scrapingcorona.service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.teknosob.scrapingcorona.response.CoronaStatResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ScrapingService {
    private final Logger log=LoggerFactory.getLogger(this.getClass());

    @Value("${scraping.url.source}")
    private String urlSource;

    public CoronaStatResponse getScrapingData(){

        CoronaStatResponse result = new CoronaStatResponse();
        try(WebClient webClient = new WebClient();){
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);

            HtmlPage page = webClient.getPage(urlSource);

            Document doc = Jsoup.parse(page.asXml());

            log.debug("parsing data from html");
            Elements sections = doc.select("div.fusion-text");
            Element sectionMain = sections.get(2);
            Elements dataStat = sectionMain.select("div strong");

            if(!dataStat.isEmpty()){
                result.setConfirmed(dataStat.get(0).text());
                result.setRecovered(dataStat.get(1).text());
                result.setDeaths(dataStat.get(2).text());
            }
        }catch (Exception e ){
            log.error("Can't get data from URL");
        }

        return result;
    }
}
