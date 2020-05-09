import com.example.SakilaApplication;
import com.example.domain.payment.Payment;
import com.example.domain.staff.Staff;
import com.example.repostiory.PaymentRepository;
import com.example.service.payment.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class PaymentTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @Test
    public void testPayment() {
        Payment payment = new Payment();
//      payment.setPaymentId(1);
        Staff staff = new Staff();
        staff.setStaffId(1);
        staff.setFirstName("Mike");
        payment.setStaff(staff);
        //
        List<Payment> paymentList = paymentService.queryByConditions(payment);
        assert (paymentList != null);
        for (Payment pay : paymentList) {
            logger.info("staff id:{}", pay.getStaff().getStaffId());
            logger.info("payment id:{},  amount:{}", pay.getPaymentId(), pay.getAmount());
        }

    }
}
