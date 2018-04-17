package ekeneya.back.services;

import java.util.Optional;

import ekeneya.back.models.dto.ListVilleDTO;
import ekeneya.back.models.entities.Ville;

public interface IVilleService {
	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<Ville> selectById(final Long id);
	
	/***
	 * 
	 * @param code
	 * @return
	 */
	Ville selectByCode(final String code);
	
	/**	 * 
	 * @return
	 */
	Optional<ListVilleDTO> selectVilles();

	/**
	 * 
	 * @param ville
	 * @return
	 */
	Ville save(Ville ville);
	
	/**
	 * 
	 * @return
	 */
	long count();
}
