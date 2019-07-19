package highScore;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ViewHighScore extends JFrame implements KeyListener {
	private JLabel lbScore;
	private JLabel lbOut;
	private JTextArea textArea;

	public ViewHighScore() {
		init();
		add();
		setSize(350, 280);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("High Score");
	}

	public void init() {
		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Resources\\HUD\\backgroud2.gif")))));
		} catch (IOException e) {
		}
		lbScore = new JLabel("High Score");
		lbScore.setFont(new Font("High Score", Font.BOLD, 30));
		lbScore.setBounds(100, 5, 500, 35);

		lbOut = new JLabel("Enter ESC to return");
		lbOut.setFont(new Font("Enter ESC to return", Font.BOLD, 13));
		lbOut.setBounds(200, 230, 190, 13);

		textArea = new JTextArea();
		textArea.setBackground(Color.white);
		String s = "";
		GamerDao g = new GamerDao();
		g.arrSort();
		ArrayList<Gamer> list = g.list;
		for (int i = 0; i < list.size(); i++) {
			s += " " + (i + 1) + "\t" + list.get(i).getName() + "\t\t" + "    " + list.get(i).getScore() + "\t"
					+ list.get(i).getTime() + "\n";
		}
		textArea.setText(" NO\tName\tScore\tTime\n" + s);
		textArea.setBounds(22, 50, 300, 170);
		textArea.setEditable(false);
		textArea.addKeyListener(this);
	}

	public void add() {
		add(lbScore);
		add(lbOut);
		add(textArea);
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
		new ViewHighScore();
	}

}
