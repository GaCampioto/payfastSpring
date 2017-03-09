package br.com.gacampioto.payfastSpring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.gacampioto.payfastSpring.controllers.HomeController;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class})
public class AppWebConfiguration {

	//Configuração do caminho necessário para que o Spring encontre nossas views
	@Bean
	public InternalResourceViewResolver internalResourceViewResolve() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //Define o path de onde nossas views estarão
        viewResolver.setPrefix("/WEB-INF/views/");
        //Define o a extensão das nossas views
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}


