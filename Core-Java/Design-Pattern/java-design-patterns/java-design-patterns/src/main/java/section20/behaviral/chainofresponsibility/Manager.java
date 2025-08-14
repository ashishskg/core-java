package section20.behaviral.chainofresponsibility;
//A concrete handler

public class Manager extends Employee {

	public Manager(LeaveApprover nextApprover) {
		super("Manager", nextApprover);
	}

	@Override
	protected boolean processRequest(LeaveApplication application) {
		String approvalRole = getApprovalRole();
		switch (application.getType()) {
		case Sick:
			application.approve(approvalRole);
			return true;
		case PTO:
			if(application.getNoOfDays() <= 5) {
				application.approve(approvalRole);
				return true;
			}
		}
		return false;
	}

}