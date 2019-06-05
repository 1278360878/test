package vip.lijunlin.test.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import vip.lijunlin.test.lambda.inter.BufferedReaderProcessor;

public class MyLambdaTest {

	public static void main(String[] args) throws Exception {
//		Runnable r1 = () -> System.out.println("lambda 新建对象");
//		new Thread(r1).start();

		System.out.println(processFile());
		System.out.println(processFile((BufferedReader br) -> br.readLine() + br.readLine()));
	}

	public static String processFile() throws IOException {
		try (BufferedReader br = new BufferedReader(
				new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\" + "data.txt"))) {
			return br.readLine();
		}
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(
				new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\" + "data.txt"))) {
			return p.process(br);
		}
	}
}
