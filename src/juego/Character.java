package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;


public class Character {
	Entorno e;
	int hp,xp,level;
	double x, y,size,speed, areaAttack, rangeAttack;
	Image image;
	boolean direction;
	
	Character (double x, double y , Entorno e){
		this.x = x;
		this.y = y;
		this.e = e;
		this.hp = 100;
		this.xp=0;
		this.level=1;
		this.rangeAttack = 0;
		this.direction = false;
	}
	
	
	public void dibujar() {
		this.e.dibujarImagen(this.image, this.x, this.y, 0,this.size);
	}
	
	public void incrementXp() {
		this.xp++;
		this.levelUp();
		
	}
	
	public void levelUp() {
		if(this.xp > 10) {
			this.level++;
			this.xp = 0;
		}
	}
	
	public void mover(double vertical,double horizontal) {
		this.direction = horizontal > 0;
		
		this.x += vertical*this.speed;
		this.y += horizontal*this.speed;
		
		
		if (this.x < 0) {
			this.x = 0;
		}
		if (this.x > this.e.ancho()-230) {
			this.x = this.e.ancho()-230;
			
		}
		if (this.y < 0) {
			this.y = 0;
		}
		if (this.y > this.e.alto()-50) {
			this.y = this.e.alto()-50;
		}
		
		
	
	}
}
