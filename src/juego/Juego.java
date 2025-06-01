package juego;


import java.awt.Color;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Magician mago;
	private Bat[] bats;
	private Pantallainicio menu;
	private Obstacle[] rocs;
	private Scenary background;
	private boolean start;
	private int surge;
	private Menu asideMenu;
	private double areaAttack;
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 1000, 800);
		this.mago = new Magician(450,400,this.entorno);
		this.bats = new Bat[20];
		this.rocs =  new Obstacle[5];
		this.menu = new Pantallainicio(500,400,this.entorno);
		this.start =true;
		this.background = new Scenary(500,400,this.entorno);
		this.surge = 1;
		this.asideMenu = new Menu(this.entorno);
		
		createBatsEnemies();
		createObstacles();
		
		// Inicia el juego!
		this.entorno.iniciar();
	}
	
	
	public Obstacle[] createObstacles() {
		for (int i=0;i<this.rocs.length;i++) {
			double x;
			double y= Math.random()*800;
			if(i%2==0) {
				x=Math.random()*0;
			}else {
				x=500+Math.random()*1000;
			}
			this.rocs[i] = new Obstacle(x,y,this.entorno);
		}
		
		return this.rocs;
	}
	public void createObstacleToMap() {
		for(Obstacle roc : this.rocs) {
			roc.dibujar();
		}
	}	
	

 	public Bat[] createBatsEnemies() {
		for (int i=0;i<this.bats.length;i++) {
			double x;
			double y= Math.random()*800;
			if(i%2==0) {
				x=Math.random()*0;
			}else {
				x=500+Math.random()*1000;
			}
			this.bats[i] = new Bat (x,y,this.entorno);
		}
		return this.bats;
	}
 	
	public boolean verifyEnemyArrayIsAllNull() {
		boolean res = true;
		for(Bat enemy : this.bats) {
			if(enemy != null) res = false;
		}
		return res;
	}
	

	public void moveCharacter() {
		if(this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA) ){
			this.mago.mover( 0,-1);
		}
		if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)) {
			this.mago.mover(0,1);
		}
		if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) ) {
			this.mago.mover(1, 0);
		}
		if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) ) {
			this.mago.mover(-1, 0);
		}
	}
	public boolean verifyColide(Bat enemy) {
		boolean colideX = false;
		boolean colideY = false;
		if(enemy != null) {
			colideX = enemy.x - 1 < this.mago.x && enemy.x + 1 > this.mago.x;
			colideY = enemy.y - 1 < this.mago.y && enemy.y + 1 > this.mago.y;
		}
		
		return colideX && colideY;
	}
	
	public void validateColideOfObstacle(){
		for(Obstacle roc : this.rocs) {
			if(roc.validateExternalColition(this.mago)) {
				System.out.println("asdasd");
				this.mago.x -=10;
				this.mago.y -=10;
			}
			
		}
	}
	
	public void viewCollitionsOfFollowEnemies(Bat[] enemies){
		for(Bat enemy : enemies) {
			if(verifyColide(enemy)) {
				enemy = null;
				this.mago.hp -=10;
				if (this.mago.hp >= 0) this.start = true;
			}	
		}
		
	}
	
	public void crateFollowEnemies (Bat[] enemies) {
		for(Bat enemy : enemies) {
			if(enemy != null) {
				enemy.dibujar();
				if (Math.random() > 0.3) enemy.followCharacter(this.mago);
				else enemy.mover(0.5, 0.1);
			}
		}		
	}
	
	
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		if(this.start) {
			menu.dibujar();
			if(entorno.sePresionoBoton(this.entorno.BOTON_IZQUIERDO)) {
				this.start=false;
		}
		return;
		}
		
		this.entorno.cambiarFont(null, surge, null);
		this.background.switchScenary(this.surge);
		this.entorno.escribirTexto("Surge "+ this.surge, 450,400);
		
		/*
		 * boceto del menu
		 * */
		this.asideMenu.dibujar();
		this.asideMenu.onClickButton(this.mago);
		if(this.asideMenu.getState()) {
			this.asideMenu.dibujar();
		}
		
		this.mago.areaAttack = this.asideMenu.getAttackArea();
		
		
		crateFollowEnemies(this.bats);
		createObstacleToMap();
		moveCharacter();
		validateColideOfObstacle();
		this.mago.dibujar();
		viewCollitionsOfFollowEnemies(this.bats);
		
		for(int i = 0 ; i < this.bats.length; i++) {
			if(this.bats[i]!=null) { 
				this.bats[i] = this.mago.attackEnemy(this.bats[i])? null : this.bats[i];
				
			};			
			
		}
		
		if(verifyEnemyArrayIsAllNull()) { 
			this.surge++;
			this.background.switchScenary(this.surge);
			createBatsEnemies();
		}
	}
		

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}