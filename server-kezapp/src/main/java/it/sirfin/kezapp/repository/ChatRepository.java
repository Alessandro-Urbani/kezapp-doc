package it.sirfin.kezapp.repository;

import it.sirfin.kezapp.model.Chat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByNickname(String s);

    Chat findBySessione(String s);
    
}
