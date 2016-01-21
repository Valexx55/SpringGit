package curso.microforum.jee.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class TestController {
        
  @RequestMapping("/exeJsTest-string-returned")
  public String testExeJsString(Model model) 
  {
	  model = setTestVariables(model);
	  	
	  return "booking";
  }

  @RequestMapping("/exeJsTest-view-returned")
  public View testExeJsView(Model model) 
  {
	  ExeJsView vista = null;
	  
		  setTestVariables(model);
		  vista = new ExeJsView();
		  vista.setViewName("booking"+ExeJsView.EXE_JS_EXT);
    
	return vista;
  }

  @RequestMapping("/exeJsTest-modelAndView-returned")
  public ModelAndView testExeJsModelAndView(Model model) 
  {
	  ModelAndView modelAndView = null;
	  
	  
	    setTestVariables(model);
	    modelAndView = new ModelAndView();
	    modelAndView.setViewName("booking");
	    
	    return modelAndView;
   
	    
  }

 
  
  private Model setTestVariables(Model model) 
  {
	  Model model_local = model;
	  
	  //TODO Mejora: usar la internacionalización con MessageSource, pero bueno, lo ponemos "harcode"
	  
		  model_local.addAttribute("item_id", 394);
		  model_local.addAttribute("is_bookable", false);
		  model_local.addAttribute("success_title", "Booking successfull !");
		  model_local.addAttribute("success_message", "The item 394 was correctly booked");
		  model_local.addAttribute("error_title", "An error occurred when booking");
		  model_local.addAttribute("error_message", "Item 394 can't be booked because of some technical problems");
		  model_local.addAttribute("booking_url", "/booking/make-book");
	    
		  return model_local;
  }
}