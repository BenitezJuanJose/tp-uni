package juego;


import java.awt.Color;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private personaje mago;
	private enemigos[] murcielago;
	private Pantallainicio menu;
	private boolean inicio;
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 1000, 800);
		this.mago= new personaje(450,400);
		murcielago= new enemigos[20];
		this.menu= new Pantallainicio(500,400);
		inicio=true;
		// Inicializar lo que haga falta para el juego
		// ...
		for (int i=0;i<murcielago.length;i++) {
			double x;
			double y= Math.random()*800;
			if(i%2==0) {
				x=Math.random()*0;
			}else {
				x=500+Math.random()*1000;
			}
			murcielago[i]=new enemigos (x,y);
		}
		// Inicia el juego!
		this.entorno.iniciar();
	}
	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		if(inicio) {
			menu.dibujar(entorno);
			if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)) {
				inicio=false;
		}
		return;
		}
		
		mago.dibujar(entorno);
		if(entorno.estaPresionada(entorno.TECLA_ARRIBA)){
			this.mago.mover(-1, 0,this.entorno);
		}
		if (entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			this.mago.mover(1, 0,this.entorno);
		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			this.mago.mover(0, 1,this.entorno);
		}
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			this.mago.mover(0, -1,this.entorno);
			
		}
		for(int i=0; i<this.murcielago.length;i++) {
		     murcielago[i].dibujar(entorno);
			boolean dx=murcielago[i].x>mago.x;
			boolean dy=murcielago[i].y>mago.y;
			double Dx= dx?-1:1;
			double Dy= dy?-1:1;
			if (Math.random()>0.3) {
				this.murcielago[i].mover(Dx*Math.random(),Dy*Math.random(), entorno);
		}
		else {
			this.murcielago[i].mover(0.5, 0.1, entorno);
		}
	}
}		

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
