package colt45s.canbanapi.domain;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * User
 */
@Entity
@Table(name = "user")
public class User extends AbstractPersistable<Long> {

  private String name;

  protected User() {
  }

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

}