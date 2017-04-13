package model;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import view.ValidacionWindow;

public class Ejecutable extends Application{
	
	public static void main(String[] args) {
		new Ejecutable().start();

	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new ValidacionWindow(this);
	}
}
