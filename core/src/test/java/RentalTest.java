import com.example.SakilaApplication;
import com.example.domain.rental.Rental;
import com.example.repostiory.RentalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class RentalTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RentalRepository rentalRepository;


    @Test
    public void findOneById() {
        Optional<Rental> rentalOptional = rentalRepository.findById(1);
        if (rentalOptional.isPresent()) {
            Rental rental = rentalOptional.get();
            assert (rental != null);
            //get film
            assert (rental.getCustomer() != null);
            //
            logger.info("getCustomer first name:{}", rental.getCustomer().getFirstName());
            //获取客户地址的电话
            logger.info("getCustomer getPhone:{}", rental.getCustomer().getAddress().getPhone());
            //getStaff
            logger.info("getStaff first name:{}", rental.getStaff().getFirstName());
            //phone
            logger.info("getInventory->getStore-> getAddress->getCity:{}",
                    rental.getInventory().getStore()
                            .getAddress().getCity());
        }
    }

}
