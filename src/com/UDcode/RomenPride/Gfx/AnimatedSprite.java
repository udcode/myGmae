package com.UDcode.RomenPride.Gfx;

public class AnimatedSprite extends Sprite{
	
	private int length=-1, rate =5,frame =0;
	private Sprite sprite;
	public AnimatedSprite(SpriteSheet sheet, int width, int height,int length) {
		super(sheet, width, height);
		this.length = length;
		
		
	}
	
	public void update(){
		if(frame > length)frame = 0;
		else frame++;
	}
	public Sprite getSprite(){
		return sprite;
	}
	
	public void setFrameRate(int frames){
		rate = frames;
	}
}
