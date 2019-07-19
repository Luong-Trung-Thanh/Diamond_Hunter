
// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package com.neet.DiamondHunter.Main;

import javax.swing.JFrame;

public class Game extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  static volatile Game uniqueGame;
	private Game() {
		add(new GamePanel());
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static Game getGame() {
		if(uniqueGame == null) {
			synchronized (Game.class) {
				if(uniqueGame == null) {
					uniqueGame = new Game();
				}
			}
		}
return uniqueGame;


	}
	public static void main(String[] args) {
		System.out.println(Game.getGame().hashCode());
		System.out.println(Game.getGame().hashCode());
		
		
		
	}
	
}
