package ekeneya.back.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ekeneya.back.models.dto.ListVilleDTO;
import ekeneya.back.models.dto.VilleDTO;
import ekeneya.back.models.entities.Ville;
import ekeneya.back.repositories.IVilleRepository;
import ekeneya.back.utils.VilleUtilDTO;

@Service
public class VilleService implements IVilleService {
	
	@Autowired
	IVilleRepository villeRepository;
	
	
	@Override
	public Optional<Ville> selectById(Long id) {
		return villeRepository.findById(id);
	}

	@Override
	public Ville selectByCode(String code) {
		return villeRepository.findByCode(code);
	}

	@Override
	public Optional<ListVilleDTO> selectVilles() {
		return convertToDTO(villeRepository.findAll(Sort.by(Sort.Direction.ASC,"libelle")));
	}

	@Override
	public Ville save(Ville ville) {
		return villeRepository.save(ville);
	}

	@Override
	public long count() {
		return villeRepository.count();
	}
	
	/***
	 * 
	 * @param villes
	 * @return
	 */
	private Optional<ListVilleDTO> convertToDTO(List<Ville> villes){
		if(villes == null){
			return Optional.empty();
		}
		List<VilleDTO> villesDTO = villes.stream().map(VilleUtilDTO::convertToDTO).collect(Collectors.toList());
		ListVilleDTO listVilleDTO = new ListVilleDTO();
		listVilleDTO.setVilles(villesDTO);
		return Optional.of(listVilleDTO); 
	}

}
