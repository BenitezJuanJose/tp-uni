package juego;

import java.awt.Color;

import entorno.Entorno;

public class Menu {
	Entorno e;
	Button spell,spell2,spell3;
	double areaAttack;
	Menu(Entorno e){
		this.e = e;
		this.spell = new Button(900,100,e);
		this.spell2 = new Button(900,300,e);
		this.spell3 = new Button(900,500,e);
		this.areaAttack = 100;
	}
	public void dibujar(){
		this.e.dibujarRectangulo(900, 0, 200, 1600,0 , Color.gray);
		this.spell.dibujar();
		this.spell2.dibujar();
		this.spell3.dibujar();
	}
	public void onClickButton(Magician mago) {
		if(this.e.sePresionoBoton( this.e.BOTON_IZQUIERDO ) &&  this.spell.cords() ) {
			this.areaAttack =100;
			this.spell.click();
			
		}
		if(this.e.sePresionoBoton( this.e.BOTON_IZQUIERDO ) &&  this.spell2.cords() ) {
			this.areaAttack =200;
			this.spell2.click();
		}
		if(this.e.sePresionoBoton( this.e.BOTON_IZQUIERDO ) &&  this.spell3.cords() ) {
			this.areaAttack = 250;
			this.spell3.click();
		}
		
	}
	public double getAttackArea(){
		return this.areaAttack;
	}
	public boolean getState(){
		return this.spell.state();
	}
	
}
