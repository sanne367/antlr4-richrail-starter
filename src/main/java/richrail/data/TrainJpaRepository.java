package richrail.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import richrail.domain.PowerSource;
import richrail.domain.Train;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@Repository
//@Transactional
public interface TrainJpaRepository extends CrudRepository<Train, UUID> {
//    @Query("SELECT t FROM Train t WHERE t.wagons is not empty")
//    Collection<Train> findAllTrainsWithWagons();
//
//    @Query("SELECT t from Train t ORDER BY t.id")
//    Page<Train> findAllTrainsWithPagination(Pageable pageable);
//
//    @Query("SELECT t FROM Train t where t.powerSource = :power and t.weight = :weight")
//    Train findTrainByPowerSourceAndWeightNamedParams(
//            @Param("powerSource")PowerSource powerSource,
//            @Param("weight") Integer weight
//            );


}
