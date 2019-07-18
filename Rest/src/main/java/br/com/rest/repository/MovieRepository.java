package br.com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.rest.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
//    @Query(value = "SELECT P.PRODUTORES, F.ANO " + " FROM FILME F, PRODUTORES P,"
//	    + "(SELECT PRODUTORES FROM FILME F1, PRODUTORES P1"
//	    + " WHERE F1.ID = P1.FILME_ID AND UPPER(F1.VENCEDOR) = 'YES'" + " GROUP BY P1.PRODUTORES"
//	    + " HAVING COUNT(P1.PRODUTORES) > 1" + ") PRDS" + " WHERE F.ID = P.FILME_ID"
//	    + " AND P.PRODUTORES = PRDS.PRODUTORES" + " AND UPPER(F.VENCEDOR) = 'YES'"
//	    + " ORDER BY P.PRODUTORES, F.ANO", nativeQuery = true)
    @Query(value = "select p.producers, m.year from movie m, producers p"
	    + " join (select p1.producers from movie m1 join producers"
	    + " p1 on m1.id = p1.movie_id and m1.winner = 'yes'"
	    + " group by p1.producers having count(p1.producers) > 1) pp on p.producers = pp.producers"
	    + " where m.id = p.movie_id and m.winner = 'yes' order by p.producers, m.year", nativeQuery = true)

    List<Object> findProducers();

    List<Movie> findMovieByYearAndWinnerIsNotNull(Integer year);
}