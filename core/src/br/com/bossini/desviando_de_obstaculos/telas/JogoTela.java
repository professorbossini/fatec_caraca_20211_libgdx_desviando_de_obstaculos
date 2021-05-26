package br.com.bossini.desviando_de_obstaculos.telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import br.com.bossini.desviando_de_obstaculos.config.JogoConfig;
import br.com.bossini.desviando_de_obstaculos.entidade.Personagem;
import br.com.bossini.desviando_de_obstaculos.utils.Utils;
import sun.nio.ch.Util;

//JogoTela É-UM Screen
public class JogoTela implements Screen {
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer shapeRenderer;
    private Personagem personagem;
    //callback
    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(JogoConfig.WORLD_WIDTH, JogoConfig.WORLD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();
        personagem = new Personagem();
        float xInicialDoPersonagem = JogoConfig.WORLD_WIDTH / 2;
        float yInicialDoPersonagem = 1;
        personagem.setPosicao(xInicialDoPersonagem, yInicialDoPersonagem);
    }

    private void atualizarPersonagem (){
        personagem.update();
        Gdx.app.debug("X: ", Float.toString(personagem.getX()));
        Gdx.app.debug("Y: ", Float.toString(personagem.getY()));
    }

    private void atualizarMundo(float delta){
        atualizarPersonagem();

    }

    private void desenharPersonagem(){
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        personagem.desenhar(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void hide() {
        dispose();
    }
    @Override
    public void render(float delta) {
        atualizarMundo(delta);
        Utils.limparTela();
        desenharPersonagem();
        Utils.desenharGrid(viewport, shapeRenderer);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        Utils.exibirPixelsPorUnidadeDeMundo(viewport);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
