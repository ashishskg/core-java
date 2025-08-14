package section23.behaviral.mediator;

import javafx.scene.control.TextField;

import javax.swing.event.ChangeListener;

public class TextBox extends TextField implements UIControl{

	private UIMediator mediator;

	private boolean mediatedUdpdate;
	public TextBox(UIMediator mediator) {
		this.mediator = mediator;
		this.setText("Textbox");
		this.mediator.register(this);

		this.textProperty().addListener((v, o, n) -> {
			this.mediator.valueChanged(this);
		});
	}

	@Override
	public void controlChanged(UIControl control) {
		this.mediatedUdpdate = true;
		this.setText(control.getControlValue());
		this.mediatedUdpdate = false;
	}

	@Override
	public String getControlValue() {
		return getText();
	}

	@Override
	public String getControlName() {
		return "Textbox";
	}
}
