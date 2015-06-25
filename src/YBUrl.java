public class YBUrl {
	private String title;
	private String DUrl;
	private String source;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDUrl() {
		return DUrl;
	}

	public void setDUrl(String dUrl) {
		DUrl = dUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "YBUrl [title=" + title + ", DUrl=" + DUrl + "]";
	}

}
