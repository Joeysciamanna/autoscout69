package ch.bzz.autoscout69.dao.util;

import javax.annotation.Resource;
import javax.persistence.*;


import ch.bzz.autoscout69.dao.util.querryoperation.QuerryOperation;
import ch.bzz.autoscout69.dao.util.querryoperation.WriteOperation;

public class QueryExecutor<T> {
		
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Resource
	private EntityTransaction transaction;

	private EntityManager entityManager;


	public <E> E executeQuery(ExecutionUnit<EntityManager, E> executionUnit, QuerryOperation<E, T> querryOperation) throws DaoException {
		this.entityManager = emf.createEntityManager();
		E result;
		try {
			querryOperation.prepare(this);
			result = executionUnit.execute(entityManager);
			querryOperation.close(this);
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} catch (NoResultException e) {
			result = null;
		} catch (IllegalStateException | SecurityException e) {
			throw new DaoException(e);
		}
		return result;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public EntityTransaction getTransaction() {
		return transaction;
	}

}
