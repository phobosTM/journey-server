package kz.phobos.tm.core.repository;

import kz.phobos.tm.core.model.RouteLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RouteLevelJpaRepo extends JpaRepository<RouteLevel, Integer> {
}
