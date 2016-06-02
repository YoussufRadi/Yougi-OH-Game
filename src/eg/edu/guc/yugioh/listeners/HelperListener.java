package eg.edu.guc.yugioh.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import eg.edu.guc.yugioh.gui.MainWindow;

public abstract class HelperListener implements MouseListener {

	abstract public void mouseClicked(MouseEvent e);
	private MainWindow gui;

	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}
	
	public HelperListener(MainWindow gui) {
		this.gui = gui;
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {
	
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
