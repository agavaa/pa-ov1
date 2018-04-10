package agata.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import agata.mygdx.game.GdxGameDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GdxGameDemo.WIDTH;
		config.height = GdxGameDemo.HEIGHT;
		config.title = GdxGameDemo.TITLE;
		new LwjglApplication(new GdxGameDemo(), config);
	}
}
