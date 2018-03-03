package edu.aspire.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*public class AspireWebInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
			//XmlWebApplicationContext context = new XmlWebApplicationContext();
	       //context.setConfigLocation("/WEB-INF/disp-servlet.xml");
		 
	      ServletRegistration.Dynamic dispatcher = arg0.addServlet("disp", new DispatcherServlet());
	      dispatcher.setLoadOnStartup(1);
	      dispatcher.addMapping("*.htm");
	}
}*/

public class AspireWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.htm" };
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { AppWebRootConfig.class };
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
}
