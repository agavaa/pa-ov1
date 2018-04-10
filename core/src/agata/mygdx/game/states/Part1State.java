package agata.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import agata.mygdx.game.sprites.Helicopter;

/**
 * Created by agava on 23.01.2018.
 */

public class Part1State extends State {

    private Helicopter helicopter;
    public Part1State(GameStateManager gsm) {
        super(gsm);
        helicopter = new Helicopter(50, 50);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new Part2State(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        helicopter.update(dt);
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(helicopter.getHelicopter(), helicopter.getPosition().x, helicopter.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        helicopter.dispose();
    }
}
