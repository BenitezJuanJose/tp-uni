package juego;
import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Image;

public class Pantallainicio {
	double x,y;
	Image menu;
	public Pantallainicio(double x,double y) {
		this.x=x;
		this.y=y;
		this.menu= Herramientas.cargarImagen("pantalla.png");
	}
	public void dibujar(Entorno e) {
		e.dibujarImagen(this.menu, this.x, this.y, 0, 1.1);
	}
}
