package io.pivotal.portfolio.repository;


import java.util.List;

import io.pivotal.portfolio.domain.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author David Ferreira Pinto
 *
 */
public interface OrderRepository extends CrudRepository<Order,String> {

	List<Order> findByAccountId(String accountId);
}
