package kz.phobos.tm.core.repository;

import kz.phobos.tm.core.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventJpaRepo extends JpaRepository<Event, Integer> {


}
