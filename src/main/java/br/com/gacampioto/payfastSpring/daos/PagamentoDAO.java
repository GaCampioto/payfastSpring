package br.com.gacampioto.payfastSpring.daos;

import java.util.List;

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

	public List<Pagamento> getPagamentos() {
		return manager.createQuery("Select p from Pagamento p", Pagamento.class).getResultList();
	}

	public Pagamento find(Integer id) {
		Pagamento pagamento = manager.createQuery("Select p from Pagamento p Where p.id = :id", Pagamento.class).setParameter("id", id).getSingleResult();
		return pagamento;
	}
}
