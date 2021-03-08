package it.sirfin.kezapp.repository;

import it.sirfin.kezapp.model.Messaggio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessaggioRepository extends JpaRepository<Messaggio, Long> {

    List<Messaggio> findByAliasDestinatarioIsNull();

    List<Messaggio> findByAliasDestinatario(String ad);

}
