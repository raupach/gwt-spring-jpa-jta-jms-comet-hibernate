package cc.raupach.backend.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.metamodel.Metamodel;

public interface GenericJpaDAO<T, ID extends Serializable>
{

   public abstract T findById(ID bookId);

   public abstract List<T> get();

   public abstract void makePersistent(T entity);

   public abstract void makeTransient(T entity);
   
   public Metamodel getMeta();
}
