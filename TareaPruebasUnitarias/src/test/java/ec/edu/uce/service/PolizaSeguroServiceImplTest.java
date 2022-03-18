package ec.edu.uce.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.modelo.jpa.PolizaSeguro;

@SpringBootTest
@Rollback(true)
@Transactional
class PolizaSeguroServiceImplTest {

	@Autowired
	private IPolizaSeguroService poliService;
	
	@Test
	void testInsertarPolizaSeguroService() {///////////////////////////////////////////////////////INSERTAR
		PolizaSeguro poliza =new PolizaSeguro();
		poliza.setNumero("1234");
		poliza.setValor(new BigDecimal(500.00));
		poliza.setDescripcion("poliza de casa");
		poliza.setFechaEmision(LocalDateTime.now());
		poliza.setFechaVigencia(LocalDateTime.now().plusNanos(1));
		poliza.setEstado("Activo");
		
		poliService.InsertarPolizaSeguroService(poliza);
		
		PolizaSeguro poli1=this.poliService.BuscarPorNumeroService("1234");
		
		assertEquals("poliza de casa", poli1.getDescripcion());//verificamos que es el mismo valor ingresado
	}
	
	@Test
	void testInsertarPolizaSeguroService2() {
		PolizaSeguro poliza =new PolizaSeguro();
		poliza.setNumero("1234");
		poliza.setValor(new BigDecimal(500.00));
		poliza.setDescripcion("poliza de casa");
		poliza.setFechaEmision(LocalDateTime.now());
		poliza.setFechaVigencia(LocalDateTime.now().plusNanos(1));
		poliza.setEstado("Activo");
		
		poliService.InsertarPolizaSeguroService(poliza);
		
		PolizaSeguro poli1=this.poliService.BuscarPorNumeroService("1234");
		
		assertFalse(poli1.getValor()==new BigDecimal(300.00));//verificamos que es un valor diferente al ya ingresado anteriormente
	}

	@Test
	void testActualizarPolizaSeguroService() {/////////////////////////////////////////////////////////ACTUALIZAR
		PolizaSeguro poli1=this.poliService.BuscarPorNumeroService("123");
		
		poli1.setEstado("Inactivo");
		
		this.poliService.ActualizarPolizaSeguroService(poli1);
		
		PolizaSeguro poli2 =this.poliService.BuscarPorNumeroService("123");
		
		assertTrue(poli2.getEstado()=="Inactivo");	//verificamos que el estado cambio
	}
	
	@Test
	void testActualizarPolizaSeguroService2() {
		PolizaSeguro poli1=this.poliService.BuscarPorNumeroService("123");
		
		//poli1.setValor(poli1.getValor().subtract(new BigDecimal(100.00)));//restamos el valor
		
		this.poliService.ActualizarPolizaSeguroService(poli1);
		
		PolizaSeguro poli2 =this.poliService.BuscarPorNumeroService("123");
		
		assertEquals("1",poli2.getId());	//verificamos que la resta se efectuo
	}

	@Test
	void testBuscarPorNumeroService() {
		PolizaSeguro poli1=this.poliService.BuscarPorNumeroService("123");//////////////////////////////////BUSCAR
		
		assertEquals("poliza de auto", poli1.getDescripcion());//encuentra la descripcion del id senialado
		
	}
	
	@Test
	void testBuscarPorNumeroService2() {
		PolizaSeguro poli1=this.poliService.BuscarPorNumeroService("123");
		
		assertEquals("Activo",poli1.getEstado());//confirmamos que encontro el monto de la poliza 2022-03-18 16:57:25.934937
		
	}

	@Test
	void testBorrarPolizaSeguroService() {////////////////////////////////////////////////////////////////BORRAR
		
		assertEquals("123 Borrado Repo", this.poliService.BorrarPolizaSeguroService("123"));//genera el mensaje de confirmacion
		
	}
	
	@Test
	void testBorrarPolizaSeguroService2() {
		
		PolizaSeguro poliza =new PolizaSeguro();
		poliza.setNumero("1234");
		poliza.setValor(new BigDecimal(500.00));
		poliza.setDescripcion("poliza de casa");
		poliza.setFechaEmision(LocalDateTime.now());
		poliza.setFechaVigencia(LocalDateTime.now().plusNanos(1));
		poliza.setEstado("Activo");
		
		poliService.InsertarPolizaSeguroService(poliza);
		
		
		assertEquals("1234 Borrado Repo",this.poliService.BorrarPolizaSeguroService("1234"));//creamos y borramos poliza con su respectivo return
		
	}

}
