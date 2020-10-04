package datos;

public class Coche {
	private double miVelocidad;
	protected double miDireccionActual;
	public double posX;
	public double posY;
	private String piloto;
	
	
	public Coche () {
		this.miDireccionActual = 0;
		this.miVelocidad = 0;
		this.posX = 0;
		this.posY = 0;
		this.piloto = null;
	}

	public double getMiVelocidad() {
		return miVelocidad;
	}

	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}

	public double getMiDireccionActual() {
		return miDireccionActual;
	}

	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString() {
		return "Coche [miVelocidad=" + miVelocidad + ", miDireccionActual=" + miDireccionActual + ", posX=" + posX
				+ ", posY=" + posY + ", piloto=" + piloto + "]";
	}
	public void acelera(double aceleracion) {
		miVelocidad = miVelocidad+aceleracion;
	}
	public void giro(double giro) {
		miDireccionActual = miDireccionActual+giro;
	}
	public void mueve (double tiempoDeMovimiento) {
		posX = posX+(miVelocidad*tiempoDeMovimiento*Math.sin(miDireccionActual));
		posY = posY+(miVelocidad*tiempoDeMovimiento*Math.cos(miDireccionActual)*-1);
	}
	
	

}
