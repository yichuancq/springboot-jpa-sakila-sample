import com.example.SakilaApplication;
import com.example.domain.address.Address;
import com.example.domain.customer.Customer;
import com.example.domain.payment.Payment;
import com.example.domain.staff.Staff;
import com.example.service.payment.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class PaymentTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaymentService paymentService;

    @Test
    public void queryPage() {
        Payment payment = new Payment();
//      payment.setPaymentId(1);
        Staff staff = new Staff();
        staff.setStaffId(1);
        staff.setFirstName("Mike");
        payment.setStaff(staff);
        //
        Customer customer = new Customer();
        Address address = new Address();
        address.setPhone("28303384290");
        customer.setFirstName("MARY");
        customer.setAddress(address);
        payment.setCustomer(customer);
        //
        Page<Payment> paymentPage = paymentService.queryPageByConditions(payment, 1, 1);
        List<Payment> payments = paymentPage.getContent();
        assert (payments != null);
        for (Payment pay : payments) {
            logger.info("getFirstName :{}", pay.getCustomer().getFirstName());
            logger.info("getPhone :{}", pay.getCustomer().getAddress().getPhone());
            logger.info("staff id:{}", pay.getStaff().getStaffId());
            logger.info("payment id:{},  amount:{}", pay.getPaymentId(), pay.getAmount());
        }
    }

    @Test
    public void testPayment() {
        Payment payment = new Payment();
//      payment.setPaymentId(1);
        Staff staff = new Staff();
        staff.setStaffId(1);
        staff.setFirstName("Mike");
        payment.setStaff(staff);

        Customer customer = new Customer();
        Address address = new Address();
        address.setPhone("28303384290");

        customer.setFirstName("MARY");
        customer.setAddress(address);
        payment.setCustomer(customer);
        //
        List<Payment> paymentList = paymentService.queryByConditions(payment);
        assert (paymentList != null);
        for (Payment pay : paymentList) {
            logger.info("getFirstName :{}", pay.getCustomer().getFirstName());
            logger.info("getPhone :{}", pay.getCustomer().getAddress().getPhone());
            logger.info("staff id:{}", pay.getStaff().getStaffId());
            logger.info("payment id:{},  amount:{}", pay.getPaymentId(), pay.getAmount());
        }

    }

}

//
//select
//        customer0_.customer_id as customer1_5_0_,
//        customer0_.active as active2_5_0_,
//        customer0_.address_id as address_8_5_0_,
//        customer0_.create_date as create_d3_5_0_,
//        customer0_.email as email4_5_0_,
//        customer0_.first_name as first_na5_5_0_,
//        customer0_.last_name as last_nam6_5_0_,
//        customer0_.last_update as last_upd7_5_0_,
//        address1_.address_id as address_1_1_1_,
//        address1_.address as address2_1_1_,
//        address1_.address2 as address3_1_1_,
//        address1_.city_id as city_id8_1_1_,
//        address1_.district as district4_1_1_,
//        address1_.last_update as last_upd5_1_1_,
//        address1_.phone as phone6_1_1_,
//        address1_.postal_code as postal_c7_1_1_,
//        city2_.city_id as city_id1_3_2_,
//        city2_.city as city2_3_2_,
//        city2_.country_id as country_3_3_2_,
//        city2_.last_update as last_upd4_3_2_
//        from
//        customer customer0_
//        left outer join address address1_ on customer0_.address_id = address1_.address_id
//        left outer join city city2_ on address1_.city_id = city2_.city_id
//        where
//        customer0_.customer_id = ?
/***/
//    select
//    distinct payment0_.payment_id as payment_1_12_,
//    payment0_.amount as amount2_12_,
//    payment0_.customer_id as customer5_12_,
//    payment0_.last_update as last_upd3_12_,
//    payment0_.payment_date as payment_4_12_,
//    payment0_.rental_id as rental_i6_12_,
//    payment0_.staff_id as staff_id7_12_
//            from
//    payment payment0_
//    left outer join staff staff1_ on payment0_.staff_id = staff1_.staff_id
//    left outer join customer customer2_ on payment0_.customer_id = customer2_.customer_id cross
//    join address address3_
//            where
//    customer2_.address_id = address3_.address_id
//    and 1 = 1
//    and staff1_.staff_id = 1
//    and staff1_.first_name = ?
//    and customer2_.first_name = ?
//    and address3_.phone = ?