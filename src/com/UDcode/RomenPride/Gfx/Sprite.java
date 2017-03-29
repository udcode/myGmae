package com.UDcode.RomenPride.Gfx;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	private int width, height;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16 , 0 , 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x2b9cef);
	public static Sprite rock = new Sprite(16 , 1 , 0, SpriteSheet.tiles);
	public static Sprite dirt = new Sprite(16 , 2 , 0, SpriteSheet.tiles);
	
	
	//spawn level sprite
	public static Sprite spawn_grass = new Sprite(16,0,0,SpriteSheet.spawn_level);
	public static Sprite spawn_grass2 = new Sprite(16,1,0,SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16,2,0,SpriteSheet.spawn_level);
	public static Sprite spawn_wall = new Sprite(16,0,1,SpriteSheet.spawn_level);
	public static Sprite spawn_floor = new Sprite(16,1,1,SpriteSheet.spawn_level);
	public static Sprite spawn_dirt = new Sprite(16,2,1,SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16,0,2,SpriteSheet.spawn_level);
	public static Sprite spawn_tree = new Sprite(16,2,2,SpriteSheet.spawn_level);
	
	
	//player
	//up
	public static Sprite player_u = new Sprite(32,0,5,SpriteSheet.tiles);
	public static Sprite player_u2 = new Sprite(32,0,6,SpriteSheet.tiles);
	public static Sprite player_u3 = new Sprite(32,0,7,SpriteSheet.tiles);
	
	//down
	public static Sprite player_d = new Sprite(32,1,5,SpriteSheet.tiles);
	public static Sprite player_d2 = new Sprite(32,1,6,SpriteSheet.tiles);
	public static Sprite player_d3 = new Sprite(32,1,7,SpriteSheet.tiles);
	
	//left and right
	public static Sprite player_side = new Sprite(32,2,5,SpriteSheet.tiles);
	public static Sprite player_side2 = new Sprite(32,2,6,SpriteSheet.tiles);
	public static Sprite player_side3 = new Sprite(32,2,7,SpriteSheet.tiles);
	
	//diagonal
	public static Sprite player_diagonal = new Sprite(32,3,5,SpriteSheet.tiles);
	
	public static Sprite wizard_projectile = new Sprite(16,0,0,SpriteSheet.projectile_wizard);
	
	//particles
	public static Sprite particle_normal = new Sprite(2 , 0x000000);
	
	//animated sprite constroctor
	protected Sprite(SpriteSheet sheet,int width,int height){
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	
	}
	
	
	//first constructor(main sprites)
	public Sprite(int size, int x , int y ,SpriteSheet sheet){
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int [SIZE * SIZE];
		this.x = x * size;
		this.y = y* size;
		this.sheet = sheet;
		load();
	}
	//second constructor
	public Sprite(int width, int height , int colour){
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColour(colour);
	}
	//third constructor
	public Sprite(int size , int colour){
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	private void setColour(int colour) {
		for (int i =0; i < width * height; i++){
			pixels [i] = colour;
		}
	}
		public int getWidth(){
			return width;
		}
		
		public int getHeight(){
			return height;
		}
	
	private void load(){
		for(int y = 0; y< SIZE; y++){
			for(int x = 0; x< SIZE; x++){
				pixels[x+y*SIZE]=sheet.pixels[(x + this.x)+ (y + this.y) *sheet.SIZE];
			}
	}

}
}