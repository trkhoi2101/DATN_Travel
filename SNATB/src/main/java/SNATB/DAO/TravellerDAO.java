package SNATB.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SNATB.Entity.Traveller;


@Repository
public interface TravellerDAO extends JpaRepository<Traveller, Long> {

}
