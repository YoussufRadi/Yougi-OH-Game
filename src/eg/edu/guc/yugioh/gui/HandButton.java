package eg.edu.guc.yugioh.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.listeners.HandListener;

public class HandButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Card card;
	private MainWindow gui;

	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public HandButton(Card card, MainWindow gui) {
		super(new ImageIcon(card.getName() + ".jpg"));
		this.gui = gui;
		if (Card.getBoard().getOpponentPlayer().getField().getHand()
				.contains(card))
			flipBack();
		this.addMouseListener(new HandListener(gui));
		this.setCard(card);
		if(card!=null && !Card.getBoard().getOpponentPlayer().getField().getHand().contains(card))
			if(card instanceof SpellCard)
			this.setToolTipText("Name: " + card.getName()+ " ,Description: " + card.getDescription());
			else this.setToolTipText("Name: " + card.getName()+ " ,Description: " + card.getDescription()+ " ,Level: " + ((MonsterCard)card).getLevel()+
					" ,Attack: " + ((MonsterCard)card).getAttackPoints()+ " ,Deffense: " + ((MonsterCard)card).getDefensePoints() );
		this.setBorder(null);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setOpaque(false);
		this.validate();
	}

	public void flipBack() {
		this.setIcon((new ImageIcon("Back.jpg")));
	}

	public void flipOriginal() {
		this.setIcon((new ImageIcon(card.getName() + ".jpg")));
	}
}
