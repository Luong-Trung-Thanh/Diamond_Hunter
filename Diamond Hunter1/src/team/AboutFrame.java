package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.neet.DiamondHunter.Manager.GameStateManager;

import highScore.ViewHighScore;

public class AboutFrame extends JFrame implements KeyListener {
	private JLabel lb, lb2;
	private JTextArea ta;

	public AboutFrame() {
		initGUI();
		addLabels();
		setSize(350, 450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("About");
	}

	public void initGUI() {
		setContentPane(new JLabel(new ImageIcon("Resources\\HUD\\backgroud2.gif")));
		Container c = getContentPane();
		c.setBackground(Color.black);
		setLayout(null);
	}

	public void addLabels() {
		lb = new JLabel("ABOUT", JLabel.CENTER);
		Font font = new Font("ABOUT", Font.BOLD, 30);
		lb.setFont(font);
		lb.setForeground(Color.BLUE);
		lb.setBounds(100, 5, 150, 30);
		add(lb, BorderLayout.NORTH);

		lb2 = new JLabel("Press ESC to return");
		lb2.setFont(new Font("Press ESC to return", Font.BOLD, 13));
		lb2.setBounds(160, 375, 130, 13);
		add(lb2);

		ta = new JTextArea(" - Game name: Diamond Hunter.\n\n" + " - Subject: Object-Oriented Design.\n\n"
				+ " - Subject teacher: Tran Thi Thanh Nga.\n\n" + " - Game team: Group 09.\n\n"
				+ " - Group members:\n\n" + "      + Nguyen Ngoc Hong - 17130077\n\n"
				+ "      + Do Kim Phuong - 17130172\n\n" + "      + Dao Vu Thao Nguyen - 17130140\n\n"
				+ "      + Tran Quoc Thuan - 17130237\n\n" + "      + Luong Trung Thanh - 17130216\n\n"
				+ "        WISH YOU HAVE FUN PLAYING GAMES");
		ta.setBounds(10, 45, 530, 560);
		ta.setEditable(false);
		ta.setForeground(Color.black);
		ta.setBackground(Color.pink);
		ta.setOpaque(false);
		ta.setFont(new Font("arial", Font.BOLD, 13));
		ta.addKeyListener(this);
		add(ta, BorderLayout.CENTER);
	}

	@Override
	public void keyPressed(KeyEvent e) {// nhan vao phim
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			setVisible(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { // nha phim ra
	}

	@Override
	public void keyTyped(KeyEvent e) { // nhap 1 phim
	}

	public static void main(String[] args) {
		AboutFrame a = new AboutFrame();
	}

}
