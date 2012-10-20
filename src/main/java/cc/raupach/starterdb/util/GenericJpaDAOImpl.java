package cc.raupach.starterdb.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.Assert;

public abstract class GenericJpaDAOImpl<T, ID extends Serializable> implements GenericJpaDAO<T, ID>
{

   @PersistenceContext
   protected EntityManager entityManager;

   private Class<T> persistentClass;

   @SuppressWarnings("unchecked")
   public GenericJpaDAOImpl()
   {
      this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
   }

   public Class<T> getPersistentClass()
   {
      return persistentClass;
   }

   public T findById(ID id)
   {
      Assert.notNull(id, "id");

      T entity = entityManager.find(getPersistentClass(), id);
      if (entity == null)
      {
         throw new RuntimeException( "Object not found");
      }

      return entity;

   }

   @SuppressWarnings("unchecked")
   public List<T> get()
   {
      Query q = entityManager.createQuery("SELECT ts FROM " + persistentClass.getName() + " ts ");

      List<T> result = q.getResultList();
      return result;
   }

   public void makePersistent(T entity)
   {
      Assert.notNull(entity, "entity");

      entityManager.persist(entity);
   }

   public void makeTransient(T entity)
   {
      Assert.notNull(entity, "entity");

      entityManager.remove(entity);
   }

}
