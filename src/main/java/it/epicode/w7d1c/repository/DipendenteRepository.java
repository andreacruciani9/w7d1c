package it.epicode.w7d1c.repository;

import it.epicode.w7d1c.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer>, PagingAndSortingRepository<Dipendente, Integer> {
    public Optional<Dipendente> findByEmail(String email);
}
