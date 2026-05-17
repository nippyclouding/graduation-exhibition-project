package server.TripToN.concern.repository;

import server.TripToN.concern.entity.Concern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcernRepository extends JpaRepository<Concern, Long> {
    long countByDeletedAtIsNull();
}
