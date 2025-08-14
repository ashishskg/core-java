package section25.behaviral.memento.com.coffeepoweredcrew.memento.command;

import section25.behaviral.memento.com.coffeepoweredcrew.memento.WorkflowDesigner;

public abstract class AbstractWorkflowCommand implements WorkflowCommand {

    protected WorkflowDesigner.Memento memento;

    protected WorkflowDesigner receiver;

    public AbstractWorkflowCommand(WorkflowDesigner designer) {
        this.receiver = designer;
    }

    @Override
    public void undo() {
        receiver.setMemento(memento);
    }
}
