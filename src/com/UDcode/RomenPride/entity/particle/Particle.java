package com.UDcode.RomenPride.entity.particle;

import com.UDcode.RomenPride.Gfx.Screen;
import com.UDcode.RomenPride.Gfx.Sprite;
import com.UDcode.RomenPride.entity.Entity;

public class Particle extends Entity{
	private Sprite sprite;
	
	
	private int life;
	private int time = 0;
	protected double xa, ya,za;
	protected double xx,yy,zz;
	
	public Particle (int x, int y, int life){
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life +( random.nextInt(30)+110);
		sprite = Sprite.particle_normal;
		
		this.xa = random.nextGaussian();
		
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat()+2.0;
	}
	
	
	public void update(){
		time++;
		if(time >= 7400) time = 0;
		if(time>life)remove();
		//setting the "floor" by
		za -= 0.1;
		if(zz < 0){
			zz =0;
			za *= -0.44;
			xa*= 0.5;
			ya*= 0.5+0.2;
			
		}
		move(xx + xa, (yy + ya) + (zz + za));	
		
		}
	
	private void move(double x, double y) {
		if(collision (x, y)){
			this.xa *= - 0.5;
			this.ya *= - 0.5;
			this.za *= - 0.5;
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	
	}
	public  boolean collision(double x, double  y ){
		boolean solid = false;
		for(int c = 0; c < 4; c++ ){
			double  xt = (x - c % 2 * 16  )/ 16;
			double yt = (y - c / 2 * 16 + 3  ) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (c % 2 == 0) ix = (int) Math.floor(xt);
			if (c / 2 == 0) iy = (int) Math.floor(yt);
			if (level.getTile( ix, iy).solid()) solid = true; 
		}
		return solid;
	}


	public void render(Screen screen){
		screen.renderSprite((int)xx+1, (int)yy + 2 -(int) zz, sprite, true);
		
	}
	
}
