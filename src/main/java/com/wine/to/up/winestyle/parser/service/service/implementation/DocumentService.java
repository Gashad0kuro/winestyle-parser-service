package com.wine.to.up.winestyle.parser.service.service.implementation;

import com.wine.to.up.winestyle.parser.service.service.IDocumentService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

/**
 * 
 * Класс, который парсит страницы сайта. Скачивает html и возвращает Document.
 */
@Service
@Slf4j
public class DocumentService implements IDocumentService {
    public Document getJsoupDocument(String url) throws InterruptedException {
        Document doc = null;

        log.info("parsing url: {}", url);

        while (doc == null) {
            try {
                doc = Jsoup
                        .connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36")
                        .get(); // Берем страничку html

            } catch (Exception ex) {
                log.error("Couldn't get a connection to website! ", ex);
            } // Берем страничку html
        }
        Thread.sleep(650);
        return doc;
    }

    /**
     * @return количество страниц с вином
     */
    public Integer pagesNumber(Document doc) {
        Element pagingElement = doc.getElementById("CatalogPagingBottom");
        String pagesNumber = pagingElement.getElementsByTag("li").last().text();
        return Integer.parseInt(pagesNumber);
    }
}
