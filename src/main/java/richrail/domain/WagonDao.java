package richrail.domain;

import java.util.Collection;
import java.util.List;

public interface WagonDao {
    Wagon save(Wagon wagon);
    Iterable<Wagon> findAll();
    Iterable<Wagon> findAllWagonWithType();
    Iterable<Wagon> findAllWagonsBasedOnType();
    void delete(Wagon wagon);
}
