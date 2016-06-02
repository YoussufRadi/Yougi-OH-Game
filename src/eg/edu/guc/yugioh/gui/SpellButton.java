package eg.edu.guc.yugioh.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.listeners.ActivateSpellListner;

public class SpellButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SpellCard spell;
	private MainWindow gui;

	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}

	public SpellCard getSpell() {
		return spell;
	}

	public void setSpell(SpellCard spell) {
		this.spell = spell;
	}

	public SpellButton(SpellCard spell, MainWindow gui) {
		super(new ImageIcon(spell.getName() + ".jpg"));
		this.gui = gui;
		this.addMouseListener(new ActivateSpellListner(gui));
		this.setSpell(spell);
		if (spell != null && !Card.getBoard().getOpponentPlayer().getField().getHand().contains(spell))
			this.setToolTipText("Name: " + spell.getName() + " ,Description: "
					+ spell.getDescription());
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
		this.setIcon((new ImageIcon(spell.getName() + ".jpg")));

	}

}
