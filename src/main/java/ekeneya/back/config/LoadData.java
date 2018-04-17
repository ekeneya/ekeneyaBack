package ekeneya.back.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ekeneya.back.exceptions.ApiExceptions;
import ekeneya.back.models.entities.Structure;
import ekeneya.back.models.entities.TypeStructure;
import ekeneya.back.models.entities.Ville;
import ekeneya.back.services.IStructureService;
import ekeneya.back.services.ITypeStructureService;
import ekeneya.back.services.IVilleService;
import ekeneya.back.utils.StructureUtilDTO;

@Component
public class LoadData implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(LoadData.class);

	@Autowired
	IVilleService villeService;

	@Autowired
	ITypeStructureService typeService;

	@Autowired
	IStructureService structureService;

	
	@Override
	public void run(String... args) throws Exception {
		loadVilles();
		loadTypeStructures();
		loadStructures();
	}

	private void loadStructures() {
		if(structureService.count()!=0){
			return;
		}
		
		TypeReference<List<StructureJson>> typeReference = new TypeReference<List<StructureJson>>() {
		};

		InputStream inputStream = TypeReference.class.getResourceAsStream("/data/structures.json");

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			List<StructureJson> structures = mapper.readValue(inputStream, typeReference);
			structures.forEach(item -> {
				Structure structure = new Structure();
				structure.setLatitude(item.getLatitude());
				structure.setLongitude(item.getLongitude());
				structure.setName(item.getName());
				
				structure.setType(typeService.selectByCode(item.getType()));
				structure.setVille(villeService.selectByCode(item.getVille()));
				
				logger.info(item);
				try {
					structureService.save(StructureUtilDTO.convertToDTO(structure));
				} catch (ApiExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			logger.info("Nombre de structures enregistré ==>"+structures.size());
		} catch (IOException e) {
			logger.error("Unable to save structures: " + e.getMessage());
		}
	}

	private void loadVilles() {
		
		if(villeService.count()!=0){
			return;
		}
		TypeReference<List<Ville>> typeReference = new TypeReference<List<Ville>>() {
		};

		InputStream inputStream = TypeReference.class.getResourceAsStream("/data/villes.json");

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			List<Ville> villes = mapper.readValue(inputStream, typeReference);
			villes.forEach(ville -> {
				ville.setCode(ville.getCode().toLowerCase());
				villeService.save(ville);
			});
			logger.info("Nombre de villes enregistré ==> "+villes.size());
		} catch (IOException e) {
			logger.error("Unable to save villes: " + e.getMessage());
		}
	}

	private void loadTypeStructures() {
		
		if(typeService.count() != 0){
			return;
		}
		
		TypeReference<List<TypeStructure>> typeReference = new TypeReference<List<TypeStructure>>() {
		};

		InputStream inputStream = TypeReference.class.getResourceAsStream("/data/typeStrucutres.json");

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			List<TypeStructure> types = mapper.readValue(inputStream, typeReference);
			types.forEach(type -> {
				typeService.save(type);
			});
			logger.info("Nombre de type enregistré : "+types.size());
		} catch (IOException e) {
			logger.error("Unable to save type structures: " + e.getMessage());
		}
	}

}