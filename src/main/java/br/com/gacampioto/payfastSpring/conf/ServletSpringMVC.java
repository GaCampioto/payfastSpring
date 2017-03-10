package br.com.gacampioto.payfastSpring.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	//Configuração da classe que possui o caminho para acessar as views
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
	}

	//Configuração dos endereços que serão atendidos pelo spring
	@Override
	protected String[] getServletMappings() {
		return new String [] {"/"};
	}

}
