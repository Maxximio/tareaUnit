package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.PolizaSeguro;

public interface IPolizaSeguroService {

	void InsertarPolizaSeguroService(PolizaSeguro cuenta);
	
	void ActualizarPolizaSeguroService(PolizaSeguro cuenta);
	
	PolizaSeguro BuscarPorNumeroService(String numero);
	
	String BorrarPolizaSeguroService(String numero);
}
