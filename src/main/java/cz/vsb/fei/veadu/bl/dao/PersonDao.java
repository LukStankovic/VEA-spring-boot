package cz.vsb.fei.veadu.bl.dao;

import cz.vsb.fei.veadu.entities.Person;

public class PersonDao extends AbstractDao<Person> {

	public PersonDao(){
		setEntityClass(Person.class);
   }
	
}
