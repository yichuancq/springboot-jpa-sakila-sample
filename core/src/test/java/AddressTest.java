import com.example.SakilaApplication;
import com.example.domain.actor.Actor;
import com.example.domain.address.Address;
import com.example.service.actor.ActorService;
import com.example.service.address.AddressService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class AddressTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void findOneById() {
        Address address = addressService.findOneById(1);
        assert (address != null);
        System.out.println(address.toString());
    }


}
