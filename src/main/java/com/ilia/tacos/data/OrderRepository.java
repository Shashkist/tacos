package com.ilia.tacos.data;

import com.ilia.tacos.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
    TacoOrder save(TacoOrder order);
}