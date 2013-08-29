import java.io.*;
import java.util.Scanner;


public class PrintRoute {
	private static Scanner scanner;
	
	public static void main(String[] args) throws IOException {
		scanner = new Scanner(System.in);
		System.out.println("경로 입력");
		String route = scanner.next();
		System.out.println("파일이름 입력");
		String fileName = scanner.next();
		
		String fileRoute = route + fileName;
		File file = new File(fileRoute);
		if (file.isFile()) {
			System.out.println("파일이 존재합니다.");
			System.out.println(file.getAbsolutePath());
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}
}
