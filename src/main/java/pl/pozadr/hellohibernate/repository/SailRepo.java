package pl.pozadr.hellohibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.pozadr.hellohibernate.model.Color;
import pl.pozadr.hellohibernate.model.Sail;

import java.util.List;

@Repository
public interface SailRepo extends JpaRepository<Sail, Long> {
    List<Sail> findByColor(Color color);
    List<Sail> findByColorAndMark(Color color, String mark);

    @Query(value = "SELECT * from sails WHERE sail_mark = :mark", nativeQuery = true)
    List<Sail> findByMarkMyImpl(@Param("mark") String mark);
}
