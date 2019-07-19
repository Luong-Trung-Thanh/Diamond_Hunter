// Blueprint for all GameState subclasses.
// Has a reference to the GameStateManager
// along with the four methods that must
// be overridden.

package com.neet.DiamondHunter.GameState;

import java.awt.Graphics2D;

import com.neet.DiamondHunter.Manager.GameStateManager;
import com.neet.DiamondHunter.Manager.Subject;

public abstract class GameState implements ITempCalcModel,Observer{
	protected Subject subject;
	protected boolean isMute;
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
		this.subject = gsm;
		isMute = false;
		subject.add(this);
	}
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}



	public abstract void init();
	@Override
	public abstract void update();
	@Override
	public abstract void draw(Graphics2D g);
	public abstract void handleInput();
	@Override
	public void updateObserver(boolean isMute) {
		this.isMute = isMute;
		
	}
}
