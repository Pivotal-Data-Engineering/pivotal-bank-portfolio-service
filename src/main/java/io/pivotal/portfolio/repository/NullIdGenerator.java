package io.pivotal.portfolio.repository;

/**
 * Created by cdelashmutt@pivotal.io on 1/25/2017.
 */
public class NullIdGenerator implements IdGenerator {
	@Override
	public String getNextId() {
		return null;
	}
}
