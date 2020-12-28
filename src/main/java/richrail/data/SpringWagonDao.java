package richrail.data;

import richrail.domain.Wagon;
import richrail.domain.WagonDao;

import javax.persistence.DiscriminatorValue;
import java.util.Collection;
import java.util.List;

public class SpringWagonDao implements WagonDao {
    private final WagonJpaRepository wagonJpaRepository;

    public SpringWagonDao(WagonJpaRepository wagonJpaRepository){
        this.wagonJpaRepository = wagonJpaRepository;
    }


    @Override
    public Wagon save(Wagon wagon) {
        return this.wagonJpaRepository.save(wagon);
    }

    @Override
    public Collection<Wagon> findByType(String type) {
        return null;
//                this.wagonJpaRepository.findAllWagonWithType(type);
    }

    @Override
    public Iterable<Wagon> findAll() {
        Iterable<Wagon> allWagons = this.wagonJpaRepository.findAll();
        for(Wagon wagon: allWagons ){
            wagon.setWagonType(wagon.getClass().getAnnotation(DiscriminatorValue.class).value());
        }
        return allWagons;
    }


}
