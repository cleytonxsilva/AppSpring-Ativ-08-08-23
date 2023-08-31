package main.main.Repository;


import main.main.DTO.ValorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ValorRepository extends JpaRepository<ValorDTO, Long> {


}
