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
    public void delete(Wagon wagon) {
        this.wagonJpaRepository.delete(wagon);
    }

    @Override
    public Iterable<Wagon> findAll() {
        Iterable<Wagon> allWagons = this.wagonJpaRepository.findAll();
//        for(Wagon wagon: allWagons ){
//            wagon.setWagonTypeName(wagon.getClass().getAnnotation(DiscriminatorValue.class).value());
//        }
        return allWagons;
    }

    @Override
    public Iterable<Wagon> findAllWagonWithType() {
        return this.wagonJpaRepository.findAllWagonWithType();
    }

    @Override
    public Iterable<Wagon> findAllWagonsBasedOnType() {
        return this.wagonJpaRepository.findAllWagonsBasedOnType();
    }


}
