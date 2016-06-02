package eg.edu.guc.yugioh.gui;


import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.listeners.EndPhaseListener;
import eg.edu.guc.yugioh.listeners.EndTurnListener;

public class HelperPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton turn;
	private JButton phase;
	private MainWindow gui;
	
	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}

	public JButton getTurn() {
		return turn;
	}

	public void setTurn(JButton turn) {
		this.turn = turn;
	}

	public JButton getPhase() {
		return phase;
	}

	public void setPhase(JButton phase) {
		this.phase = phase;
	}

	public HelperPanel(MainWindow gui) {
		super();
		this.gui = gui;
		turn = new JButton(new ImageIcon("End_Turn.png"));
		turn.addMouseListener(new EndTurnListener(getGui()));
		phase = new JButton(new ImageIcon("End_Phase.png"));
		phase.addMouseListener(new EndPhaseListener(getGui()));
		turn.setBorder(null);
		turn.setContentAreaFilled(false);
		turn.setBorderPainted(false);
		turn.setOpaque(false);
		phase.setBorder(null);
		phase.setContentAreaFilled(false);
		this.setBorder(null);
		this.setOpaque(false);
		setLayout(new GridLayout(2,1));
		add(turn);
		add(phase);
		this.validate();
	}


}
