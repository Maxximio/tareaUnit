package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.PolizaSeguro;
import ec.edu.uce.repository.jpa.IPolizaSeguroRepo;

@Service
public class PolizaSeguroServiceImpl implements IPolizaSeguroService{

	@Autowired
	private IPolizaSeguroRepo poliRepo;

	@Override
	public void InsertarPolizaSeguroService(PolizaSeguro cuenta) {
		this.poliRepo.InsertarPolizaSeguro(cuenta);
	}

	@Override
	public void ActualizarPolizaSeguroService(PolizaSeguro cuenta) {
		this.poliRepo.ActualizarPolizaSeguro(cuenta);
	}

	@Override
	public PolizaSeguro BuscarPorNumeroService(String numero) {
		return this.poliRepo.BuscarPorNumero(numero);
	}

	@Override
	public String BorrarPolizaSeguroService(String numero) {
		return this.poliRepo.BorrarPolizaSeguro(numero);
	}
	
	

}
