package pl.pozadr.hellohibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pozadr.hellohibernate.model.Sail;

@Repository
public interface SailRepo extends JpaRepository<Sail, Long> {
}
