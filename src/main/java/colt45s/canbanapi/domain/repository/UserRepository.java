package colt45s.canbanapi.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import colt45s.canbanapi.domain.User;

/**
 * UserRepository
 */
public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findAll();

}