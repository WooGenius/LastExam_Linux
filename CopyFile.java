import java.io.*;
import java.util.Scanner;

public class CopyFile {
	private static Scanner scanner;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static BufferedInputStream bis;
	private static BufferedOutputStream bos;

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
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream(outputFile);
		bos = new BufferedOutputStream(fos);
		
		int data = bis.read();
		while (data != -1) {
			bos.write(data);
			data = bis.read();
		}
		bos.close();
		bis.close();
		fis.close();
		fos.close();
		}
}
