package main.main.Repository;


import main.main.DTO.ValorDTO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ValorRepository extends JpaRepository<ValorDTO, Long> {


}
