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
import eg.edu.guc.yugioh.gui.HandButton;
import eg.edu.guc.yugioh.gui.MainWindow;


public class HandListener extends BoardListener {

	public HandListener(MainWindow gui) {
		super(gui);
	}

	public void mouseClicked(MouseEvent e) {
		try {
			if (Card.getBoard().getActivePlayer().getField().getHand()
					.contains(((HandButton) e.getSource()).getCard())) {
				if (e.getSource() instanceof HandButton
						&& ((HandButton) e.getSource()).getCard() instanceof MonsterCard) {
					String[] choice = { "Summon monster", "Set Monster" };
					String d = (String) JOptionPane.showInputDialog(
							super.getGui(),
							"What do you want to do with this card?",
							"Card in Hand", JOptionPane.QUESTION_MESSAGE, null,
							choice, choice[0]);
					if (d == null)
						return;
					if (5 > ((MonsterCard) ((HandButton) e.getSource())
							.getCard()).getLevel()) {
						if (d.equals("Summon monster"))
							Card.getBoard()
									.getActivePlayer()
									.summonMonster(
											((MonsterCard) ((HandButton) e
													.getSource()).getCard()));
						else
							Card.getBoard()
									.getActivePlayer()
									.setMonster(
											((MonsterCard) ((HandButton) e
													.getSource()).getCard()));
					} else if (7 > ((MonsterCard) ((HandButton) e.getSource())
							.getCard()).getLevel()) {
						if (Card.getBoard().getActivePlayer().getField()
								.getMonstersArea().isEmpty())
							JOptionPane.showMessageDialog(getGui(),
									"Your Monster Area is Empty",
									"Cannot Summon", JOptionPane.ERROR_MESSAGE);
						else {
							ArrayList<MonsterCard> v = Card.getBoard()
									.getActivePlayer().getField()
									.getMonstersArea();
							String[] choice1 = new String[v.size()];
							for (int i = 0; i < v.size(); i++)
								choice1[i] = v.get(i).getName();
							String d1 = (String) JOptionPane.showInputDialog(
									super.getGui(), "Select Sacrifice",
									"Summon monster",
									JOptionPane.QUESTION_MESSAGE, null,
									choice1, choice1[0]);
							if (d1 == null)
								return;
							int i = 0;
							ArrayList<MonsterCard> monster = new ArrayList<MonsterCard>();
							while (monster.isEmpty()) {
								if (v.get(i).getName().equals(d1))
									monster.add(v.get(i));
								i++;
							}
							if (d.equals("Summon monster"))
								Card.getBoard()
										.getActivePlayer()
										.summonMonster(
												((MonsterCard) ((HandButton) e.getSource())
														.getCard()), monster);
							else
								Card.getBoard()
										.getActivePlayer()
										.setMonster(
												((MonsterCard) ((HandButton) e.getSource())
														.getCard()), monster);
						}
					} else if (Card.getBoard().getActivePlayer().getField()
							.getMonstersArea().size() < 2)
						JOptionPane
								.showMessageDialog(
										getGui(),
										"You Must Have At Least Two Monsters To Summon",
										"Cannot Summon",
										JOptionPane.ERROR_MESSAGE);
					else {
						ArrayList<MonsterCard> v = Card.getBoard()
								.getActivePlayer().getField().getMonstersArea();
						String[] choice1 = new String[v.size()];
						for (int i = 0; i < v.size(); i++)
							choice1[i] = v.get(i).getName();
						String d1 = (String) JOptionPane.showInputDialog(
								super.getGui(), "Select First Sacrifice",
								"Summon monster", JOptionPane.QUESTION_MESSAGE,
								null, choice1, choice1[0]);
						if (d1 == null)
							return;
						int i = 0;
						ArrayList<MonsterCard> monster = new ArrayList<MonsterCard>();
						while (monster.isEmpty()) {
							if (v.get(i).getName().equals(d1))
								monster.add(v.get(i));
							else
								i++;
						}
						String[] choice2 = new String[v.size()-1];
						int q =0;
						for (int j = 0; j < v.size(); j++) {
							if (!monster.get(0).equals(v.get(j))){
								choice2[q] = v.get(j).getName();
								q++;}
						}
						String d2 = (String) JOptionPane.showInputDialog(
								super.getGui(), "Select Second Sacrifice",
								"Summon monster", JOptionPane.QUESTION_MESSAGE,
								null, choice2, choice2[0]);
						if (d2 == null)
							return;
						i = 0;
						while (monster.size() < 2) {
							if (v.get(i).getName().equals(d2) && !monster.get(0).equals(v.get(i)))
								monster.add(v.get(i));
							else
								i++;
						}
						if (d.equals("Summon monster"))
							Card.getBoard()
									.getActivePlayer()
									.summonMonster(
											((MonsterCard) ((HandButton) e.getSource())
													.getCard()), monster);
						else
							Card.getBoard()
									.getActivePlayer()
									.setMonster(
											((MonsterCard) ((HandButton) e.getSource())
													.getCard()), monster);
					}
				} else if (e.getSource() instanceof HandButton
						&& ((HandButton) e.getSource()).getCard() instanceof SpellCard) {
					String[] choice = { "Set Spell", "Activate Spell" };
					String d = (String) JOptionPane.showInputDialog(
							super.getGui(),
							"What do you want to do with this card?",
							"Card in Hand", JOptionPane.QUESTION_MESSAGE, null,
							choice, choice[0]);
					if (d == null)
						return;
					switch (d) {
					case "Set Spell":
						Card.getBoard()
								.getActivePlayer()
								.setSpell(
										(SpellCard) ((HandButton) e.getSource())
												.getCard());
						break;
					case "Activate Spell":
						HandButton First = ((HandButton) e.getSource());
							if ((First).getCard() instanceof ChangeOfHeart) {
								if (Card.getBoard().getOpponentPlayer().getField()
										.getMonstersArea().isEmpty()) {
									JOptionPane.showMessageDialog(getGui(),
											"No monsters on field",
											"Spell cannot be activated",
											JOptionPane.ERROR_MESSAGE);
									return;
								}
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
												(SpellCard) ((HandButton) (e.getSource()))
														.getCard(),
												monster);
							}
							if ((First).getCard() instanceof MagePower) {
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
												(SpellCard) ((HandButton) (e.getSource()))
														.getCard(),
												monster);
							} else if ((First).getCard() instanceof MonsterReborn) {
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
												(SpellCard) ((HandButton) (e.getSource()))
														.getCard(),
												null);
							} else {
								Card.getBoard()
										.getActivePlayer()
										.activateSpell(
												(SpellCard) ((HandButton) (e.getSource()))
														.getCard(),
												null);
							}
					}
				}
				MainWindow.refresh(getGui());
			} else
				JOptionPane.showMessageDialog(getGui(),
						"This is the Opponent Hand",
						"Spell cannot be activated", JOptionPane.ERROR_MESSAGE);
		} catch (MultipleMonsterAdditionException | WrongPhaseException
				| NoSpaceException ex) {
			JOptionPane.showMessageDialog(getGui(), ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
