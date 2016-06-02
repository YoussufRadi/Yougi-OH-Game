package eg.edu.guc.yugioh.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import eg.edu.guc.yugioh.gui.Window1;
import eg.edu.guc.yugioh.gui.Winner;

public class StartAgainListener implements MouseListener{
	 
	Winner x;
	public StartAgainListener(Winner x){
		this.x=x;
	}
	public void mouseClicked(MouseEvent e) {
		new Window1();
		x.setVisible(false);
	}

	public void mousePressed(MouseEvent e) {
	
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
	
}
