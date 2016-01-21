package curso.microforum.jee.spring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class MiController {
 
	/*@RequestMapping("/bienvenido")
	public ModelAndView holaMundo() {
 
		System.out.println("Por aqu� ni entrar�");
		String mensaje = "Vamos a darle ca�a al Spring";
		return new ModelAndView("bienvenido", "mensaje", mensaje);
	}*/
	
	
	@RequestMapping("/bienvenido")
	public String holaMundo(Model model) {
 
		model.addAttribute("mensaje", "CHAMPion");
		
		return "bienvenido";
	}
}