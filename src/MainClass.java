import java.io.FileInputStream;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) throws Exception {
		Downloader downloader = new Downloader();
		try {
			FileInputStream ins = new FileInputStream(args[0]);
			Scanner scanner = new Scanner(ins);
			while (scanner.hasNextLine()) {
				String sourceURL = scanner.nextLine();
				downloader.addTask(sourceURL);
			}
			downloader.startDownload();
			scanner.close();
		} catch (ArrayIndexOutOfBoundsException e) {
			print("where is the list file ?");
		}
	}

	public static void print(String con) {
		System.out.println(con);
	}

	public void prints(String con) {
		System.out.println(con);
	}

}
