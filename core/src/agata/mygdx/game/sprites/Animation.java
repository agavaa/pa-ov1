package agata.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by agava on 23.01.2018.
 */

public class Animation {
    private Array<Sprite> frames;
    private  float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(Sprite frame1, Sprite frame2, Sprite frame3, Sprite frame4, float cycleTime){
        frames = new Array<Sprite>();
        frames.add(frame1,frame2,frame3,frame4);
        frameCount = 4;
        maxFrameTime = cycleTime/frameCount;
        frame = 0;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if (frame>= frameCount){
            frame = 0;
        }
    }

    public void flipFrames(){
        for (Sprite frame: frames) {
            frame.flip(true,false);
            frame.setFlip(true,false);
        }
    }
    public void unflipFrames(){
        for (Sprite frame: frames) {
            frame.flip(false,false);
            frame.setFlip(false,false);
        }
    }

    public Sprite getFrame(){
        return frames.get(frame);
    }
}
