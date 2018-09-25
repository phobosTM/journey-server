package kz.phobos.tm.core.repository;

import kz.phobos.tm.core.model.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventStatusJpaRepo extends JpaRepository<EventStatus, Integer> {

}
