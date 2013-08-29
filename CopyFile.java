import java.io.*;
import java.util.Scanner;

public class CopyFile {
	private static Scanner scanner;
	private static FileInputStream fis;
	private static FileOutputStream fos;

	public static void main(String[] args) throws IOException {
		scanner = new Scanner(System.in);
		System.out.println("복사 할 파일경로 입력");
		String inputRoute = scanner.next();
		System.out.println("복사 한 파일을 위치시키고 싶은 경로 입력");
		String outputRoute = scanner.next();
		
		File inputFile = new File(inputRoute);
		if (inputFile.isDirectory()) {
			System.out.println("디렉토리는 복사 할 수 없습니다.");
			System.exit(0);
		}
		File outputFile = new File(outputRoute);
		fis = new FileInputStream(inputFile);
		fos = new FileOutputStream(outputFile);
		
		int data = fis.read();
		while (data != -1) {
			fos.write(data);
			data = fis.read();
		}
		fis.close();
		fos.close();
		}
}
