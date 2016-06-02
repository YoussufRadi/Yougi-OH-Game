package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import eg.edu.guc.yugioh.listeners.ClickDestroyer;
import eg.edu.guc.yugioh.listeners.StartAgainListener;
import eg.edu.guc.yugioh.listeners.WindowDestroyer;

public class Winner extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param x
	 */
	public Winner(String x){
		super();
		this.setSize(640, 450);
		this.setLayout(null);
		JLabel yo = new JLabel("YU-GI-OH");
		yo.setFont(yo.getFont().deriveFont(41f));
		yo.setBounds(200, 10, 400, 100);
		JLabel yo1 = new JLabel("MADE BY: Youssef Sameh & Mostafa Shaban");
		yo1.setFont(yo.getFont().deriveFont(20f));
		yo1.setBounds(90, 70, 500, 100);
		yo.setForeground(Color.BLUE);
		yo1.setForeground(Color.RED);
		add(yo);
		add(yo1);
		JLabel winner = new JLabel("the winner is "+x);
		winner.setBounds(200, 65, 250, 200);
		winner.setFont(yo.getFont().deriveFont(20f));
		add(winner);
		JButton SA = new JButton(new ImageIcon("StartAgain.png"));
		SA.setBorder(null);
		SA.setContentAreaFilled(false);
		SA.setBorderPainted(false);
		SA.setOpaque(false);
		JButton close = new JButton(new ImageIcon("Exit.png"));
		close.setBorder(null);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setOpaque(false);
		SA.setBounds(50, 200, 250, 200);
		close.setBounds(320, 200, 250, 200);
		this.add(SA);
		this.add(close);
		WindowDestroyer myListener = new WindowDestroyer();
        addWindowListener( myListener);
        close.addMouseListener(new ClickDestroyer());
        SA.addMouseListener(new StartAgainListener(this));
		this.setVisible(true);
		this.validate();
	}
	
	public static void main(String[] args) {
		new Winner(null);
	}
}
