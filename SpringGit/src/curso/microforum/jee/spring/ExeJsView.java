package curso.microforum.jee.spring;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.AbstractView;

public class ExeJsView extends AbstractView {
    
	  public static final String EXE_JS_EXT = ".exejs";
	  private static final String EXE_JS_TEMPLATE_NAME = "template.exejs";
	  private static final String CONTENT_PART_ATTR = "[[CONTENT_PART]]";
	  
	  private String viewName;
	  private Resource resContentPart;
	  
	  public void setViewName(String viewName) 
	  {
		  this.viewName = viewName;
	  }
	  
	  /**
	    * Creates the response and returns it with HttplServletResponse object.
	    */
	  @Override
	  protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception 
	  {
		  	//tomo la plantilla
		  	//en este caso, uso ClassPathResource por lo que mi plantilla debe estar en /src al final en /bin
		    //pero podría coger otro fichero de cualquier sitio
		    //preferiblemente se supone que las plantillas mejor dentro de WEB-INF (y no en la raíz WebContent), para que el propio
		    //mecanismo de seguridad con que cuenta el contenedor JEE, impida el acceso público al fichero jsp
		    Resource template = new ClassPathResource(EXE_JS_TEMPLATE_NAME);
		    
		    //tomo la subplantilla, preguntando primero si ya está cargada para ahorrármela
		    if (this.resContentPart == null) 
		    {
		      this.resContentPart = new ClassPathResource(this.viewName);
		    }
		    
		    String templateContent = FileUtils.readFileToString(template.getFile());
		    String viewContent = FileUtils.readFileToString(this.resContentPart.getFile());
	
		    // sustituyo dentro de la plantilla grande con la subplnatilla
		    String fileContent = templateContent.replace(CONTENT_PART_ATTR, viewContent);
		    
		    //voy recorriendo los datos del modelo y sustituyo por los valores en el fichero
		    if (model != null && model.size() > 0) 
		    {
		    	for (Map.Entry<String, Object> entry : model.entrySet()) 
		    	{
		    		fileContent = fileContent.replaceAll(constructVariable(entry.getKey()), entry.getValue().toString());
		    	}
		    }
		    // una vez finalizado el proceso, seteo las cabeceras y el cuerpo de la respuesta y listo!
		    
		    response.setContentType(this.getContentType());
		    response.getOutputStream().write(fileContent.getBytes("UTF-8"));
	  }
	  
	  /**
	    * This method must always return application/javascript. It's the 
	    * reason why we doesn't allow setting content type and 
	    * why this return is hard-coded.
	    */
	  @Override
	  public String getContentType() 
	  {
		  return "application/javascript";
	  }
	  
	  @Override
	  public void setContentType(String contentType) {
	    // nothing to do here
	  }

	  /**
	    * Checks if given model exists.
	    * 
	    * @return True if exists, false otherwise.
	    */
	  public boolean exists() 
	  {
		  boolean br = false;
		  this.resContentPart = new ClassPathResource(this.viewName);
		  
			  try 
			  {
				  br = this.resContentPart.getFile() != null && this.resContentPart.getFile().exists();
			  } 
			  catch (IOException e) 
			  {
				  e.printStackTrace();
			  }
			  
	    return br;
	  }
	  
	  /**
	    * Constructs variable name used by .exejs files. The variable name must correspond 
	    * to the key of Model map. For example: for Model entry<"name", "My name">,
	    * this method will return [[name]].
	    * 
	    * @param modelAttrName The name from Model map (corresponds to the key of this map)
	    * @return Variable recognized by .exejs template.
	    */
	  private String constructVariable(String modelAttrName) 
	  {
		  return "\\[\\["+modelAttrName+"\\]\\]";
	  }

	}