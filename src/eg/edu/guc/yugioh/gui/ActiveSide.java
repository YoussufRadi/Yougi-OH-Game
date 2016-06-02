package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class ActiveSide extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DeckLabel deck;
	private GraveyardLabel grave;
	private JLabel q;
	
	public JLabel getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q.setText(" Cards in deck  "+ q);
	}

	public DeckLabel getDeck() {
		return deck;
	}

	public void setDeck(DeckLabel deck) {
		this.deck = deck;
	}

	public GraveyardLabel getGrave() {
		return grave;
	}

	public void setGrave(Card c) {
		if (c == null){
			grave.setIcon(null);
			grave.setText("GRAVEYARD IS EMPTY");
		}
		else
		{
			grave.removeAll();
			grave.setIcon(new ImageIcon(c.getName()+".jpg"));
		}this.validate();
	}

	public ActiveSide(Player x) {
		super();
		deck = new DeckLabel(x.getField().getDeck().getDeck());
		grave = new GraveyardLabel(x.getField().getGraveyard());
		this.setLayout(new GridLayout(3, 1));
		this.add(grave);
		this.add(deck);
		q = new JLabel(" Cards in deck  "+ x.getField().getDeck().getDeck().size());
		q.setForeground(Color.WHITE);
		this.add(q);
		this.setBorder(null);
		this.setOpaque(false);
		this.validate();
	}
}
