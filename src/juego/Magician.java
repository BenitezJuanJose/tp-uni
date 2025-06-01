package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Magician extends Character {
	
	Image imageRight,imageLeft;
	boolean validAreaAttack;
	
	public Magician(double x, double y, Entorno e){
		super(x,y,e);
		this.size = 0.05;
		this.speed = 1;
		this.areaAttack = 100 ;
		this.rangeAttack = 200;
		this.imageRight= Herramientas.cargarImagen("magoderecha.png");
		this.imageLeft=Herramientas.cargarImagen("magoizquierda.png");
	}
	
	public void dibujar() {
		if (this.direction) {
			//this.e.dibujarCirculo(this.x, this.y, this.rangeAttack, Color.LIGHT_GRAY);
			this.e.dibujarImagen(this.imageRight, this.x, this.y,0,this.size);
		}
		else {
			//this.e.dibujarCirculo(this.x, this.y, this.rangeAttack, Color.LIGHT_GRAY);
			this.e.dibujarImagen(this.imageLeft, this.x, this.y,0,this.size);
		}
	}
	
	public boolean attackEnemy(Bat enemy){
		boolean colideX = false;
		boolean colideY = false;
		boolean validateAreaAttackX =(this.x - this.e.mouseX() ) <= this.rangeAttack &&  -(this.x - this.e.mouseX() ) <= this.rangeAttack;
		boolean validateAreaAttackY =(this.y - this.e.mouseY() ) <= this.rangeAttack &&  -(this.y - this.e.mouseY() ) <= this.rangeAttack;
		
		validAreaAttack = validateAreaAttackX && validateAreaAttackY; 
		
		if(e.sePresionoBoton(e.BOTON_IZQUIERDO) && enemy != null && validAreaAttack) {
			 colideX = enemy.x - this.areaAttack < this.e.mouseX() && enemy.x + this.areaAttack > this.e.mouseX();
			 colideY = enemy.y - this.areaAttack < this.e.mouseY() && enemy.y + this.areaAttack > this.e.mouseY();
			e.dibujarCirculo(this.e.mouseX(), this.e.mouseY(), this.areaAttack, Color.yellow);
			this.incrementXp();
		}
		
		return colideX && colideY;
	}
	
	
}
