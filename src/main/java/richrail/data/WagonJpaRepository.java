package richrail.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import richrail.domain.Wagon;

import java.util.Collection;

@Repository
public interface WagonJpaRepository extends CrudRepository<Wagon, Integer> {
//    @Query("SELECT w FROM Wagon w WHERE w.wagon_type = :type")
//    Collection<Wagon> findAllWagonWithType(
//          @Param("type")String type
//      );


    //
//    @Query("SELECT t FROM Train t where t.powerSource = :power and t.weight = :weight")
//    Train findTrainByPowerSourceAndWeightNamedParams(
//            @Param("powerSource")PowerSource powerSource,
//            @Param("weight") Integer weight
//            );
}
