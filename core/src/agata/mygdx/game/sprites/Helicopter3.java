package agata.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import agata.mygdx.game.GdxGameDemo;

/**
 * Created by agava on 23.01.2018.
 */

public class Helicopter3 {
        private Vector3 position;
        private Vector3 velocity;
        private Texture helicopter1;
        private Texture helicopter2;
        private Texture helicopter3;
        private Texture helicopter4;
        private Animation helicopterAnimation;
        private int speed;
        private boolean up;
        private boolean right;
        private Rectangle bounds;

        public Helicopter3(int x, int y){
            position = new Vector3(x, y, 0);
            velocity = new Vector3(0,0,0);
            right = MathUtils.randomBoolean();
            up = MathUtils.randomBoolean();
            speed = MathUtils.random(50,400); //random speed
            helicopter1 = new Texture("heli1.png");
            helicopter2 = new Texture("heli2.png");
            helicopter3 = new Texture("heli3.png");
            helicopter4 = new Texture("heli4.png");
            Sprite heli1 = new Sprite(helicopter1);
            Sprite heli2 = new Sprite(helicopter2);
            Sprite heli3 = new Sprite(helicopter3);
            Sprite heli4 = new Sprite(helicopter4);
            helicopterAnimation = new Animation(heli1,heli2,heli3,heli4,0.1f);
            bounds = new Rectangle(position.x, position.y, helicopterAnimation.getFrame().getWidth(), helicopterAnimation.getFrame().getHeight());
        }

        public void update(float dt) {
            helicopterAnimation.update(dt);
            bounds.setPosition(position.x,position.y);

            if (right) {
                velocity.add(-speed, 0, 0);
                velocity.scl(dt);
                position.add(velocity.x, 0, 0);
                if (position.x <= 0) {
                    helicopterAnimation.flipFrames();
                    right = false;
                }
            }
            if (!right) {
                velocity.add(speed, 0, 0);
                velocity.scl(dt);
                position.add(velocity.x, 0, 0);
                if (position.x + helicopterAnimation.getFrame().getWidth() >= GdxGameDemo.WIDTH) {
                    helicopterAnimation.unflipFrames();
                    right = true;
                }

            }
            if (up) {
                velocity.add(0, speed, 0);
                velocity.scl(dt);
                position.add(0, velocity.y, 0);
                if (position.y + helicopterAnimation.getFrame().getHeight()>= GdxGameDemo.HEIGHT){
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

        public void handleCollision(Rectangle otherHelicopter){
           if (collides(otherHelicopter)){
            Rectangle intersection = new Rectangle();
            Intersector.intersectRectangles(bounds, otherHelicopter, intersection);

            if(intersection.x >bounds.x){ //right
                System.out.println("collision right");
                helicopterAnimation.unflipFrames();
                right = true;
            }
            if(intersection.y >bounds.y){ //top
                   System.out.println("collision top");
                  up = false;
            }
            if(intersection.x + intersection.width < bounds.x + bounds.width){ //left
                   System.out.println("collision left");
                   helicopterAnimation.flipFrames();
                   right=false;
            }
            if(intersection.y + intersection.height < bounds.y+bounds.height){ //bottom
                   System.out.println("collision bottom");
                   up = true;
            }
           }
        }

       public boolean collides (Rectangle otherHelicopter){
           return otherHelicopter.overlaps(bounds);
       }

        public Vector3 getPosition() {
           return position;
        }

        public Sprite getHelicopter() {
           return helicopterAnimation.getFrame();
        }

        public Rectangle getBounds(){
           return bounds;
       }

        public void dispose(){
            helicopter1.dispose();
            helicopter2.dispose();
            helicopter3.dispose();
            helicopter4.dispose();
        }

}
