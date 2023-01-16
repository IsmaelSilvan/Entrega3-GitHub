package clases;

public class Persona extends Thread {
	private String nombreName;

	public Persona(String nombreName) {
		this.nombreName = nombreName;
	}

	@Override
	public void run() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Saludos para " + nombreName;
	}

}
