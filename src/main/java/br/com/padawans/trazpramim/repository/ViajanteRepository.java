package br.com.padawans.trazpramim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.padawans.trazpramim.model.Viajante;

@Repository
public interface ViajanteRepository extends JpaRepository<Viajante, Long> {

}
