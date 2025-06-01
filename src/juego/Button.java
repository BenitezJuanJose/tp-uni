package juego;

import java.awt.Color;

import entorno.Entorno;

public class Button {
	Entorno e;
	double x, y;
	boolean clicked;
	Button(double x , double y ,Entorno e){
		this.e = e;
		this.x = x;
		this.y = y;
		this.clicked = false;
		
	}
	
	
	public void dibujar (){
		this.e.dibujarRectangulo(this.x, this.y, 100, 30,0 , Color.magenta);
		if(this.clicked) {
			this.e.dibujarRectangulo(this.x, this.y, 100, 30,0 , Color.yellow);
		}
		
	}
	
	public boolean cords () {
		boolean cordsX = this.x + 50 > this.e.mouseX() && this.x - 50 < this.e.mouseX(); 
		boolean cordsY = this.y + 15 > this.e.mouseY() && this.y - 15 < this.e.mouseY();
		return cordsX && cordsY;
	}
	
	public void click(){
		this.clicked = !this.clicked;
	}
	public boolean state() {
		return this.clicked;
	}
}