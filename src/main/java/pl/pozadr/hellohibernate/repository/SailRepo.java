package pl.pozadr.hellohibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.error.Mark;
import pl.pozadr.hellohibernate.model.Color;
import pl.pozadr.hellohibernate.model.Sail;

import java.util.List;

@Repository
public interface SailRepo extends JpaRepository<Sail, Long> {
    List<Sail> findByColor(Color color);
    List<Sail> findByColorAndMark(Color color, String mark);
}
