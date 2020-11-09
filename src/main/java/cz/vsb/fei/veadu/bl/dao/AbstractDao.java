package cz.vsb.fei.veadu.bl.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class AbstractDao <T extends Serializable>{
	 
	   private Class<T> entity;
	 
	   @PersistenceContext
	   EntityManager entityManager;
	 
	   public final void setEntityClass(Class<T> entity ){
	      this.entity = entity;
	   }
	 
	   public T findOne(long id){
	      return entityManager.find(entity, id);
	   }
	   
	   public List<T> findAll(){
	      return entityManager.createQuery("from " + entity.getName()).getResultList();
	   }
	 
	   public void create(T entity){
	      entityManager.persist(entity);
	   }
	 
	   public T update(T entity){
	      return entityManager.merge( entity );
	   }
	 
	   public void delete(T entity){
	      entityManager.remove(entity);
	   }
	   
	   public void deleteById(long entityId){
	      T entity = findOne(entityId);
	      delete(entity);
	   }
	}