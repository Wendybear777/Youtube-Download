import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.Proxy.Type;
import java.nio.CharBuffer;
import java.util.Scanner;

import org.apache.bcel.generic.DDIV;
import org.apache.commons.io.IOUtils;

public class MainClass {
	public static void main(String[] args) throws Exception {
		DownloadManager downloader = new DownloadManager();
		// try {
		// // FileInputStream ins = new FileInputStream(args[0]);
		// // Scanner scanner = new Scanner(ins);
		// // while (scanner.hasNextLine()) {
		// // String sourceURL = scanner.nextLine();
		// // downloader.addTask(sourceURL);
		// // }
		downloader
				.addTask("https://www.youtube.com/watch?v=YvCRlJToCAg&list=PL0C9C46CAAB1CFB2B&index=1");
		downloader
				.addTask("https://www.youtube.com/watch?v=-0a9mDWqrt0&list=PL0C9C46CAAB1CFB2B&index=2");
		downloader.startDownload();
		// // scanner.close();
		// } catch (ArrayIndexOutOfBoundsException e) {
		// Log("where is the list file ?");
		// }

	}

	private static void Log(String con) {
		System.out.println(con);
	}

}
