package fiuba.algo3.tablero;

public class Posicion{
	int x;
	int y;
	
	Posicion(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void setX(int x){this.x = x;}
	
	public void setY(int y){this.y = y;}

	public int getX(){return x;}

	public int getY(){return y;}

	public void setPosicion(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Posicion sumar(Posicion pos){
		this.x += pos.x;
		this.y += pos.y;
		return this;
	}
	
	public Posicion restar(Posicion pos){
		this.x -= pos.x;
		this.y -= pos.y;
		return this;
	}
}

