package section05.creational.simple_factory;

public class Client {

	public static void main(String[] args) {


		Post post = PostFactory.createPost("blog");
		System.out.println(post);

		post = PostFactory.createPost("news");
		System.out.println(post);

	}

}
