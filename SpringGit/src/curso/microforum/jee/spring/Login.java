package curso.microforum.jee.spring;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class Login {
	
	@RequestMapping(path = "/login", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Validacion> login(@RequestBody LoginUsuario login_usuario) {
 
		Validacion val = null;
		String mensaje_error = null;
		
		
//			mensaje_error = (result.hasErrors())? Mensajes.MENSAJE_KO:Mensajes.MENSAJE_OK;
//			val = new Validacion(!result.hasErrors(), mensaje_error);

			System.out.println(login_usuario.toString());
		
			val = new Validacion(false, "Como molas");
		
		return new ResponseEntity<Validacion>(val, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/loginget", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Validacion> login2(LoginUsuario login_usuario) {
 
		Validacion val = null;
		String mensaje_error = null;
		
			val = new Validacion(false, "Como molas");
		
			System.out.println(login_usuario.toString());
			/*mensaje_error = (result.hasErrors())? Mensajes.MENSAJE_KO:Mensajes.MENSAJE_OK;

			/*mensaje_error = (result.hasErrors())? Mensajes.MENSAJE_KO:Mensajes.MENSAJE_OK;
			val = new Validacion(!result.hasErrors(), mensaje_error);*/
		
		return new ResponseEntity<Validacion>(val, HttpStatus.OK);
	}
	
	
	/*
	@RequestMapping(method = RequestMethod.POST)
    public String saveRegistration(@Valid Alumno student, BindingResult result, ModelMap model){
    	String msj = "exito";
    	
        if(result.hasErrors()) //si hay errores, volvemos al formulario
        	{
                msj = "formularioalumno";
        	}
        else {
        	model.addAttribute("msjconfirmacion", "Señor/a "+ student.getFirstName()+" , su registro se ha completado!");
            System.out.println(student.toString());
        	
        }
 
        
        return msj;
    }*/
 

}
