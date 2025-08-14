package section21.behaviral.command;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		EWSService service = new EWSService();

		Command c1 = new AddMemberCommand("a@b.com", "inbox", service);

		MailTasksRunner.getInstance().addCommand(c1);

		Command c2 = new AddMemberCommand("b@c.com", "inbox 2", service);
		MailTasksRunner.getInstance().addCommand(c2);

		Thread.sleep(3000);
		MailTasksRunner.getInstance().shutdown();
	}

}
