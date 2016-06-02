package eg.edu.guc.yugioh.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.listeners.MonsterListner;

public class MonsterButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MonsterCard monster;
	private MainWindow gui;

	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}

	public MonsterCard getMonster() {
		return monster;
	}

	public void setMonster(MonsterCard monster) {
		this.monster = monster;
	}

	public MonsterButton(MonsterCard monster, MainWindow gui) {
		super(new ImageIcon(monster.getName() + ".jpg"));
		this.gui = gui;
		this.setMonster(monster);
		if (monster.getMode() == Mode.DEFENSE)
			this.flipBack();
		this.addMouseListener(new MonsterListner(getGui()));
		if(monster!=null && !Card.getBoard().getOpponentPlayer().getField().getHand().contains(monster))
			this.setToolTipText("Name: " + monster.getName()+ " ,Description: " + monster.getDescription()+ " ,Level: " + monster.getLevel()+
						" ,Attack: " + monster.getAttackPoints()+ " ,Deffense: " + monster.getDefensePoints() );
		this.setBorder(null);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setOpaque(false);
		this.validate();
	}

	public void changeToAttack() {
		this.setIcon((new ImageIcon(monster.getName() + ".jpg")));
	}

	public void flipBack() {
		if (this.getMonster().isHidden())
			this.setIcon((new ImageIcon("Defense.jpg")));
		else
			this.setIcon((new ImageIcon(this.getMonster().getName() + "12.jpg")));
	}

	public void flipOriginal() {
		this.setIcon((new ImageIcon(monster.getName() + ".jpg")));

	}
}
