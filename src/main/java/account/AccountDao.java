package account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Project: brewit-api
 *
 * Created on: 22.03.2020
 *
 * Author : Kamil Szerląg
 *
 */
public class AccountDao {

  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BrewIT");

  // TODO REMOVE/ONLY FOR TEST PURPOSE
  @Deprecated
  public void test() {
    Account account = new Account();
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    em.persist(account);
    em.getTransaction().commit();
  }


}
