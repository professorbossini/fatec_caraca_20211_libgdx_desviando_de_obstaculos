package br.com.bossini.desviando_de_obstaculos;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import br.com.bossini.desviando_de_obstaculos.telas.JogoTela;

public class DesviandoDeObstaculosGame extends Game {

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		setScreen(new JogoTela());
	}


}
