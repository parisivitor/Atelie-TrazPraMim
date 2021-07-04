package br.com.padawans.trazpramim.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.padawans.trazpramim.model.Viagem;

@Repository
public interface ViagemRepository  extends JpaRepository<Viagem, Long>{
	
	Viagem findById(long id);

	List<Viagem> findByDataDaEntregaGreaterThan(LocalDate data, Pageable sort);
}
