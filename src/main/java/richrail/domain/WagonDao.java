package richrail.domain;

import java.util.Collection;
import java.util.List;

public interface WagonDao {
    Wagon save(Wagon wagon);
    Collection<Wagon> findByType(String type);
    Iterable<Wagon> findAll();
}
