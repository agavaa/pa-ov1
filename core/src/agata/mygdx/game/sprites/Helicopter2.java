package agata.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by agava on 23.01.2018.
 */

public class Helicopter2 {
    private Texture helicopter2;
    private Vector3 position;
    private Vector3 velocity;

    public Helicopter2(int x, int y){
        helicopter2 = new Texture("attackhelicopter.PNG");
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
    }

    public void update(float dt){
        /*if (position.y>=300){
            velocity.add(0, -150, 0);
            velocity.scl(dt);
            position.add(0, velocity.y, 0);
        }
        if (position.y<=50){
            velocity.add(0, 150, 0);
            velocity.scl(dt);
            position.add(0, velocity.y, 0);
        }*/
    }



    public Texture getHelicopter2() {
        return helicopter2;
    }

    public Vector3 getPosition() {
        return position;
    }
    public void setPosition(int x, int y){
        position.x = x;
        position.y = y;
    }

    public void dispose(){
        helicopter2.dispose();
    }
}
