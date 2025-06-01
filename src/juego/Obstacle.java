package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstacle {
	 double x,y,size;
	 Entorno e;
	 Image image;
	 
	 Obstacle(double x, double y, Entorno e){
		 this.x = x+50;
		 this.y = y+100;
		 this.e = e;
		 this.size = 0.5;
		 this.image = Herramientas.cargarImagen("roca.jpg") ;
	 }
	 
	 public void dibujar(){
		 this.e.dibujarImagen(this.image, this.x, this.y, 0,this.size);
	 }
	 public boolean validateExternalColition(Magician character) {
		 boolean colideX = this.x - 1 < character.x && this.x + 1 > character.x;
		 boolean colideY = this.y - 1 < character.y && this.y + 1 > character.y;
		 
		 return colideX && colideY;
	 }
}
