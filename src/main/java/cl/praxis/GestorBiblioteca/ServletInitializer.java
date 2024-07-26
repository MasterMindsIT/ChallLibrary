package cl.praxis.GestorBiblioteca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		logger.warn("Iniciando Servlet...");
		return application.sources(GestorBibliotecaApplication.class);
	}

}
