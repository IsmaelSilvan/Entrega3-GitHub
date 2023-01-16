package clases;

public class Persona extends Thread {
	private String nombre;

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Saludos para " + nombre;
	}

}
