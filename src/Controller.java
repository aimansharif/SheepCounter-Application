import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Increment")) {
			model.increment();
		}
		
		if(e.getActionCommand().equals("Decrement")) {
			model.decrement();
		}
		
		if(e.getActionCommand().equals("Set Limit")) {
			model.setCountInit();
			model.setMax(view.getNumberEntered());
		}
	}
}
