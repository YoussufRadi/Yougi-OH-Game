package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import eg.edu.guc.yugioh.cards.Card;

public class GraveyardLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Card> card;

	public ArrayList<Card> getCard() {
		return card;
	}

	public void setCard(ArrayList<Card> card) {
		this.card = card;
	}

	public GraveyardLabel(ArrayList<Card> card) {
		super("GRAVEYARD IS EMPTY");
		this.setForeground(Color.WHITE);
		this.setCard(card);
		this.setBorder(null);
		this.setOpaque(false);
		this.validate();
	}

	public void changeImage(Card card) {
		this.setIcon(new ImageIcon(card.getName() + "jpg"));
		this.validate();

	}

	public void validatex(Card c) {
		if (c == null){
			this.setText("GRAVEYARD IS EMPTY");
		}
		else
			this.setIcon(new ImageIcon(c.getName() + "jpg"));
		this.validate();

	}

	public void addToGraveyard(Card card) {
		changeImage(card);
		this.validate();
	}

	public void removeFromGraveyard(Card card) {
		if (this.getCard().isEmpty())
			this.setText("GRAVEYARD IS EMPTY");
		else
			this.changeImage(card);
		this.validate();
	}

}
