package pl.brewit.common.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Project: brewit-api
 *
 * <p>Created on: 22.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
public interface CrudRepository<T> {

  void save(T object);

  void update(T object);

  Optional<T> findById(Long uuid);

  Optional<T> findById(String uuid);

//  Collection<T> findAll();

  void remove(T object);
}
