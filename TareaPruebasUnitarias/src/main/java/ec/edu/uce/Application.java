package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.jpa.PolizaSeguro;
import ec.edu.uce.service.IPolizaSeguroService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger LOG= LogManager.getLogger(Application.class);
	
	@Autowired
	private IPolizaSeguroService poliService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		PolizaSeguro poliza =new PolizaSeguro();
		poliza.setNumero("123");
		poliza.setValor(new BigDecimal(300));
		poliza.setDescripcion("poliza de auto");
		poliza.setFechaEmision(LocalDateTime.now());
		poliza.setFechaVigencia(LocalDateTime.now().plusNanos(1));
		poliza.setEstado("Activo");
		
		//poliService.InsertarPolizaSeguroService(poliza);
		//this.poliService.ActualizarPolizaSeguroService(poliza);
		
	}

}
