package com.UDcode.RomenPride.Gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public final int SIZE;
	public final int WIDTH , HEIGHT;
	public int [] pixels;
	public Sprite [] sprites;
	public static SpriteSheet tiles = new SpriteSheet("/textures/sheets/spritsheet256.png", 256);
	
	public static SpriteSheet spawn_level = new SpriteSheet("/textures/sheets/spwan_level.png",48 );
	public static SpriteSheet projectile_wizard= new SpriteSheet("/textures/sheets/projectiles/wizard.png",48 );
	public static SpriteSheet player= new SpriteSheet("/textures/sheets/playersheet.png", 128,96);
	public static SpriteSheet player_down1 = new SpriteSheet(player , 0, 0, 4,3,32);
	
	public SpriteSheet(SpriteSheet sheet,int x, int y, int width,int height,int spriteSize){
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		if(width == height) SIZE = width;
		else SIZE = -1;
		WIDTH = w;
		HEIGHT = h;
		pixels = new int[w * h];
		for(int i = 0; i< h;i++){
			int yp = yy + i ;
			for(int j = 0; j< w;j++){
				int xp = xx + j;
				 
		
				pixels [j + i * w] = sheet.pixels[xp + yp * sheet.WIDTH];
			
			}
		}
	}
//		for(int y0 =0;y0<h;y0++){
//			for(int x0 = 0;x0<w;x0++){
//				Sprite sprite = new Sprite();
//			}
//		})
//	}
	
	
	public SpriteSheet(String path, int width , int height){
		this.path = path;
		SIZE = -1;
		WIDTH = width;
		HEIGHT = height;
		pixels = new int [WIDTH * HEIGHT];
		load();
	}
	
	public SpriteSheet(String path, int size){
		this.path = path;
		SIZE =size;
		WIDTH  = size;
		HEIGHT  = size;
		pixels = new int[SIZE * SIZE]; 
		load();
		
	}
//public  Sprite[] getSprite(){
	
		
//	}
	private void load(){
		try{
		BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
		int w = image.getWidth();
		int h = image.getHeight();
		image.getRGB(0, 0, w, h, pixels, 0, w);
	
	} catch (IOException e){
		e.printStackTrace();
	}
	}
}
