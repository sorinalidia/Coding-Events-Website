package org.launchcode.hellospring.data;

import org.launchcode.hellospring.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends CrudRepository<EventCategory,Integer> {
}
