package juego;

import entorno.Entorno;
import entorno.Herramientas;

public class Scenary extends Background{
	
	Scenary(double x, double y, Entorno e) {
		super(x, y, e);
		this.size=1.5;
		this.image = Herramientas.cargarImagen("fondo.png");
	}
	
	public void switchScenary(int surge){
		this.image = Herramientas.cargarImagen("fondo.png");
		if(surge%2==0) {
			this.image = Herramientas.cargarImagen("fondo2.jpg");
		}
		this.dibujar();
	}
	
}
