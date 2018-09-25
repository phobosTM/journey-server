package kz.phobos.tm.core.repository;

import kz.phobos.tm.core.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteJpaRepo extends JpaRepository<Route, Integer> {
}
