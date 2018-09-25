package kz.phobos.tm.core.repository;

import kz.phobos.tm.core.model.RateValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateValueJpaRepo extends JpaRepository<RateValue, Integer> {
}
