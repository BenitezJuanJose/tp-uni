package juego;

import entorno.Entorno;
import entorno.Herramientas;

public class Bat extends Character {
	
	public Bat(double x , double y , Entorno e){
			super (x,y,e);
			this.image= Herramientas.cargarImagen("bat.gif");
			this.size= 0.1;
			this.speed=2;
	}
	
	public void followCharacter(Magician character) {
		
		boolean dx=this.x>character.x;
		boolean dy=this.y>character.y;
		double Dx= dx?-1:1;
		double Dy= dy?-1:1;
		
		this.mover(Dx, Dy);
	}
	
	
}
