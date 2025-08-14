package lambdasinaction.chap3;

import java.io.*;
public class ExecuteAround {

	public static void main(String ...args) throws IOException{
		String result = "";
        // method we want to refactor to make more flexible
		try {
			result = processFileLimited();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        System.out.println(result);

        System.out.println("---");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);

	}

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("src/lambdasinaction/chap3/data.txt"))) {
            return br.readLine();
        }
        
    }


	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("src/lambdasinaction/chap3/data.txt"))){
			return p.process(br);
		}

	}

	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;

	}
}
