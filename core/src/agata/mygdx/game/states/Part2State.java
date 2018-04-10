package agata.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import agata.mygdx.game.GdxGameDemo;
import agata.mygdx.game.sprites.Helicopter2;

/**
 * Created by agava on 23.01.2018.
 */

public class Part2State extends State {
    private Helicopter2 helicopter2;
    private BitmapFont coordinates;
    private int mousePosX;
    private int mousePosY;
    public Part2State(GameStateManager gsm) {
        super(gsm);
        helicopter2 = new Helicopter2(100, 150);
        coordinates = new BitmapFont();
    }

    @Override
    public void handleInput() {
        mousePosX = Gdx.input.getX();
        mousePosY = -Gdx.input.getY()+GdxGameDemo.HEIGHT;
        helicopter2.setPosition(mousePosX,mousePosY);

        if (Gdx.input.justTouched()){
            System.out.println("Click");
            gsm.set(new Part3State(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        helicopter2.update(dt);
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        coordinates.draw(sb, "x: " + helicopter2.getPosition().x +" y: " + helicopter2.getPosition().y, 50,GdxGameDemo.HEIGHT-100);
        sb.draw(helicopter2.getHelicopter2(), helicopter2.getPosition().x, helicopter2.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        helicopter2.dispose();
        coordinates.dispose();
    }
}
