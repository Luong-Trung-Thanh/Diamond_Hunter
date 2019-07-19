package com.neet.DiamondHunter.Manager;

import com.neet.DiamondHunter.GameState.*;
import com.neet.DiamondHunter.Manager.GameStateManager;


public class GameStateFactory {
	public static final int NUM_STATES = 4;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int PLAY = 2;
	public static final int GAMEOVER = 3;
public static GameState creatGameState(int i,GameStateManager gsm) {
	GameState gameStates = null;
	if(i == INTRO) {
		gameStates = new IntroState(gsm);
		gameStates.init();
	}
	else if(i == MENU) {
		gameStates = new MenuState(gsm);
		gameStates.init();
	}
	else if(i == PLAY) {
		
		gameStates= new PlayState(gsm);
		gameStates.init();
	}
	else if(i == GAMEOVER) {
		gameStates = new GameOverState(gsm);
		gameStates.init();
	}
	return gameStates;
}

}
