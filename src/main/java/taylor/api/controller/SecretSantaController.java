package taylor.api.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import taylor.api.model.Person;
import taylor.api.model.SecretSanta;
import taylor.api.repository.PersonRepository;

@RestController
public class SecretSantaController {
    @Autowired
	private PersonRepository repository;
    private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/secret-santa")
	public Map<Person, Person> getSecretSanta() {
        List<Person> pers = repository.getAll();
        return (new SecretSanta(pers)).getMapping();
	}

    @PostMapping("/secret-santa/add")
	public Person addPerson(@RequestBody Person per) {
        per.setId(counter.incrementAndGet()); // Use our own ID

		repository.add(per);
		return per;
	}

    @DeleteMapping("/secret-santa/remove/{id}")
	public Person removePersonByID(@PathVariable("id") long id) {
		return repository.remove(id);
	}
}
