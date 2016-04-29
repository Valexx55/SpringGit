package curso.microforum.jee.spring;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginUsuario {
	
	/*@Size(min=6, max=45)
	@NotNull*/
	private String nombre;
	/*@Size(min=6, max=45)
	@NotNull*/
	private String pwd;
	
	
	public LoginUsuario () {}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre_usuario) {
		this.nombre = nombre_usuario;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombre + " " + this.pwd;
	}

}
