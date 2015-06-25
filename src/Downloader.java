import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Downloader {

	private List<String> sourceList;

	public Downloader() {
		sourceList = new ArrayList<String>();
	}

	public void addTask(String source) {
		sourceList.add(source);
	}

	public void startDownload() {
		System.out.print("Becoming....");
		for (int i = 0; i < sourceList.size(); i++) {
			TaskThread taskThread = new TaskThread(sourceList.get(i));
			taskThread.start();
		}
	}

	class TaskThread extends Thread {
		String url;

		public TaskThread(String yb) {
			// TODO Auto-generated constructor stub
			url = yb;
		}

		@Override
		public void run() {
			Download(url);
		}
	}

	public YBUrl getYTBAddress(String utbUrl) {
		PhantomJSDriver phantom = new PhantomJSDriver();
		try {
			String url = "http://www.clipconverter.cc";
			phantom.get(url);
			phantom.findElementById("mediaurl").sendKeys(
					new String[] { utbUrl });
			phantom.findElementById("submiturl").click();
			YBUrl ybUrl = new YBUrl();
			boolean isOK = false;
			while (!isOK) {
				try {
					WebElement el = phantom.findElementById("0");
					ybUrl.setDUrl(el.getAttribute("value"));
					WebElement el1 = phantom.findElementById("filename");
					WebElement el2 = phantom.findElementById("filetype");
					ybUrl.setTitle(el1.getAttribute("value") + "."
							+ el2.getAttribute("value"));
					return ybUrl;
				} catch (Exception e) {
					isOK = false;
				}
			}
		} catch (Exception e) {
			phantom.close();
		}
		return null;
	}

	public void Download(String url) {
		YBUrl yb = getYTBAddress(url);
		if (yb != null) {
			System.out.println(yb);
			try {
				String command = "wget \"" + yb.getDUrl() + "\" -O "
						+ yb.getTitle();
				Process p = Runtime.getRuntime().exec(command);
			} catch (IOException e) {
				System.out.println("Error URL:" + e.getMessage());
			}
		} else {
			System.out.println("Error URL:" + url);
		}
	}
}
