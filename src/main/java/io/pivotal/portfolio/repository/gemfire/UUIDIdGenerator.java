package io.pivotal.portfolio.repository.gemfire;

import io.pivotal.portfolio.repository.IdGenerator;

import java.util.UUID;

/**
 * Created by cdelashmutt@pivotal.io on 1/25/2017.
 */
public class UUIDIdGenerator implements IdGenerator {
	@Override
	public String getNextId() {
		return UUID.randomUUID().toString();
	}
}
