package eg.edu.guc.yugioh.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.gui.MainWindow;
import eg.edu.guc.yugioh.gui.Window1;

public class StartListener implements MouseListener {
	private Window1 x;

	public StartListener(Window1 x) {
		this.x = x;
	}

	public void mouseClicked(MouseEvent e) {
		Board board = new Board();
		try {
			if(x.getJt().getText().equals("")) x.getJt().setText("Player 1");
			if(x.getJt2().getText().equals("")) x.getJt2().setText("Player 2");
			Player p1 = new Player(x.getJt().getText());
			Player p2 = new Player(x.getJt2().getText());
			board.startGame(p1, p2);
			new MainWindow(board);
			x.setVisible(false);
		}
		catch (UnexpectedFormatException e1) {
			JOptionPane.showMessageDialog(null,
					e1.getMessage(),
					"Game Cannot Start", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		catch (IOException e1) {
			JOptionPane.showMessageDialog(null,
					"The csv file you entered is not Found",
					"Game Cannot Start", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		

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
