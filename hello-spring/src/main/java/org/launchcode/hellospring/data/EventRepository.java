package org.launchcode.hellospring.data;

import org.launchcode.hellospring.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
