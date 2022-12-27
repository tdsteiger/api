package taylor.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecretSanta {

    private List<Person> randomPers;
    private Map<Person, Person> mapping;

    public SecretSanta(List<Person> pers) {
        List<Person> persCopy = new ArrayList<>(pers);
        Collections.shuffle(persCopy); // Shuffle copy
        this.randomPers = persCopy; // Save copy

        this.mapping = new HashMap<>();
        int givers = this.randomPers.size();
        for (int i = 0; i < givers; i++) {
            Person giver = this.randomPers.get(i); // Current index
            Person receiver = this.randomPers.get((i + 1) % givers); // Get next person in circular list
            this.mapping.put(giver, receiver);
        }
    }

    public Map<Person, Person> getMapping() {
        return this.mapping;
    }
}
