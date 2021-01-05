package richrail.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import richrail.domain.Wagon;

import java.util.Collection;

@Repository
public interface WagonJpaRepository extends CrudRepository<Wagon, Integer> {
//    @Query("SELECT distinct TYPE(W) FROM Wagon W WHERE TYPE(W) is not null")
//    Iterable<Wagon> findAllWagonWithType();

    @Query("SELECT distinct W FROM Wagon W WHERE W.wagonTypeName = 'Generic'")
    Iterable<Wagon> findAllWagonWithType();

    @Query("SELECT W FROM Wagon W WHERE W.wagonTypeName not like 'Generic'")
    Iterable<Wagon> findAllWagonsBasedOnType();
    //
//    @Query("SELECT t FROM Train t where t.powerSource = :power and t.weight = :weight")
//    Train findTrainByPowerSourceAndWeightNamedParams(
//            @Param("powerSource")PowerSource powerSource,
//            @Param("weight") Integer weight
//            );
}
