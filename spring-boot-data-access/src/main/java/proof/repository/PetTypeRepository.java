package proof.repository;

import org.springframework.transaction.annotation.Transactional;

import proof.model.PetType;

@Transactional(readOnly = true)
public interface PetTypeRepository extends ReadOnlyRepository<PetType, Long> {
    // Nothing to add
}
