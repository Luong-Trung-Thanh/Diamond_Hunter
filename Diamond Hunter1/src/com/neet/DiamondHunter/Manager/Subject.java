package com.neet.DiamondHunter.Manager;

import com.neet.DiamondHunter.GameState.Observer;

public interface Subject {
public void add(Observer o);
public void remove(Observer o);
public void notifyObserver();
}
