// The main menu GameState.

package com.neet.DiamondHunter.GameState;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.Manager.GameStateManager;
import com.neet.DiamondHunter.Manager.JukeBox;
import com.neet.DiamondHunter.Manager.Keys;

import highScore.ViewHighScore;
import team.AboutFrame;

import team.HelpFrame;
import team.SoundFrame;

public class MenuState extends GameState {

	private BufferedImage bg;
	private BufferedImage diamond;

	private int currentOption = 0;
	private String[] options = { "START", "SOUND", "SCORE", "HELP", "ABOUT", "EXIT" };

	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		bg = Content.MENUBG[0][0];
		diamond = Content.DIAMOND[0][0];
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/menuoption.wav", "menuoption");
	}
	@Override
	public void update() {
		handleInput();
	}
	@Override
	public void draw(Graphics2D g) {

		g.drawImage(bg, 0, 0, null);

		// Content.drawString(g, options[0], 44, 70);
		Content.drawString(g, options[0], 44, 75);
		//
		Content.drawString(g, options[1], 44, 85);
		Content.drawString(g, options[2], 44, 95);
		Content.drawString(g, options[3], 48, 105);
		Content.drawString(g, options[4], 44, 115);
		Content.drawString(g, options[5], 48, 125);

		// if(currentOption == 0) g.drawImage(diamond, 25, 65, null);
		if (currentOption == 0)
			g.drawImage(diamond, 25, 72, null);
		///
		else if (currentOption == 1)
			g.drawImage(diamond, 25, 82, null);
		else if (currentOption == 2)
			g.drawImage(diamond, 25, 92, null);
		else if (currentOption == 3)
			g.drawImage(diamond, 27, 102, null);
		else if (currentOption == 4)
			g.drawImage(diamond, 25, 112, null);
		else if (currentOption == 5)
			g.drawImage(diamond, 27, 122, null);

	}

	public void handleInput() {
		if (Keys.isPressed(Keys.DOWN) && currentOption < options.length - 1) {
			if(!super.isMute)
			JukeBox.play("menuoption");
			currentOption++;
		}
		if (Keys.isPressed(Keys.UP) && currentOption > 0) {
			if(!super.isMute)
			JukeBox.play("menuoption");
			currentOption--;
		}
		if (Keys.isPressed(Keys.ENTER)) {
			if(!super.isMute)
			JukeBox.play("collect");
			selectOption();
		}
	}

	private void selectOption() {
		if (currentOption == 0) {
			gsm.setState(GameStateManager.PLAY);
		}
		if (currentOption == 1) {
			new SoundFrame(super.gsm);
		}
		if (currentOption == 2) {
			new ViewHighScore();
		}
		if (currentOption == 3) {
			new HelpFrame();
		}
		if (currentOption == 4) {
			new AboutFrame();
		}

		if (currentOption == 5) {
			System.exit(0);
		}
	}

}
