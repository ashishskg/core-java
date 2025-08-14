package section20.behaviral.chainofresponsibility;

//A concrete handler
public class Director extends Employee {


	public Director(LeaveApprover nextApprover) {
		super("Director", nextApprover);
	}
	
	@Override
	protected boolean processRequest(LeaveApplication application) {
		if(application.getType() == LeaveApplication.Type.PTO) {
			String approvalRole = getApprovalRole();
			application.approve(approvalRole);
			return true;
		}
		return false;
	}
	
}
