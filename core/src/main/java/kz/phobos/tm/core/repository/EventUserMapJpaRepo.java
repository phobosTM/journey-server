package kz.phobos.tm.core.repository;

import kz.phobos.tm.core.model.EventUserMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventUserMapJpaRepo extends JpaRepository<EventUserMap, Integer> {
}
