package eg.edu.guc.yugioh.listeners;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.gui.MainWindow;

public class EndTurnListener extends HelperListener {

	public EndTurnListener(MainWindow gui) {
		super(gui);
	}
	
	public void mouseClicked(MouseEvent e) {
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Are You Sure You Want To End Turn?",
			    "Check",
			    JOptionPane.YES_NO_OPTION);
		if (n==1) return;
		Card.getBoard().getActivePlayer().endTurn();
		MainWindow.refresh(getGui());
	}
}
