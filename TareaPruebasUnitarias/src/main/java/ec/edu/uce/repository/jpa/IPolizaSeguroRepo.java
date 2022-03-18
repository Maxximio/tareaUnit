package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.PolizaSeguro;

public interface IPolizaSeguroRepo {

	void InsertarPolizaSeguro(PolizaSeguro cuenta);

	void ActualizarPolizaSeguro(PolizaSeguro cuenta);

	PolizaSeguro BuscarPorNumero(String numero);

	String BorrarPolizaSeguro(String numero);


	
}
