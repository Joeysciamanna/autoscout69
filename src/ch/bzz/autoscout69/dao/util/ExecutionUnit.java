package ch.bzz.autoscout69.dao.util;

@FunctionalInterface
public interface ExecutionUnit<I,O> {

	public O execute(I input);
}
