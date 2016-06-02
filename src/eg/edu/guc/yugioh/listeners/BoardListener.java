package eg.edu.guc.yugioh.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.gui.HandButton;
import eg.edu.guc.yugioh.gui.MainWindow;
import eg.edu.guc.yugioh.gui.MonsterButton;
import eg.edu.guc.yugioh.gui.SpellButton;

public abstract class BoardListener implements MouseListener {

	private MainWindow gui;

	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}

	public BoardListener(MainWindow gui) {
		this.gui = gui;
	}

	abstract public void mouseClicked(MouseEvent e);

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof MonsterButton) {
			MonsterCard m = ((MonsterButton) e.getSource()).getMonster();
			{
				if (Card.getBoard().getActivePlayer().getField().getMonstersArea()
						.contains(m)) {
					gui.setInfo(m.getName());
					gui.setInfo2("Attack : " + m.getAttackPoints()
							+ "  Deffense : " + m.getDefensePoints());
					gui.setInfo3("Level : " + m.getLevel());
				} else {
					if (!m.isHidden()) {
						gui.setInfo(m.getName());
						gui.setInfo2("Attack : " + m.getAttackPoints()
								+ "  Deffense : " + m.getDefensePoints());
						gui.setInfo3("Level : " + m.getLevel());
					} else {
						gui.setInfo("Back");
						gui.setInfo2("         Card is hidden");
						gui.setInfo3("         Card is hidden");
					}
				}
			}
		} else if (e.getSource() instanceof HandButton) {
			Card m = ((HandButton) e.getSource()).getCard();
			if (Card.getBoard().getActivePlayer().getField().getHand()
					.contains(m)) {
				if (m instanceof MonsterCard) {
					MonsterCard n = (MonsterCard) m;
					gui.setInfo(m.getName());
					gui.setInfo2("Attack : " + n.getAttackPoints()
							+ "  Deffense : " + n.getDefensePoints());
					gui.setInfo3("Level : " + n.getLevel());
				} else {

					gui.setInfo(m.getName());
					SpellCard n = (SpellCard) m;
					gui.setInfo2("                 " + n.getName());
					gui.setInfo3(n.getDescription());
				}
			}else {
				gui.setInfo("Back");
				gui.setInfo2("         Card is hidden");
				gui.setInfo3("         Card is hidden");
			}
		} else {
			SpellCard m = ((SpellButton) e.getSource()).getSpell();
			if (Card.getBoard().getActivePlayer().getField().getSpellArea()
					.contains(m)) {
				{
					gui.setInfo(m.getName());
					if (Card.getBoard().getActivePlayer().getField()
							.getSpellArea().contains(m)) {
						gui.setInfo2("                 " + m.getName());
						gui.setInfo3(m.getDescription());
					}
				}
			}else {
				gui.setInfo("Back");
				gui.setInfo2("         Card is hidden");
				gui.setInfo3("         Card is hidden");
			}
		}

	}

	public void mouseExited(MouseEvent e) {
		gui.setInfo2("                 Card Info");
		gui.setInfo("                 Card Info");
		gui.setInfo3("                 Card Info");
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}
