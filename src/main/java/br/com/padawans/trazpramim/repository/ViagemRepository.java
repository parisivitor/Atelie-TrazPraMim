package br.com.padawans.trazpramim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.padawans.trazpramim.model.Viagem;

@Repository
public interface ViagemRepository  extends JpaRepository<Viagem, Long>{
	
	Viagem findById(long id);
	
}
