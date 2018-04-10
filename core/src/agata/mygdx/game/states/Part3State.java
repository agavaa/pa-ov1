package agata.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import agata.mygdx.game.sprites.Helicopter3;

/**
 * Created by agava on 23.01.2018.
 */

public class Part3State extends State {
    private Helicopter3 helicopter3;
    private Helicopter3 helicopter4;
    private Helicopter3 helicopter5;

    public Part3State(GameStateManager gsm) {
        super(gsm);
        helicopter3 = new Helicopter3(50,120);
        helicopter4 = new Helicopter3(100, 500);
        helicopter5 = new Helicopter3(250, 300);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new Part1State(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {

        helicopter3.handleCollision(helicopter4.getBounds());
        helicopter4.handleCollision(helicopter3.getBounds());
        helicopter5.handleCollision(helicopter4.getBounds());
        helicopter5.handleCollision(helicopter3.getBounds());
        helicopter3.handleCollision(helicopter5.getBounds());
        helicopter4.handleCollision(helicopter5.getBounds());
        helicopter4.update(dt);
        helicopter3.update(dt);
        helicopter5.update(dt);
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(helicopter3.getHelicopter(), helicopter3.getPosition().x, helicopter3.getPosition().y);
        sb.draw(helicopter4.getHelicopter(), helicopter4.getPosition().x, helicopter4.getPosition().y);
        sb.draw(helicopter5.getHelicopter(), helicopter5.getPosition().x, helicopter5.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        helicopter3.dispose();
        helicopter4.dispose();
        helicopter5.dispose();
    }
}
