package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OpponentPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonsterPanel monster;
	private SpellPanel spell;
	private HandPanel hand;
	private MainWindow gui;

	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}
	public MonsterPanel getMonster() {
		return monster;
	}

	public void setMonster(MonsterPanel monster) {
		this.monster = monster;
	}

	public SpellPanel getSpell() {
		return spell;
	}

	public void setSpell(SpellPanel spell) {
		this.spell = spell;
	}

	public HandPanel getHand() {
		return hand;
	}

	public void setHand(HandPanel hand) {
		this.hand = hand;
	}

	public OpponentPanel(MainWindow gui) {
		super();
		this.setBounds(220, 5, 850, 330);
		this.setLayout(new GridLayout(3,1));
		this.gui = gui;
		monster = new MonsterPanel(gui);
		spell = new SpellPanel(gui);
		hand = new HandPanel(gui);
		this.add(hand);
		this.add(spell);
		this.add(monster);
		this.setBorder(null);
		this.setOpaque(false);
		this.validate();
	}
	
	public void addToPanel(JButton g) {
		if(g instanceof HandButton)
			hand.addToPanel((HandButton)g);
		if(g instanceof SpellButton)
			spell.addToPanel((SpellButton)g);
		if(g instanceof MonsterButton)
			monster.addToPanel((MonsterButton)g);
		this.validate();
	}
	
	public void removeFromPanel(JButton g) {
		if(g instanceof HandButton)
			hand.removeFromPanel((HandButton)g);
		if(g instanceof SpellButton)
			spell.removeFromPanel((SpellButton)g);
		if(g instanceof MonsterButton)
			monster.removeFromPanel((MonsterButton)g);
		this.validate();
	}
	
}
