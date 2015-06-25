import java.net.*;
import java.net.Proxy.Type;
import java.io.*;

public class Downloader {

	public Downloader() {

	}

	public void Download(String url, String filename) {
		try {
			saveUrl(filename, url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void saveUrl(String filename, String urlString)
			throws MalformedURLException, IOException {
		BufferedInputStream in = null;
		FileOutputStream fout = null;
		URL url = new URL(urlString);
		try {
			System.setProperty("java.net.useSystemProxies", "true");
			SocketAddress sa = new InetSocketAddress("127.0.0.1", 7070);
			Proxy proxy = new Proxy(Type.SOCKS, sa);
			URLConnection connection = url.openConnection(proxy);
			in = new BufferedInputStream(connection.getInputStream());
			fout = new FileOutputStream(filename);
			int size = in.available() / (1024 * 1024);
			System.out.println(filename + "-----size:" + size);
			final byte data[] = new byte[1024];
			int count;
			while ((count = in.read(data, 0, 1024)) != -1) {
				fout.write(data, 0, count);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (fout != null) {
				fout.close();
			}
		}
	}
}
