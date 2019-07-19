// The GameStateManager does exactly what its
// name says. It contains a list of GameStates.
// It decides which GameState to update() and
// draw() and handles switching between different
// GameStates.

package com.neet.DiamondHunter.Manager;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.neet.DiamondHunter.GameState.ITempCalcModel;

import com.neet.DiamondHunter.GameState.Observer;
import com.neet.DiamondHunter.GameState.*;

public class GameStateManager implements IModelAdapter, Subject {
	private List<Observer> listObserver;
	private boolean mute;
	private boolean paused;
	private ITempCalcModel pauseState;
	private ITempCalcModel gameStates;

	public static final int NUM_STATES = 4;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int PLAY = 2;
	public static final int GAMEOVER = 3;

	public GameStateManager() {

		JukeBox.init();

		mute = false;
		paused = false;
		listObserver = new ArrayList<Observer>();
		pauseState = new PauseState(this);

		setState(INTRO);

	}

	public void setState(int i) {
		gameStates = GameStateFactory.creatGameState(i, this);
		notifyObserver();
	}

	public void unloadState(int i) {
		gameStates = null;
	}

	public void setPaused(boolean b) {
		paused = b;
	}

	@Override
	public void update() {
		handleInput();
		if (paused) {
			pauseState.update();
		} else if (gameStates != null) {
			gameStates.update();
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if (paused) {
			pauseState.draw(g);
		} else if (gameStates != null) {
			gameStates.draw(g);
		}
	}

	public void handleInput() {
		if (Keys.isPressed(Keys.MUTE)) {
			mute = !mute;
			notifyObserver();
			System.out.println("Mute :"+ mute);
		}
	}

	public boolean getMute() {
		return mute;
	}
public void setMute(boolean ismute) {
	this.mute = ismute;
	notifyObserver();
}
	@Override
	public void add(Observer o) {
		if (!listObserver.contains(o))
			listObserver.add(o);

	}

	@Override
	public void remove(Observer o) {
		if (listObserver.contains(o))
			listObserver.remove(o);

	}

	@Override
	public void notifyObserver() {
		for (Observer observer : listObserver) {
			observer.updateObserver(mute);
		}

	}
}
