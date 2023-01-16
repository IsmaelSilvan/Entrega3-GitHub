package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import clases.Persona;

public class MainServidor {
	static int nPuerto = 6660;

	public static void main(String[] args) throws IOException {
		ServerSocket servidor =new ServerSocket(nPuerto);// Tengo que dejar declarado el servidor Puerto
		System.out.println("Servidor activado…");
		while (true) {
			try ( 
					Socket	conexionCliente = servidor.accept(); // Por cada iteracion abro una nueva conexión
					DataOutputStream dos = new DataOutputStream(conexionCliente.getOutputStream()); // Creo el flujo de salida
					DataInputStream dis = new DataInputStream(conexionCliente.getInputStream()); // Creo el flujo de entrada																				// entrada
			) {

				new Persona(dis.readUTF()).start();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void mostrarDatos(String nombre) {
		System.out.println("Hola " + nombre);

	}

	public static void enviarDatos(String tipo, String dato, DataOutputStream streamSalida) throws IOException {
		// Con tipo filtro lo que quiero mandar, dato es la variable que quiero mandar y
		// streamSalida es el stream creado para enviar datos por el canal con el
		// servidor
		tipo = tipo.toLowerCase();
		switch (tipo) {
		case "string":
			streamSalida.writeUTF(tipo);
			streamSalida.writeUTF(dato);
			break;

		case "int":
			streamSalida.writeUTF(tipo);
			streamSalida.writeInt(Integer.parseInt(dato));
			break;

		case "double":
			streamSalida.writeUTF(tipo);
			streamSalida.writeDouble(Double.parseDouble(dato));
			break;

		case "char": // Para devolver un solo char
			streamSalida.writeUTF(tipo);
			streamSalida.writeChar(dato.charAt(0));
			break;
		default:
			System.out.println("Fallo en método enviarDatos()");
			break;
		}
	}

	/*
	 * public static void recibirDatos(DataInputStream streamEntrada) throws
	 * IOException { // Con tipo filtro lo que quiero mandar y // streamEntrada es
	 * el stream creado para recibir datos por el canal con el // servidor switch
	 * (streamEntrada.readUTF()) { case "String": streamEntrada.readUTF(); break;
	 * 
	 * case "int": streamEntrada.readInt(); break;
	 * 
	 * case "double": streamEntrada.readDouble(); break;
	 * 
	 * case "Char": // Para devolver un solo char streamEntrada.readChar(); break;
	 * default: System.out.println("Fallo en método recibirDatos()"); } }
	 */

}
