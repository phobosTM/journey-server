package kz.phobos.tm.core.repository;

import kz.phobos.tm.core.model.RouteStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteStatusJpaRepo extends JpaRepository<RouteStatus, Integer> {
}
