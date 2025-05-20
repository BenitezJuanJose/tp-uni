package juego;
import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Image;;
public class enemigos {
	double x, y;
	Image imagen;
	double escala;
	double velocidad;
	public enemigos(double x, double y) {
		this.x=x;
		this.y=y;
		this.imagen= Herramientas.cargarImagen("murcielago.gif");
		this.escala= 0.40;
		this.velocidad=2;
	}
	public void dibujar(Entorno e) {
		e.dibujarImagen(this.imagen, this.x, this.y, 0,this.escala);
	}
	public void mover(double vertical,double horizontal,Entorno e) {
		this.x+=vertical*this.velocidad;
		this.y+=horizontal*this.velocidad;
		if (this.x<0) {
			this.x=0;
		}
		if (this.x> e.ancho()) {
			this.x= e.ancho();
			
		}
		if (this.y<0) {
			this.y=0;
		}
		if (this.y>e.alto()) {
			this.y= e.alto();
		}
	}

}
