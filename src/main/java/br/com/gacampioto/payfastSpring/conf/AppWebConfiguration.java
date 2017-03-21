package br.com.gacampioto.payfastSpring.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.gacampioto.payfastSpring.controllers.HomeController;
import br.com.gacampioto.payfastSpring.daos.PagamentoDAO;
import br.com.gacampioto.payfastSpring.infra.FileSaver;
import br.com.gacampioto.payfastSpring.models.Comprovante;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, PagamentoDAO.class, FileSaver.class, Comprovante.class})
public class AppWebConfiguration {

	//Configuração do caminho necessário para que o Spring encontre nossas views
	@Bean
	public InternalResourceViewResolver internalResourceViewResolve() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //Define o path de onde nossas views estarão
        viewResolver.setPrefix("/WEB-INF/views/");
        //Define o a extensão das nossas views
        viewResolver.setSuffix(".jsp");
        //Define quais classes ficam disponíveis em todas as views
        //viewResolver.setExposeContextBeansAsAttributes(true);
        viewResolver.setExposedContextBeanNames("comprovante");
        return viewResolver;
    }
	
	//Configuração da localização do message.properties
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}
	
	//Configuração de parser de datas
	@Bean
	public FormattingConversionService mvcConversionService(){
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
		
	}
	
	//Configurando "recebedor de arquivos"
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}
	
	
	//Configurando o template para chamadas REST
	@Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}


