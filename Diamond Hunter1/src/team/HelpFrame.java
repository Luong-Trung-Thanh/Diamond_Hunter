package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HelpFrame extends JFrame implements KeyListener {
	private JLabel lb, lb2;
	private JTextArea ta;

	public HelpFrame() {
		initGUI();
		addLabels();
		setTitle("Help");
		setVisible(true);
		setSize(350, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initGUI() {
		setContentPane(new JLabel(new ImageIcon("Resources\\HUD\\backgroud2.gif")));
		Container c = getContentPane();
		c.setBackground(Color.BLACK);
		setLayout(null);
	}

	public void addLabels() {
		lb = new JLabel("HELP", JLabel.CENTER);
		Font font = new Font("HELP", Font.BOLD, 30);
		lb.setFont(font);
		lb.setForeground(Color.BLUE);
		lb.setBounds(100, 10, 150, 30);
		add(lb, BorderLayout.NORTH);
		lb2 = new JLabel("Press ESC to return");
		lb2.setFont(new Font("Press ESC to return", Font.BOLD, 13));
		lb2.setBounds(160, 365, 130, 13);
		add(lb2);
		ta = new JTextArea(" - Move the hunter: enter up/down/home/end.\n\n"
				+ " - Find the hammer to break the tree.\n\n" + " - The hunter used a boat to cross the river.\n\n"
				+ " - The hunter is responsible for hunting diamonds.\n\n"
				+ " - Each diamond is equivalent to a bonus point.\n\n" + " - Notice the time to find diamonds.\n\n"
				+ " - Finding more diamonds in a short time.\n\n"
				+ " - Go to the rankings to see the highest score.\n\n"
				+ " - You can customize the game with the utility.\n\n" + "      NOW LET'S START PLAYING THE GAME");
		ta.setBounds(15, 60, 530, 560);
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
		HelpFrame h = new HelpFrame();
	}

}
