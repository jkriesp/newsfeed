package net.jenske.newsfeed;

import net.jenske.newsfeed.service.NewsScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewsfeedApplication {

	@Autowired
	NewsScrapingService newsScrapingService;
	public static void main(String[] args) {
		SpringApplication.run(NewsfeedApplication.class, args);
	}

	@Bean
	public CommandLineRunner testScraping() {
		return args -> {
			String url = "https://www.adressa.no";
			String headlineSelector = "h3 > span";
			String contentSelector = "";

			newsScrapingService.scrapeNewsSite(url, headlineSelector, contentSelector);
			System.out.println("Scraping done");
		};
	}

}
