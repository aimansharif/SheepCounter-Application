
public class Model {
	private View view;
	private int counter;
	private int max;
	
	public Model(int counter, int max, View view) {
		this.counter = counter;
		this.max = max;
		this.view = view;
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public void setCountInit() {
		this.counter = view.getInitialNumber();
	}
	
	public void increment() {
		
		counter++;
		
		if(counter == max) {
			setCompleteText();
		}
		
		else if (counter < this.getMax()) {
			setIncompleteText();
		}

		else if (counter > this.getMax()) {
			setTextInconsistent();
		}

		updateView();
	}

	public void decrement() {
		if (counter > 0) {
			counter--;
		}
		
		if(counter == max) {
			setCompleteText();
		}
		
		else if (counter < this.getMax()) {
			setIncompleteText();
		}

		else if (counter > this.getMax()) {
			setTextInconsistent();
		}
		
		updateView();
	}

	public int getMax() {
		return this.max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public void updateView() {
		view.setView();
	}
	
	public void setIncompleteText() {
		view.incomplete();
	}
	
	public void setCompleteText() {
		view.complete();
	}
	
	public void setTextInconsistent() {
		view.inconsistent();
	}
}
