package richrail.domain;

import java.util.Optional;

public interface PowerSourceDao {
    Iterable<PowerSource> findAll();
    Iterable<PowerSource> findAllByCompatibility(int weight);
    PowerSource save(PowerSource powerSource);
    Optional<PowerSource> findPowersourceById(int id);

}
