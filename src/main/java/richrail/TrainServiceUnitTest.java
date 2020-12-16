package richrail;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import richrail.application.TrainService;
import richrail.domain.Train;

import java.sql.Connection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainServiceUnitTest {

    @Autowired
    private TrainService trainService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        Iterable<Train> train = trainService.getAllTrains();
        Assert.assertNotNull(train);
    }
}
