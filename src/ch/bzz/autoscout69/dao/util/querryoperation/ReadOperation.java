package ch.bzz.autoscout69.dao.util.querryoperation;


import ch.bzz.autoscout69.dao.util.QueryExecutor;

public abstract class ReadOperation<R, T> implements QuerryOperation<R, T>{

	@Override
	public void prepare(QueryExecutor<T> executor) {}
	
	@Override
	public void close(QueryExecutor<T> executor) {
		executor.getEntityManager().clear();
		executor.getEmf().getCache().evictAll();
		executor.getEntityManager().close();
	}
}
