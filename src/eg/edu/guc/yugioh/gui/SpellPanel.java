package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SpellPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<SpellButton> spells;
	private MainWindow gui;

	public MainWindow getGui() {
		return gui;
	}

	public void setGui(MainWindow gui) {
		this.gui = gui;
	}
	public ArrayList<SpellButton> getSpells() {
		return spells;
	}

	public void setSpells(ArrayList<SpellButton> spells) {
		this.spells = spells;
	}

	public SpellPanel(MainWindow gui) {
		super();
		this.gui = gui;
		spells = new ArrayList<SpellButton>();
		this.setLayout(new GridLayout(1, 5));
		this.setBorder(null);
		this.setOpaque(false);
		this.validate();
	}

	public void addToPanel(SpellButton spell) {
		this.add(spell);
		spells.add(spell);
		this.validate();
	}
	
	public void removeFromPanel(SpellButton spell)
	{
		this.remove(spell);
		spells.remove(spell);
		this.validate();
	}

}
