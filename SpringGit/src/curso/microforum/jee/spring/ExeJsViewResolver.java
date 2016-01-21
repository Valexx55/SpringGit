package curso.microforum.jee.spring;

import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class ExeJsViewResolver implements ViewResolver, Ordered {
    
	  private int order;
	  
	  
	  /**
	   * Dado un nombre l�gico de la vista, comprobaos si existe una plantilla que lo corresponda
	   * En caso de que exista, se devuelve el objeto que se encargar� de generar la vista, llamado View
	   * En caso de que no exista, se devuelve null y Spring probar� con otro ViewResolver (el siguiente en prioridad)
	   */
	  @Override
	  public View resolveViewName(String viewName, Locale locale) throws Exception 
	  {
		  View vista = null;
	  
		  ExeJsView exeJsView = new ExeJsView();
		  exeJsView.setViewName(viewName+ExeJsView.EXE_JS_EXT);
	    
		  //NOTA: podr�a omitirse esta comprobaci�n y devolver siempre una Vista
		  //en el caso de fallar la creaci�n de la vista ante la inexistencia de 
		  //la plantilla, el fallo se producir�a dentro de la vista
		  if (exeJsView.exists()) 
	    		{
	    			vista = exeJsView;
	    		}
	    
		  return vista;
	  }

	  public void setOrder(int order) 
	  {
		  this.order = order;
	  }
	  
	  @Override
	  public int getOrder() 
	  {
		  return this.order;
	  }
	

	}