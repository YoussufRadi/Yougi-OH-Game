package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Player;

public class OpponentSidePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	OpponentInfoPanel opponentInfo;
	OppnentSide opponentSide;
	
	public OpponentInfoPanel getOpponentInfo() {
		return opponentInfo;
	}


	public void setOpponentInfo(OpponentInfoPanel opponentInfo) {
		this.opponentInfo = opponentInfo;
	}


	public OppnentSide getOpponentSide() {
		return opponentSide;
	}


	public void setOpponentSide(OppnentSide opponentSide) {
		this.opponentSide = opponentSide;
	}


	public OpponentSidePanel(Player x) {
		super();
		this.setBounds(1100, 5, 300, 330);
		opponentSide = new OppnentSide(x);
		opponentInfo = new OpponentInfoPanel(x);
		this.setLayout(new GridLayout(1,2));
		this.add(opponentSide);
		this.add(opponentInfo);
		this.setBorder(null);
		this.setOpaque(false);
		this.validate();
	}
}
