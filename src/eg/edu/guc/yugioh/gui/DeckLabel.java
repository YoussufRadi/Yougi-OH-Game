package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import eg.edu.guc.yugioh.cards.Card;

public class DeckLabel extends JLabel {

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

	public DeckLabel(ArrayList<Card> card) {
		super(new ImageIcon("Back.jpg"));
		this.setCard(card);
		this.setBorder(null);
		this.setOpaque(false);
		this.validate();
	}
	
	public void deckCheck() {
		if(this.getCard().isEmpty()){
			this.setIcon(new ImageIcon());
			this.setText("Deck is Empty");
			this.setForeground(Color.WHITE);
		}
		this.validate();
	}

}
