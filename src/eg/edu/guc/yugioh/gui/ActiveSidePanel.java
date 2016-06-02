package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Player;

public class ActiveSidePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActiveInfoPanel activeInfo;
	private ActiveSide activeSide;
	
	public ActiveInfoPanel getActiveInfo() {
		return activeInfo;
	}


	public void setActiveInfo(ActiveInfoPanel activeInfo) {
		this.activeInfo = activeInfo;
	}


	public ActiveSide getActiveSide() {
		return activeSide;
	}


	public void setActiveSide(ActiveSide activeSide) {
		this.activeSide = activeSide;
	}


	public ActiveSidePanel(Player x) {
		super();
		this.setBounds(1100, 370, 300, 330);
		activeInfo = new ActiveInfoPanel(x);
		activeSide = new ActiveSide(x);
		this.setLayout(new GridLayout(1,2));
		this.add(activeSide);
		this.add(activeInfo);
		this.setBorder(null);
		this.setOpaque(false);
		this.validate();
	}

}
