package br.com.bossini.desviando_de_obstaculos.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import br.com.bossini.desviando_de_obstaculos.DesviandoDeObstaculosGame;
import br.com.bossini.desviando_de_obstaculos.config.JogoConfig;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int) JogoConfig.WIDTH;
		config.height = (int) JogoConfig.HEIGHT;
		new LwjglApplication(new DesviandoDeObstaculosGame(), config);
	}
}
