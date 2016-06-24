package fiuba.algo3.tablero;

public class Posicion{
	public int x;
	public int y;


	public Posicion(int x, int y){
		this.x = x;
		this.y = y;
	}

	public Posicion(Posicion pos) {
		this.x = pos.x;
		this.y = pos.y;
	}

	public void setX(int x){this.x = x;}
	
	public void setY(int y){this.y = y;}

	public int getX(){return x;}

	public int getY(){return y;}

	public void setPosicion(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void sumar(Posicion pos){
		this.x += pos.x;
		this.y += pos.y;
	}

	public void sumar(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public Posicion sumar(Posicion pos1, Posicion pos2){
		Posicion pos3 = new Posicion(pos1.getX()+pos2.getX(),pos1.getY()+pos2.getY());
		return pos3;
	}

	public Posicion getSuma(Posicion pos){
		return new Posicion(this.x + pos.x, this.y + pos.y);
	}

	public Posicion restar(Posicion pos){
		this.x -= pos.x;
		this.y -= pos.y;
		return this;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof Posicion){
			Posicion p = (Posicion)obj;
			return(this.x == p.x && this.y == p.y);
		} else {
			return false;
		}
	}

	public Posicion getSuma(int x, int y) {
		return new Posicion(this.x + x, this.y + y);
	}

}

