package com.disid.restful.repository;
import com.disid.restful.model.CustomerOrder;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(entity = CustomerOrder.class)
public interface CustomerOrderRepository {
}
