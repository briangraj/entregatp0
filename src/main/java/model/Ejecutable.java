package model;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import view.ValidacionWindow;

/*token
eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho
*/

public class Ejecutable extends Application{
	
	public static void main(String[] args) {
		new Ejecutable().start();

	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new ValidacionWindow(this);
	}
}
