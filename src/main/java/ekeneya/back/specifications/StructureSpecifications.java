package ekeneya.back.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import ekeneya.back.models.dto.SearchStructureParams;
import ekeneya.back.models.entities.Structure;

public class StructureSpecifications {

	private StructureSpecifications() {
		super();
	}

	static Specification<Structure> withCodeVille(final String code) {
		return (root, query, cb) -> {
			return cb.equal(root.get("ville.code"), code);
		};
	}

	static Specification<Structure> nameLike(final String name) {
		return (root, query, cb) -> {
			return cb.equal(root.get("name"), name);
		};
	}

	static Specification<Structure> withCodeType(final String code) {
		return (root, query, cb) -> {
			return cb.equal(root.get("type.code"), code);
		};
	}

	public static Specification<Structure> search(SearchStructureParams params) {

		List<Predicate> predicates = new ArrayList<>();

		return (root, query, cb) -> {
			
			if (!StringUtils.isEmpty(params.getName())) {
				predicates.add(cb.like(cb.lower(root.get("name")),"%"+params.getName().toLowerCase()+"%"));
			}
			if (!StringUtils.isEmpty(params.getCodeVille())) {
				predicates.add(cb.equal(root.get("ville").get("code"), params.getCodeVille()));
			}
			if (!StringUtils.isEmpty(params.getCodeType())) {
				predicates.add(cb.equal(root.get("type").get("code"), params.getCodeType()));
			}
			
			query.orderBy(cb.asc(root.get("name")));
			
			if (!predicates.isEmpty()) {
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
			return null;
		};
	}
}
