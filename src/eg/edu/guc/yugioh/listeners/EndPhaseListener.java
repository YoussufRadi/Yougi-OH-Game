package eg.edu.guc.yugioh.listeners;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.gui.MainWindow;

public class EndPhaseListener extends HelperListener  {

	public EndPhaseListener(MainWindow gui) {
		super(gui);
	}
	
	public void mouseClicked(MouseEvent e) {
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Are You Sure You Want To End Phase?",
			    "Check",
			    JOptionPane.YES_NO_OPTION);
		if (n==1) return;
		Card.getBoard().getActivePlayer().endPhase();
		MainWindow.refresh(getGui());
	}
}
