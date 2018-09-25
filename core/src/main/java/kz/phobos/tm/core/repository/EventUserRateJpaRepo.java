package kz.phobos.tm.core.repository;

import kz.phobos.tm.core.model.EventUserRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventUserRateJpaRepo extends JpaRepository<EventUserRate, Integer> {
}
