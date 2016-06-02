package eg.edu.guc.yugioh.listeners;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoSpaceException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;
import eg.edu.guc.yugioh.gui.SpellButton;
import eg.edu.guc.yugioh.gui.MainWindow;

public class ActivateSpellListner extends BoardListener {
	public ActivateSpellListner(MainWindow gui) {
		super(gui);
	}

	public void mouseClicked(MouseEvent e) {
		try {
			SpellButton First = ((SpellButton) e.getSource());
			if (Card.getBoard().getActivePlayer().getField().getSpellArea()
					.contains(First.getSpell())) {
				if ((First).getSpell() instanceof ChangeOfHeart) {
					if (Card.getBoard().getOpponentPlayer().getField()
							.getMonstersArea().isEmpty()) {
						JOptionPane.showMessageDialog(getGui(),
								"No monsters on field",
								"Spell cannot be activated",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					int n = JOptionPane.showConfirmDialog(null,
							"Are You Sure You Want To Activate Spell?", "Check",
							JOptionPane.YES_NO_OPTION);
					if (n == 1)
						return;
					ArrayList<MonsterCard> v = Card.getBoard()
							.getOpponentPlayer().getField().getMonstersArea();
					String[] choice1 = new String[v.size()];
					for (int i = 0; i < v.size(); i++)
						choice1[i] = v.get(i).getName();
					String d1 = (String) JOptionPane.showInputDialog(
							super.getGui(), "No monsters on field",
							"Change Of Heart", JOptionPane.QUESTION_MESSAGE,
							null, choice1, choice1[0]);
					int i = 0;
					MonsterCard monster = null;
					while (monster == null) {
						if (v.get(i).getName().equals(d1))
							monster = (v.get(i));
						i++;
					}
					Card.getBoard()
							.getActivePlayer()
							.activateSpell(
									(SpellCard) ((SpellButton) (e.getSource()))
											.getSpell(),
									monster);
				}
				if ((First).getSpell() instanceof MagePower) {
					if (Card.getBoard().getActivePlayer().getField()
							.getMonstersArea().isEmpty()) {
						JOptionPane.showMessageDialog(getGui(),
								"You have no monsters on field",
								"Spell cannot be activated",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					ArrayList<MonsterCard> v = Card.getBoard()
							.getActivePlayer().getField().getMonstersArea();
					String[] choice1 = new String[v.size()];
					for (int i = 0; i < v.size(); i++)
						choice1[i] = v.get(i).getName();
					String d1 = (String) JOptionPane.showInputDialog(
							super.getGui(), "No monsters on field",
							"Graceful Dice", JOptionPane.QUESTION_MESSAGE,
							null, choice1, choice1[0]);
					int i = 0;
					MonsterCard monster = null;
					while (monster == null) {
						if (v.get(i).getName().equals(d1))
							monster = (v.get(i));
						i++;
					}
					Card.getBoard()
							.getActivePlayer()
							.activateSpell(
									(SpellCard) ((SpellButton) (e.getSource()))
											.getSpell(),
									monster);
				} else if ((First).getSpell() instanceof MonsterReborn) {
					boolean f = false;
					for(int i = 0 ; i < Card.getBoard().getActivePlayer().getField()
							.getGraveyard().size();i++)
					{
						if (Card.getBoard().getActivePlayer().getField()
								.getGraveyard().get(i) instanceof MonsterCard)
							f = true;
					}
					
					for(int i = 0 ; i < Card.getBoard().getOpponentPlayer().getField()
							.getGraveyard().size();i++)
					{
						if (Card.getBoard().getOpponentPlayer().getField()
								.getGraveyard().get(i) instanceof MonsterCard)
							f = true;
					}
					if (!f) {
						JOptionPane.showMessageDialog(getGui(),
								"No monsters in greaveyard",
								"Spell cannot be activated",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					Card.getBoard()
							.getActivePlayer()
							.activateSpell(
									(SpellCard) ((SpellButton) (e.getSource()))
											.getSpell(),
									null);
				} else {
					Card.getBoard()
							.getActivePlayer()
							.activateSpell(
									(SpellCard) ((SpellButton) (e.getSource()))
											.getSpell(),
									null);
				}

				MainWindow.refresh(getGui());
			} else
				JOptionPane.showMessageDialog(getGui(),
						"This is the Opponent Field",
						"Spell cannot be activated", JOptionPane.ERROR_MESSAGE);
		} catch (MultipleMonsterAdditionException | WrongPhaseException
				| NoSpaceException ex) {
			JOptionPane.showMessageDialog(getGui(), ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
