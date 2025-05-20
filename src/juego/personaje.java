package juego;
import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;
public class personaje {
	double x,y;
	Image imagenderecha;
	Image imagenizquierda;
	double escala;
	boolean direccion;
	public personaje(double x, double y) {
		this.x=x;
		this.y=y;
		this.imagenderecha= Herramientas.cargarImagen("magoderecha.png");
		this.imagenizquierda=Herramientas.cargarImagen("magoizquierda.png");
		this.escala=0.05;
		this.direccion=false;
	}
	public void dibujar(Entorno e) {
		if (direccion) {
			e.dibujarImagen(this.imagenderecha, this.x, this.y,0,this.escala);
		}
		else {
			e.dibujarImagen(this.imagenizquierda, this.x, this.y,0,this.escala);
		}
	}
	public void mover(double vertical,double horizontal,Entorno e) {
		this.x+=horizontal;
		this.y+=vertical;
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
		if (horizontal>0) {
			this.direccion=true;
		}
		else {
			this.direccion=false;
		}
	}
}
