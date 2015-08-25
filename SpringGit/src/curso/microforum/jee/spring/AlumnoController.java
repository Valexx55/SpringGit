package curso.microforum.jee.spring;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.validation.Valid;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@Controller
@RequestMapping("/alumno")
public class AlumnoController {
 
    
    @RequestMapping(method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
    	Alumno student = new Alumno();
        model.addAttribute("alumno", student);
        return "formularioalumno";
    }
 
  
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
    }
 
 
    /*
     * 
     */
    @ModelAttribute("asignaturas")
    public List<String> initializeSubjects() {
 
        List<String> subjects = new ArrayList<String>();
        subjects.add("Programación funcional");
        subjects.add("Programación lógica");
        subjects.add("Bases de datos multidimensionales");
        subjects.add("Bases de datos no relacionales");
        subjects.add("Sistemas distruídos");
        subjects.add("Estructura de computadores");
        subjects.add("Compiladores");
        subjects.add("Diseño de software avanzado");
        return subjects;
    }
 
}