package agata.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import agata.mygdx.game.GdxGameDemo;

/**
 * Created by agava on 22.01.2018.
 */

public class Helicopter {
    private Vector3 position;
    private Vector3 velocity;
    private Texture helicopter;
    private Sprite helicopterSprite;
    private int speed;
    private boolean up = false;
    private boolean right= true;

    public Helicopter(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        speed = 150;
        helicopter = new Texture("attackhelicopter.PNG");
        helicopterSprite = new Sprite(helicopter);
    }

    public void update(float dt) {

            if (right) {
                velocity.add(-speed, 0, 0);
                velocity.scl(dt);
                position.add(velocity.x, 0, 0);
                if (position.x <= 0) {
                    flipHelicopter();
                    right = false;
                }
            }
            if (!right) {
                velocity.add(speed, 0, 0);
                velocity.scl(dt);
                position.add(velocity.x, 0, 0);
                if (position.x + helicopterSprite.getWidth() >= GdxGameDemo.WIDTH) {
                    unflipHelicopter();
                    right = true;
                }

            }
            if (up) {
                velocity.add(0, speed, 0);
                velocity.scl(dt);
                position.add(0, velocity.y, 0);
                if (position.y + helicopterSprite.getHeight()>= GdxGameDemo.HEIGHT){
                    up = false;
                }
            }
            if (!up) {
                velocity.add(0, -speed, 0);
                velocity.scl(dt);
                position.add(0, velocity.y, 0);
                if (position.y <= 0){
                    up = true;
                }
            }
    }

    public void flipHelicopter(){
            helicopterSprite.flip(true,false);
            helicopterSprite.setFlip(true,false);
    }

    public   void unflipHelicopter(){
            helicopterSprite.flip(false,false);
            helicopterSprite.setFlip(false,false);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Sprite getHelicopter() {
        return helicopterSprite;
    }

    public void dispose(){
        helicopter.dispose();
    }
}
