
package curso.microforum.jee.spring;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import curso.microforum.jee.spring.dao.RegionDAOImpl;
import curso.microforum.jee.spring.dao.RegionsDAO;

 
@Controller
public class MiJdbcController {
 
	
	@Autowired
    private RegionsDAO regionDAO;
	
	@RequestMapping("/listaregiones")
	public String listaregiones(Model modelo) {
		
		List<Regions> lista_regiones = null;
		
		lista_regiones = regionDAO.list();
		modelo.addAttribute("lista_regiones", lista_regiones);
 
		return "mostrarregiones";
	}
	
}