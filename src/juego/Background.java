package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Image;

public class Background {
	double x,y,size;
	Image image;
	Entorno e;
	Background(double x, double y, Entorno e){
		this.x = x;
		this.y = y;
		this.e = e;
		this.size = 1;
	}
	public void dibujar() {
		e.dibujarImagen(this.image, this.x, this.y, 0, this.size);
	}
}
