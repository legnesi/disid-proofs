package com.example;

import org.springframework.data.repository.CrudRepository;

public interface MyEntityRepository extends CrudRepository<MyEntity, Long> {

}
