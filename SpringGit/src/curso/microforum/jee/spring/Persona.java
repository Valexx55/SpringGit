package curso.microforum.jee.spring;

public class Persona {
	
	private int edad;
	private String nombre;
	private String descripcion;
	
	
	public Persona () {
		//constructor por defecto, tan insulso como imprescindible
	}
	
	public Persona(int edad, String nombre, String descripcion) {
		this.edad = edad;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
