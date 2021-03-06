package richrail.application;

import org.springframework.transaction.annotation.Transactional;
import richrail.domain.TypeBasedWagonFactory;
import richrail.domain.Wagon;
import richrail.domain.WagonDao;
import richrail.domain.WagonFactory;

@Transactional
public class WagonService {
    private final WagonDao wagonDao;

    public WagonService (WagonDao wagonDao){
        this.wagonDao = wagonDao;
    }

    public Iterable<Wagon> getAllWagons(){
        return this.wagonDao.findAll();
    }

    public Wagon addWagon(Wagon wagon){
        return this.wagonDao.save(wagon);
    }

    public Iterable<Wagon> getAllWagonTypes(){
        return this.wagonDao.findAllWagonWithType();
    }

    public Iterable<Wagon> getAllWagonBasedOnTYpe(){
        return this.wagonDao.findAllWagonsBasedOnType();
    }

    public void deleteWagon(Wagon wagon){this.wagonDao.delete(wagon);}


}
