package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MonsterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<MonsterButton> monsters;
	private MainWindow gui;

	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}
	public ArrayList<MonsterButton> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<MonsterButton> monsters) {
		this.monsters = monsters;
	}

	public MonsterPanel(MainWindow gui) {
		super();
		this.gui = gui;
		monsters = new ArrayList<MonsterButton>();
		this.setLayout(new GridLayout(1, 5));
		this.validate();
		this.setBorder(null);
		this.setOpaque(false);
	}
	
	public void addToPanel(MonsterButton monster) {
		this.add(monster);
		monsters.add(monster);
		this.validate();
	}

	public void removeFromPanel(MonsterButton monster)
	{
		this.remove(monster);
		monsters.remove(monster);
		this.validate();
	}
}