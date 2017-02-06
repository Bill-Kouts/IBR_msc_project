package CrawlerService.crawlers;

import org.openqa.selenium.WebDriver;
import ij.ImagePlus;

public abstract class Crawler {
	protected final WebDriver driver;

	public Crawler(WebDriver driver) {
		this.driver = driver;
	}

	public Crawler() {
		this.driver = null;
	}

	// Initialize source specific crawler
	public abstract void initialize();

	// Fetch next image from source
	public abstract ImagePlus fetchNext();

	// Deinitialize source specific crawler
	public abstract void deinitialize();

	// Return images path
	public abstract String getStoragePath();
}
