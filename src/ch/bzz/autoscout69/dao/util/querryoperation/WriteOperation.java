package ch.bzz.autoscout69.dao.util.querryoperation;


import ch.bzz.autoscout69.dao.util.DaoException;
import ch.bzz.autoscout69.dao.util.QueryExecutor;
import org.omg.CORBA.SystemException;

import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

public class WriteOperation<T> implements QuerryOperation<Void, T>{

	@Override
	public Void extractFromQuarry(TypedQuery<T> query) {
		query.executeUpdate();
		return null;
	}

	@Override
	public void prepare(QueryExecutor<T> executor) {
		try {
			executor.getTransaction().begin();
			executor.getEntityManager().joinTransaction();
		} catch (SystemException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void close(QueryExecutor<T> executor) {
		try {
			executor.getEntityManager().flush();
			executor.getTransaction().commit();
			executor.getEntityManager().close();
		} catch (SecurityException | IllegalStateException | RollbackException | SystemException e) {
			throw new DaoException(e);
		}
	}

}
