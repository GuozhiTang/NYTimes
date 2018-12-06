package searcher;

import java.lang.reflect.Constructor;
import java.util.Set;

public class Article {
	private String url;
	private String headline;
	private String snippet;

	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public Article(String url, String headline, String snippet) {
		super();
		this.url = url;
		this.headline = headline;
		this.snippet = snippet;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	
}
