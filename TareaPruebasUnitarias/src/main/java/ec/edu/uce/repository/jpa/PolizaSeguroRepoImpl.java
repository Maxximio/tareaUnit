package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.PolizaSeguro;

@Repository
@Transactional
public class PolizaSeguroRepoImpl implements IPolizaSeguroRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarPolizaSeguro(PolizaSeguro cuenta) {
		this.entityManager.persist(cuenta);
	}

	@Override
	public void ActualizarPolizaSeguro(PolizaSeguro cuenta){
		this.entityManager.merge(cuenta);
	}

	@Override
	public PolizaSeguro BuscarPorNumero(String numero) {
		Query miQuery= this.entityManager.createNativeQuery("select * from poliza_seguro p where p.poli_numero=:valor",PolizaSeguro.class);
		miQuery.setParameter("valor", numero);
		return (PolizaSeguro) miQuery.getSingleResult();
	}

	@Override
	public String BorrarPolizaSeguro(String numero) {
		PolizaSeguro borrado=this.BuscarPorNumero(numero);	
		this.entityManager.remove(borrado);
		return numero+" Borrado Repo";
	}

}
