package br.com.gacampioto.payfastSpring.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gacampioto.payfastSpring.models.Pagamento;

@Repository
@Transactional
public class PagamentoDAO {

	@PersistenceContext
	EntityManager manager;
	
	public void gravar(Pagamento pagamento){
		manager.persist(pagamento);
	}
}
