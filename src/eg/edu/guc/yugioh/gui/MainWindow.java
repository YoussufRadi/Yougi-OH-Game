package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Field;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.listeners.*;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivePannel activePannel;
	private OpponentPanel opponentPanel;
	private HelperPanel helperPanel;
	private ActiveSidePanel activeSidePanel;
	private OpponentSidePanel opponentSidePanel;
	private Player p1;
	private Player p2;
	private JLabel info;
	private JLabel info2;
	private JLabel info3;
	
	public JLabel getInfo() {
		return info;
	}

	public void setInfo(String x) {
		info.setIcon(new ImageIcon( x+ "1.jpg"));
	}
	
	public JLabel getInfo2() {
		return info2;
	}

	public void setInfo2(String x) {
		info2.setText(x);
	}
	
	public void setInfo3(String x) {
		info3.setText(x);
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public ActivePannel getActivePannel() {
		return activePannel;
	}

	public void setActivePannel(ActivePannel activePannel) {
		this.activePannel = activePannel;
	}

	public OpponentPanel getOpponentPanel() {
		return opponentPanel;
	}

	public void setOpponentPanel(OpponentPanel opponentPanel) {
		this.opponentPanel = opponentPanel;
	}

	public HelperPanel getHelperPanel() {
		return helperPanel;
	}

	public void setHelperPanel(HelperPanel helperPanel) {
		this.helperPanel = helperPanel;
	}

	public ActiveSidePanel getActiveSidePanel() {
		return activeSidePanel;
	}

	public void setActiveSidePanel(ActiveSidePanel activeSidePanel) {
		this.activeSidePanel = activeSidePanel;
	}

	public OpponentSidePanel getOpponentSidePanel() {
		return opponentSidePanel;
	}

	public void setOpponentSidePanel(OpponentSidePanel opponentSidePanel) {
		this.opponentSidePanel = opponentSidePanel;
	}

	public MainWindow(Board b) {
		super("YugiOH Game Done By Youssuf Radi & Mostafa Shaban");
		this.p1 = Card.getBoard().getActivePlayer();
		this.p2 = Card.getBoard().getOpponentPlayer();
		this.setBounds(10, 10, 1400, 720);
		setContentPane(new JLabel(new ImageIcon("BackGround.jpg")));
		setLayout(null);
		WindowDestroyer myListener = new WindowDestroyer();
		activePannel = new ActivePannel(this);
		opponentPanel = new OpponentPanel(this);
		getContentPane().add(opponentPanel);
		getContentPane().add(activePannel);
		addWindowListener(myListener);
		helperPanel = new HelperPanel(this);
		helperPanel.setBounds(10,450, 200, 220);
		info2 = new JLabel("                 Card Info");
		info2.setForeground(Color.WHITE);
		info2.setBounds(10, 380, 200, 50);
		this.add(info2);
		info3 = new JLabel("                 Card Info");
		info3.setForeground(Color.WHITE);
		info3.setBounds(10, 405, 200, 50);
		this.add(info3);
		info = new JLabel("                 Card Info");
		info.setForeground(Color.WHITE);
		info.setBounds(10, 10, 250, 400);
		this.add(info);
		getContentPane().add(helperPanel);
		activeSidePanel = new ActiveSidePanel(p1);
		getContentPane().add(activeSidePanel);
		opponentSidePanel = new OpponentSidePanel(p2);
		getContentPane().add(opponentSidePanel);
		this.setVisible(true);
		MainWindow.refresh(this);
		this.setBackground(Color.BLACK);
		this.validate();
		
	}

	public static void refresh(MainWindow gui) {
		if (Card.getBoard().getWinner() != null) {
			gui.setVisible(false);
			new Winner(Card.getBoard().getWinner().getName());
		}
		Field z = Card.getBoard().getActivePlayer().getField();

		for (int i = 0; i < gui.getActivePannel().getMonster().getMonsters()
				.size(); i++)
			if (!z.getMonstersArea().contains(
					gui.getActivePannel().getMonster().getMonsters().get(i)
							.getMonster())) {
				gui.getActivePannel()
						.removeFromPanel(
								gui.getActivePannel().getMonster()
										.getMonsters().get(i));
				i--;
			}
		for (int i = 0; i < z.getMonstersArea().size(); i++)
			if (!containsMonster(z.getMonstersArea().get(i), gui
					.getActivePannel().getMonster()))
				gui.getActivePannel().addToPanel(
						new MonsterButton(z.getMonstersArea().get(i), gui));

		for (int i = 0; i < gui.getActivePannel().getSpell().getSpells().size(); i++)
			if (!z.getMonstersArea().contains(
					gui.getActivePannel().getSpell().getSpells().get(i)
							.getSpell())) {
				gui.getActivePannel().removeFromPanel(
						gui.getActivePannel().getSpell().getSpells().get(i));
				i--;
			}
		for (int i = 0; i < z.getSpellArea().size(); i++)
			if (!containsSpell(z.getSpellArea().get(i), gui.getActivePannel()
					.getSpell()))
				gui.getActivePannel().addToPanel(
						new SpellButton(z.getSpellArea().get(i), gui));

		for (int i = 0; i < gui.getActivePannel().getHand().getHands().size(); i++)
			if (!z.getHand()
					.contains(
							gui.getActivePannel().getHand().getHands().get(i)
									.getCard())) {
				gui.getActivePannel().removeFromPanel(
						gui.getActivePannel().getHand().getHands().get(i));
				i--;
			}
		for (int i = 0; i < z.getHand().size(); i++)
			if (!containsHand(z.getHand().get(i), gui.getActivePannel()
					.getHand()))
				gui.getActivePannel().addToPanel(
						new HandButton(z.getHand().get(i), gui));

		Field z1 = Card.getBoard().getOpponentPlayer().getField();
		for (int i = 0; i < gui.getOpponentPanel().getMonster().getMonsters()
				.size(); i++)
			if (!z1.getMonstersArea().contains(
					gui.getOpponentPanel().getMonster().getMonsters().get(i)
							.getMonster())) {
				gui.getOpponentPanel().removeFromPanel(
						gui.getOpponentPanel().getMonster().getMonsters()
								.get(i));
				i--;
			}
		for (int i = 0; i < z1.getMonstersArea().size(); i++)
			if (!containsMonster(z1.getMonstersArea().get(i), gui
					.getOpponentPanel().getMonster()))
				gui.getOpponentPanel().addToPanel(
						new MonsterButton(z1.getMonstersArea().get(i), gui));

		for (int i = 0; i < gui.getOpponentPanel().getSpell().getSpells()
				.size(); i++)
			if (!z1.getSpellArea().contains(
					gui.getOpponentPanel().getSpell().getSpells().get(i)
							.getSpell())) {
				gui.getOpponentPanel().removeFromPanel(
						gui.getOpponentPanel().getSpell().getSpells().get(i));
				i--;
			}
		for (int i = 0; i < z1.getSpellArea().size(); i++)
			if (!containsSpell(z1.getSpellArea().get(i), gui.getOpponentPanel()
					.getSpell()))
				gui.getOpponentPanel().addToPanel(
						new SpellButton(z1.getSpellArea().get(i), gui));

		for (int i = 0; i < gui.getOpponentPanel().getHand().getHands().size(); i++)
			if (!z1.getHand().contains(
					gui.getOpponentPanel().getHand().getHands().get(i)
							.getCard())) {
				gui.getOpponentPanel().removeFromPanel(
						gui.getOpponentPanel().getHand().getHands().get(i));
				i--;
			}
		for (int i = 0; i < z1.getHand().size(); i++)
			if (!containsHand(z1.getHand().get(i), gui.getOpponentPanel()
					.getHand()))
				gui.getOpponentPanel().addToPanel(
						new HandButton(z1.getHand().get(i), gui));

		for (int i = 0; i < gui.getOpponentPanel().getHand().getHands().size(); i++)
			gui.getOpponentPanel().getHand().getHands().get(i).flipBack();
		for (int i = 0; i < gui.getActivePannel().getHand().getHands().size(); i++)
			gui.getActivePannel().getHand().getHands().get(i).flipOriginal();
		
		for (int i = 0; i < gui.getActivePannel().getSpell().getSpells()
				.size(); i++) {
			if (gui.getActivePannel().getSpell().getSpells().get(i)
					.getSpell().isHidden())
				gui.getActivePannel().getSpell().getSpells().get(i)
						.flipBack();
		}
		
		for (int i = 0; i < gui.getOpponentPanel().getSpell().getSpells()
				.size(); i++) {
			if (gui.getOpponentPanel().getSpell().getSpells().get(i)
					.getSpell().isHidden())
				gui.getOpponentPanel().getSpell().getSpells().get(i)
						.flipBack();
		}

		for (int i = 0; i < gui.getActivePannel().getMonster().getMonsters()
				.size(); i++) {
			if (gui.getActivePannel().getMonster().getMonsters().get(i)
					.getMonster().getMode().equals(Mode.DEFENSE))
				gui.getActivePannel().getMonster().getMonsters().get(i)
						.flipBack();
		}

		for (int i = 0; i < gui.getActivePannel().getMonster().getMonsters()
				.size(); i++) {
			if (gui.getActivePannel().getMonster().getMonsters().get(i)
					.getMonster().getMode().equals(Mode.ATTACK))
				gui.getActivePannel().getMonster().getMonsters().get(i)
						.flipOriginal();
		}

		for (int i = 0; i < gui.getOpponentPanel().getMonster().getMonsters()
				.size(); i++) {
			if (gui.getOpponentPanel().getMonster().getMonsters().get(i)
					.getMonster().getMode().equals(Mode.DEFENSE))
				gui.getOpponentPanel().getMonster().getMonsters().get(i)
						.flipBack();
		}
		
		gui.getActiveSidePanel().getActiveInfo()
				.setLP(Card.getBoard().getActivePlayer().getLifePoints());
		gui.getOpponentSidePanel().getOpponentInfo()
				.setLP(Card.getBoard().getOpponentPlayer().getLifePoints());

		gui.getActiveSidePanel().getActiveSide().getDeck().deckCheck();
		gui.getOpponentSidePanel().getOpponentSide().getDeck().deckCheck();

		gui.getActiveSidePanel()
				.getActiveSide()
				.setQ(Card.getBoard().getActivePlayer().getField().getDeck()
						.getDeck().size());
		gui.getOpponentSidePanel()
				.getOpponentSide()
				.setQ(Card.getBoard().getOpponentPlayer().getField().getDeck()
						.getDeck().size());

		gui.getActiveSidePanel()
				.getActiveSide()
				.getGrave()
				.setCard(
						Card.getBoard().getActivePlayer().getField()
								.getGraveyard());
		gui.getOpponentSidePanel()
				.getOpponentSide()
				.getGrave()
				.setCard(
						Card.getBoard().getOpponentPlayer().getField()
								.getGraveyard());
		ArrayList<Card> es = Card.getBoard().getActivePlayer().getField()
				.getGraveyard();
		ArrayList<Card> et = Card.getBoard().getOpponentPlayer().getField()
				.getGraveyard();
		
		if (es.isEmpty())
			gui.getActiveSidePanel().getActiveSide().setGrave(null);
		else
			gui.getActiveSidePanel().getActiveSide().setGrave(es.get(es.size() - 1));
		if (et.isEmpty())
			gui.getOpponentSidePanel().getOpponentSide().setGrave(null);
		else
			gui.getOpponentSidePanel().getOpponentSide().setGrave(et.get(et.size() - 1));

		gui.getActiveSidePanel().getActiveInfo()
				.setName(Card.getBoard().getActivePlayer().getName());
		gui.getOpponentSidePanel().getOpponentInfo()
				.setName(Card.getBoard().getOpponentPlayer().getName());

		gui.getActiveSidePanel().getActiveInfo()
				.setPhase(Card.getBoard().getActivePlayer());
		gui.getOpponentSidePanel().getOpponentInfo()
				.setPhase(Card.getBoard().getOpponentPlayer());
		gui.repaint();
	}

	private static boolean containsMonster(MonsterCard monster, MonsterPanel gui) {
		int i = gui.getMonsters().size() - 1;
		while (i > -1)
			if (gui.getMonsters().get(i--).getMonster().equals(monster))
				return true;
		return false;
	}

	private static boolean containsSpell(SpellCard spell, SpellPanel gui) {
		int i = gui.getSpells().size() - 1;
		while (i > -1)
			if (gui.getSpells().get(i--).getSpell().equals(spell))
				return true;
		return false;
	}

	private static boolean containsHand(Card card, HandPanel gui) {
		int i = gui.getHands().size() - 1;
		while (i > -1)
			if (gui.getHands().get(i--).getCard().equals(card))
				return true;
		return false;
	}
}