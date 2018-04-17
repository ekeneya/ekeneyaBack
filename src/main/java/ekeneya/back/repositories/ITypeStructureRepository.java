package ekeneya.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ekeneya.back.models.entities.TypeStructure;



@Repository
public interface ITypeStructureRepository extends JpaRepository<TypeStructure, Long>{

	TypeStructure findByCode(String code);
}
