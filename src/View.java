import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class View extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private Model counter;
	private Controller controller;
	private JTextField numberField;
	private JLabel status;
	private JButton increment;
	private JButton decrement;
	private JPanel panel;
	private int totalNumber;
	private JButton setLimitButton;
	private JTextField numberEntered;
	private JTextField initialNumberField;
	private int initialNumber;
	
	public View(){
		super("Counter Application");
		counter = new Model(initialNumber, totalNumber, this);
		controller = new Controller(counter, this);
		increment = new JButton("Increment");
		decrement = new JButton("Decrement");
		setLimitButton = new JButton("Set Limit");
		numberField = new JTextField();
		numberEntered = new JTextField();
		initialNumberField = new JTextField();
		status = new JLabel("Incomplete");
		panel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		numberField.setText(counter.getCounter() + "");
		panel.setLayout(new GridLayout(4, 2));
		status.setForeground(Color.RED);
			
		increment.setPreferredSize(new Dimension(200, 100));
		decrement.setPreferredSize(new Dimension(200, 100));
		setLimitButton.setPreferredSize(new Dimension(200, 100));
		
		panel.add(increment);
		panel.add(numberField);
		panel.add(decrement);
		panel.add(setLimitButton);
		panel.add(status);
		panel.add(numberEntered);
		panel.add(initialNumberField);
		
		increment.addActionListener(controller);
		decrement.addActionListener(controller);
		setLimitButton.addActionListener(controller);
		
		this.setSize(800, 800);
		this.add(panel);
		this.setVisible(true);
	}
	
	public void setView() {
		numberField.setText(counter.getCounter() + "");
	}
	
	public void incomplete() {
		status.setText("Incomplete");
		status.setForeground(Color.RED);
	}
	
	public void complete() {
		status.setText("Complete");
		status.setForeground(Color.GREEN);
	}
	
	public void inconsistent() {
		status.setText("Inconsistent");
		status.setForeground(Color.yellow);
	}
	
	public int getNumberEntered() {
		String numberInput = numberEntered.getText();
		int number = Integer.parseInt(numberInput);
		
		return number;
	}
	
	public int getInitialNumber() {
		String initialNumber = initialNumberField.getText();
		int initNumber = Integer.parseInt(initialNumber);
		
		return initNumber;
	}

	public static void main(String args[]) {
		View view = new View();
	}
}
