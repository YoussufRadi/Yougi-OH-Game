package eg.edu.guc.yugioh.listeners;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;
import eg.edu.guc.yugioh.gui.MainWindow;
import eg.edu.guc.yugioh.gui.MonsterButton;

public class MonsterListner extends BoardListener {

	public MonsterListner(MainWindow gui) {
		super(gui);
	}

	public void mouseClicked(MouseEvent e) {
		MonsterButton First = ((MonsterButton) (e.getSource()));
		if (Card.getBoard().getActivePlayer().getField().getMonstersArea()
				.contains(First.getMonster())) {
			String[] choice = { "Declare Attack", "Switch Mode" };
			String d = (String) JOptionPane.showInputDialog(super.getGui(),
					"What do you want to do with this card?", "Card in Hand",
					JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
			if (d == null)
				return;
			if(d.equals("Declare Attack")){
			try {
				if (Card.getBoard().getOpponentPlayer().getField()
						.getMonstersArea().size() == 0){
					int n = JOptionPane.showConfirmDialog(null,
							"Are You Sure You Want To Attack?", "Check",
							JOptionPane.YES_NO_OPTION);
					if (n == 1)
						return;
					Card.getBoard().getActivePlayer()
							.declareAttack(First.getMonster());}
				else {
					ArrayList<MonsterCard> v = Card.getBoard()
							.getOpponentPlayer().getField().getMonstersArea();
					String[] choice1 = new String[v.size()];
					for (int i = 0; i < v.size(); i++)
						choice1[i] = v.get(i).getName();
					String d1 = (String) JOptionPane.showInputDialog(
							super.getGui(), "Select Monster To Attack",
							"Declare attack", JOptionPane.QUESTION_MESSAGE,
							null, choice1, choice1[0]);
					if (d1 == null)
						return;
					int i = 0;
					ArrayList<MonsterCard> monster = new ArrayList<MonsterCard>();
					while (monster.isEmpty()) {
						if (v.get(i).getName().equals(d1))
							monster.add(v.get(i));
						i++;
					}
					Card.getBoard()
							.getActivePlayer()
							.declareAttack(First.getMonster(),monster.get(0));

				}
			} catch (MonsterMultipleAttackException | WrongPhaseException
					| DefenseMonsterAttackException f) {
				JOptionPane.showMessageDialog(getGui(), f.getMessage(),
						f.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				try{
					Card.getBoard().getActivePlayer().switchMonsterMode(First.getMonster());
				}
				catch(WrongPhaseException f){
					JOptionPane.showMessageDialog(getGui(), f.getMessage(),
							f.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
			MainWindow.refresh(getGui());
		}else JOptionPane.showMessageDialog(getGui(), "This is the Opponent Field",
				"Stay in your field",
				JOptionPane.ERROR_MESSAGE);
	}
}
