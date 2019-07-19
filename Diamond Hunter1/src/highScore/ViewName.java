package highScore;

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
import javax.swing.JTextField;

import com.neet.DiamondHunter.Entity.Player;
import com.neet.DiamondHunter.GameState.GameOverState;
import com.neet.DiamondHunter.GameState.PlayState;

public class ViewName extends JFrame implements KeyListener {
	private JLabel lbTen, lbHoanTat;
	private JTextField textField;
	private static ViewName uniqueInstance;

	private ViewName() {
		init();
		add();
		setSize(350, 210);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static ViewName getInstance() {
		if (uniqueInstance == null) {
			// synchronized (ViewName.class) {
			if (uniqueInstance == null) {
				uniqueInstance = new ViewName();
			}
		}
		return uniqueInstance;
	}

	public static ViewName getUniqueInstance() {
		return uniqueInstance;
	}

	public static void setUniqueInstance(ViewName uniqueInstance) {
		ViewName.uniqueInstance = uniqueInstance;
	}

	public void init() {
		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src\\highScore\\menuscreen.gif")))));
		} catch (IOException e) {
		}
		lbTen = new JLabel("Please enter your name");
		lbTen.setFont(new Font("Please enter your name", Font.BOLD, 20));
		lbTen.setBounds(70, 50, 500, 50);

		lbHoanTat = new JLabel("Press ENTER to continue");
		lbHoanTat.setFont(new Font("Press ENTER to continue", Font.BOLD, 13));
		lbHoanTat.setBounds(95, 125, 200, 50);

		textField = new JTextField(20);
		textField.setBounds(85, 100, 180, 30);
		textField.addKeyListener(this);

	}

	public void add() {
		add(lbTen);
		add(lbHoanTat);
		add(textField);
	}

	@Override
	public void keyPressed(KeyEvent e) {// nhan vao phim
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String time = GameOverState.getTimePlay();
			GamerDao.add(textField.getText(), Player.getNumDiamonds(), time);
			setVisible(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { // nha phim ra
	}

	@Override
	public void keyTyped(KeyEvent e) { // nhap 1 phim
	}

	// public static void main(String[] args) {
	// new ViewName();
	// }
}
