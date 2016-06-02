package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class OpponentInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel LP;
	private JLabel namex;
	private JLabel phase;

	public JLabel getNamex() {
		return namex;
	}

	public void setName(String name) {
		this.namex.setText("    "+name);
	}

	public JLabel getPhase() {
		return phase;
	}

	Player x;
	public void setPhase(Player phaase) {
		if (phaase != Card.getBoard().getActivePlayer())
			phase.setText("    "+"Not your turn");
		else
			phase.setText("    "+phaase.getField().getPhase());
	}

	public JLabel getLP() {
		return LP;
	}

	public void setLP(int pLP) {
		LP.setText("    "+"LP : " + pLP);
	}
	
	public OpponentInfoPanel(Player x) {
		super();
		this.x = x;
		String name1 = x.getName();
		int pLP = x.getLifePoints();
		String phase1;
		if (x != Card.getBoard().getActivePlayer())
			phase1 = "    "+"Not your turn";
		else
			phase1 = "    "+x.getField().getPhase() + "";
		this.setLayout(new GridLayout(3, 1));
		namex = new JLabel("    "+name1);
		LP = new JLabel("    "+"LP : " + pLP);
		phase = new JLabel(phase1);
		namex.setForeground(Color.WHITE);
		LP.setForeground(Color.WHITE);
		phase.setForeground(Color.WHITE);
		this.add(phase);
		this.add(LP);
		this.add(namex);
		namex.setBorder(null);
		namex.setOpaque(false);
		LP.setBorder(null);
		LP.setOpaque(false);
		phase.setBorder(null);
		phase.setOpaque(false);
		this.setBorder(null);
		this.setOpaque(false);
		this.validate();
	}

}
