package ekeneya.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ekeneya.back.models.entities.Ville;



@Repository
public interface IVilleRepository extends JpaRepository<Ville, Long>{

	Ville findByCode(String code);
}
