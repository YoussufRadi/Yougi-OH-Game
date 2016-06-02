package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HandPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<HandButton> hands;
	private MainWindow gui;

	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}
	public ArrayList<HandButton> getHands() {
		return hands;
	}

	public void setHands(ArrayList<HandButton> hands) {
		this.hands = hands;
	}

	public HandPanel(MainWindow gui) {
		super();
		this.gui = gui;
		hands = new ArrayList<HandButton>();
		this.setLayout(new GridLayout(1, 7));
		this.setBorder(null);
		this.setOpaque(false);
		this.validate();
	}

	public void addToPanel(HandButton hand) {
		this.add(hand);
		hands.add(hand);
		this.validate();
	}
	
	public void removeFromPanel(HandButton hand)
	{
		this.remove(hand);
		hands.remove(hand);
		this.validate();
	}

}
