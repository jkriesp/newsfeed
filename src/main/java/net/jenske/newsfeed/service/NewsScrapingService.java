package net.jenske.newsfeed.service;

import net.jenske.newsfeed.model.NewsArticle;
import net.jenske.newsfeed.repository.NewsArticleRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsScrapingService {

    @Autowired
    private NewsArticleRepository newsArticleRepository;

    public List<NewsArticle> scrapeNewsSite(String url, String headlineSelector, String contentSelector) {
        List<NewsArticle> scrapedArticles = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements headlines = doc.select(headlineSelector);

            for (Element headline : headlines) {
                NewsArticle article = new NewsArticle();
                article.setTitle(headline.text());

//                Element content = headline.select(contentSelector).first();
//                if (content != null) {
//                    article.setContent(content.text());
//                }

                // Todo: Add source and publication date
                System.out.println(article.getTitle());
                scrapedArticles.add(article);
                newsArticleRepository.save(article);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO Handle exception properly
        }

        return scrapedArticles;
    }
}