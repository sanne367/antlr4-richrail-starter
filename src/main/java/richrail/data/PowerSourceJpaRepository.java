package richrail.data;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import richrail.domain.PowerSource;

@Repository
public interface PowerSourceJpaRepository extends CrudRepository<PowerSource, Integer> {
    @Query("SELECT P FROM PowerSource P where P.maxWeight >= :weight")
    Iterable<PowerSource> findTrainByPowerSourceAndWeightNamedParams(
            @Param("weight") Integer weight
    );


}
