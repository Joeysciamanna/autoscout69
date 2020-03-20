package ch.bzz.autoscout69.dao.util.querryoperation;

import ch.bzz.autoscout69.dao.util.QueryExecutor;

import javax.persistence.TypedQuery;


public interface QuerryOperation<R,T> {

	public R extractFromQuarry(TypedQuery<T> query);
	
	public void prepare(QueryExecutor<T> executor);
	
	public void close(QueryExecutor<T> executor);
}
