package CrawlerService.crawlers;

import org.openqa.selenium.WebDriver;

public class CrawlerFactory {
	// Possible supported image sites to crawl for image files
	public enum ImageSources {
		IMGUR, REDDIT, FLICKR, GOOGLE, NINE_GAG
	}

	public static Crawler create(WebDriver driver, ImageSources source) {

		switch (source) {
		case IMGUR:
			return new ImgurCrawler(driver);
		case NINE_GAG:
			return new NineGagCrawler(driver);
		case GOOGLE:
			return null;
		case REDDIT:
			return null;
		case FLICKR:
			return null;
		}

		return null;
	}
}
