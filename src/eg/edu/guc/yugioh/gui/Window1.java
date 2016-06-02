package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eg.edu.guc.yugioh.listeners.StartListener;
import eg.edu.guc.yugioh.listeners.WindowDestroyer;

public class Window1 extends JFrame {

	private JTextField jt;
	private JTextField jt2;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextField getJt() {
		return jt;
	}

	public void setJt(JTextField jt) {
		this.jt = jt;
	}

	public JTextField getJt2() {
		return jt2;
	}

	public void setJt2(JTextField jt2) {
		this.jt2 = jt2;
	}

	public Window1() {
		super();
		this.setBounds(500, 300, 620, 200);
		getContentPane().setLayout(null);
		JLabel yo = new JLabel("YU-GI-OH");
		yo.setBounds(280, 10, 200, 30);
		JLabel yo1 = new JLabel("MADE BY: Youssef Sameh & Mostafa Shaban");
		yo1.setBounds(200, 30, 400, 30);
		yo.setForeground(Color.BLUE);
		yo1.setForeground(Color.BLUE);
		getContentPane().add(yo);
		getContentPane().add(yo1);
		JLabel name = new JLabel("Please enter your names:");
		name.setBounds(30, 65, 200, 30);
		getContentPane().add(name);
		JPanel jp = new JPanel(new BorderLayout());
		JLabel pl1 = new JLabel(
				"                                     Player 1 ");
		jt = new JTextField(15);
		JLabel pl2 = new JLabel(
				"                                     Player 2 ");
		jt2 = new JTextField(1);
		jp.setLayout(new GridLayout(2, 2));
		jp.add(pl1);
		jp.add(jt);
		jp.add(pl2);
		jp.add(jt2);
		jp.setBounds(10, 90, 450, 55);
		getContentPane().add(jp);
		JButton start = new JButton(new ImageIcon("Start.png"));
		start.addMouseListener(new StartListener(this));
		start.setBounds(480, 50, 100, 100);
		start.setBorder(null);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.setOpaque(false);
		getContentPane().add(start);
		WindowDestroyer myListener = new WindowDestroyer();
		addWindowListener(myListener);
		this.setVisible(true);
		this.validate();

	}

	public static void main(String[] args) {
		new Window1();
	}
}
