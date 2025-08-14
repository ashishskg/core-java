package section20.behaviral.chainofresponsibility;

import java.time.LocalDate;

public class Client {

	public static void main(String[] args) {
	   LeaveApplication application = LeaveApplication.getBuilder().withType(LeaveApplication.Type.Sick)
			   .from(LocalDate.now()).to(LocalDate.of(2023, 6, 28))
			   .build();

	   LeaveApprover approver = createChain();
	   approver.processLeaveApplication(application);
		System.out.println(application);
	}

	private static LeaveApprover createChain() {
		Director director = new Director(null);
		Manager manager = new Manager(director);
		ProjectLead lead = new ProjectLead(manager);

		return lead;
	}

	
}
