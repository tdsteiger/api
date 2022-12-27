package taylor.api.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import taylor.api.model.Person;

@Repository
public class PersonRepository {

	private Map<Long, Person> repository;
	
	public PersonRepository() {
		this.repository = new HashMap<>();
	}
	
	public void add(Person per) {
		repository.put(per.getId(), per);		
	}

	public Person get(long id) {
		return repository.get(id);
	}

	public Person find(String name) {
		Collection<Person> pers = repository.values();
		for (Person per : pers) {
			if (per.getName().equalsIgnoreCase(name))
				return per;
		}
		return null;
	}

	public Person remove(long id) {
		Person per = repository.get(id);
		this.repository.remove(id);
		return per;
	}
	
	public List<Person> getAll() {
		List<Person> pers = new ArrayList<>();
		
		for(Person per : this.repository.values())
            pers.add(per);
		
		return pers;
	}

}