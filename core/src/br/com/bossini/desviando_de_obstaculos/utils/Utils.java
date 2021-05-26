package br.com.bossini.desviando_de_obstaculos.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Locale;

public class Utils {
    private static final Logger logger = new Logger (Utils.class.getName(), Logger.DEBUG);
    private static final int TAMANHO_PADRAO_CELULA_GRID = 1;

    public static void desenharGrid (Viewport viewport, ShapeRenderer shapeRenderer){
        desenharGrid(viewport, shapeRenderer, TAMANHO_PADRAO_CELULA_GRID);
    }

    public static void desenharGrid (Viewport viewport, ShapeRenderer shapeRenderer, int tamanhoCelula){
        int worldWidth = (int) viewport.getWorldWidth();
        int worldHeight = (int) viewport.getWorldHeight();
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
        Color corOriginal = shapeRenderer.getColor().cpy();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        //verticais
        for (int x = -2 * worldWidth; x < 2 * worldWidth; x += tamanhoCelula){
            shapeRenderer.line(x, -2 * worldWidth, x, 2 * worldHeight);
        }

        //horizontais
        for (int y = -2 * worldHeight; y < 2 * worldHeight; y += tamanhoCelula){
            shapeRenderer.line(-2 * worldWidth, y , 2 * worldWidth, y);
        }

        shapeRenderer.setColor(Color.RED);
        //centrais
        shapeRenderer.line(0, -2 * worldHeight, 0, 2 * worldHeight);
        shapeRenderer.line(-2 * worldWidth, 0, 2 * worldWidth, 0);

        //extremos
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.line(0, worldHeight, worldWidth, worldHeight);
        shapeRenderer.line(worldWidth, 0, worldWidth, worldHeight);

        shapeRenderer.end();

        shapeRenderer.setColor(corOriginal);
    }

    //múltiplas formas
    //sobrecarga de métodos é um tipo de polimorfismo estático (em tempo de compilação, ou seja, feito pelo compilador)
    public static void limparTela(){
       limparTela(Color.BLACK);
    }

    public static void exibirPixelsPorUnidadeDeMundo (Viewport viewport){
        logger.debug(String.format(
                Locale.getDefault(),
                "PixelPorUnidadeDeMundo(x): %f, PixelPorUnidadeDeMundo(y): %f",
                viewport.getScreenWidth() / viewport.getWorldWidth(),
                viewport.getScreenHeight() / viewport.getWorldHeight()
        ));
    }
    public static void limparTela (Color color){
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }


}
