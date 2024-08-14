package pkg.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlData {

	@Column(name = "full_url", length = 512)  // Increase the length as needed
	private String FullUrl;
	@Id
	private String ShortUrl;
	
	public String getFullUrl() {
		return FullUrl;
	}
	public void setFullUrl(String fullUrl) {
		FullUrl = fullUrl;
	}
	public String getShortUrl() {
		return ShortUrl;
	}
	public void setShortUrl(String shortUrl) {
		ShortUrl = shortUrl;
	}
	@Override
	public String toString() {
		return "UrlData [FullUrl=" + FullUrl + ", ShortUrl=" + ShortUrl + "]";
	}
}
