package juego;
import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Image;

public class Pantallainicio extends Background {
	
	public Pantallainicio(double x,double y,Entorno e) {
		super(x,y,e);
		this.image= Herramientas.cargarImagen("pantalla.png");
	}
	
}
