package interview_graph;

public class Demo {
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++)	{
				System.out.print(i * j + "    ");
			}
			Thread.sleep(1000);
			System.out.println();
		}
	}

}
