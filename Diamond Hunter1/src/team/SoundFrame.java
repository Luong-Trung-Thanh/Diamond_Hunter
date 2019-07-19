package team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.neet.DiamondHunter.GameState.GameOverState;
import com.neet.DiamondHunter.GameState.PlayState;
import com.neet.DiamondHunter.Manager.GameStateManager;
import com.neet.DiamondHunter.Manager.JukeBox;

import highScore.GamerDao;

public class SoundFrame extends JFrame implements KeyListener {
	private JLabel lb, lb1, lb2, lb3;
private GameStateManager gsm;
	public SoundFrame(GameStateManager gsm) {
		this.gsm = gsm;
		init();
		add();
		setSize(350, 175);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		addKeyListener(this);
	}

	public void init() {
		try {
			this.setContentPane(new JLabel(new ImageIcon(
					ImageIO.read(new File("Resources\\HUD\\backgroud2.gif")))));
		} catch (IOException e) {
		}
		lb = new JLabel("Music");
		lb.setFont(new Font("Music", Font.BOLD, 30));
		lb.setBounds(135, 20, 100, 30);
		
		lb1 = new JLabel("Press F1 to continue");
		lb1.setFont(new Font("Press F1 to continue",Font.BOLD, 12));
		lb1.setBounds(120, 50, 200, 50);
		
		lb2 = new JLabel("Press F2 to stop music");
		lb2.setFont(new Font("Press F2 to stop music",Font.BOLD, 12));
		lb2.setBounds(120, 72, 200, 50);
		
		lb3 = new JLabel("Press ESC to return");
		lb3.setFont(new Font("Press ESC to return",Font.BOLD, 12));
		lb3.setBounds(120, 94, 200, 50);
	}

	public void add() {
		add(lb);
		add(lb1);
		add(lb2);
		add(lb3);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {// nhan vao phim
        if (e.getKeyCode() == KeyEvent.VK_F1) {
        	JukeBox.resumeLoop("music1");
        	this.gsm.setMute(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_F2) {
        	JukeBox.stop("music1");
        	JukeBox.stop("collect");
        	JukeBox.stop("menuoption");
        	this.gsm.setMute(true);
        }
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

}
