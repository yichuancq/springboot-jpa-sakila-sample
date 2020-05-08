import com.example.SakilaApplication;
import com.example.domain.customer.Customer;
import com.example.service.customer.CustomerService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void findOneById() {
        Customer customer = customerService.findOneById(1);
        assert (customer != null);
        System.out.println(customer.toString());
    }
}
