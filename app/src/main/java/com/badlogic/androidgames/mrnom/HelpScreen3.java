package com.badlogic.androidgames.mrnom;

import java.util.List;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Screen;

public class HelpScreen3 extends Screen {
	public HelpScreen3(Game game){
		super(game);
	}
	
	@Override
	public void update(float deltaTime){
		List < TouchEvent > touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();//Used to clear buffer
		
		int len = touchEvents.size();
		//If the proper button is pressed - the help screen will transition
		for (int i = 0; i < len ; i++){
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP){
				if(event.x > 256 && event.y > 416){
					game.setScreen(new MainMenuScreen(game));
					if(Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
			}
		}
	}
	
	//Draw proper graphics
	@Override
	public void present(float deltaTime){
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		g.drawPixmap(Assets.help3, 64, 100);
		g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
	}
	
	@Override
	public void pause(){
		
	}
	
	@Override
	public void resume(){
		
	}
	
	@Override
	public void dispose(){
		
	}
}
