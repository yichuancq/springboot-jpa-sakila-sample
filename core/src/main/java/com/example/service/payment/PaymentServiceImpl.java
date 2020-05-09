package com.example.service.payment;

import com.example.domain.customer.Customer;
import com.example.domain.payment.Payment;
import com.example.domain.staff.Staff;
import com.example.repostiory.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * @author yichuan
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> queryByConditions(final Payment queryPayment) {
        //表关联查询 Payment 为主表
        Specification<Payment> specification = (Specification<Payment>) (root, query, cb) -> {
            //
            Predicate predicate = cb.conjunction();
            //left join
            Join<Payment, Staff> ruleJoin = root.join("staff", JoinType.LEFT);
            Join<Payment, Customer> ruleCustomerJoin = root.join("customer", JoinType.LEFT);
            // 通过staff Id过滤
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getStaff())
                    && !StringUtils.isEmpty(queryPayment.getStaff().getStaffId())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleJoin.get("staffId"),
                        queryPayment.getStaff().getStaffId())); //拼接副表中的查询条件
            }
            // first name过滤
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getStaff())
                    && !StringUtils.isEmpty(queryPayment.getStaff().getFirstName())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleJoin.get("firstName"),
                        queryPayment.getStaff().getFirstName())); //拼接副表中的查询条件
            }

            //payment->customer->name
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getCustomer())
                    && !StringUtils.isEmpty(queryPayment.getCustomer().getFirstName())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleCustomerJoin.get("firstName"),
                        queryPayment.getCustomer().getFirstName())); //拼接副表中的查询条件
            }
            //payment->customer->address->phone
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getCustomer())
                    && !StringUtils.isEmpty(queryPayment.getCustomer().getAddress().getPhone())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleCustomerJoin.get("address").get("phone"),
                        queryPayment.getCustomer().getAddress().getPhone())); //拼接副表中的查询条件
            }
            query.distinct(true);
            query.where(predicate);
            return query.getRestriction();
        };
        List<Payment> payments = paymentRepository.findAll(Specification.where(specification));
        return payments;
    }


    /**
     * Payment 关联对象复合查询
     *
     * @param queryPayment
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Payment> queryPageByConditions(Payment queryPayment, int pageNumber, int pageSize) {

        Pageable pageable = new PageRequest(pageNumber - 1, pageSize);

        //表关联查询 Payment 为主表
        Specification<Payment> specification = (Specification<Payment>) (root, query, cb) -> {
            //
            Predicate predicate = cb.conjunction();
            //left join
            Join<Payment, Staff> ruleJoin = root.join("staff", JoinType.LEFT);
            Join<Payment, Customer> ruleCustomerJoin = root.join("customer", JoinType.LEFT);
            // 通过staff Id过滤
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getStaff())
                    && !StringUtils.isEmpty(queryPayment.getStaff().getStaffId())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleJoin.get("staffId"),
                        queryPayment.getStaff().getStaffId())); //拼接副表中的查询条件
            }
            // first name过滤
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getStaff())
                    && !StringUtils.isEmpty(queryPayment.getStaff().getFirstName())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleJoin.get("firstName"),
                        queryPayment.getStaff().getFirstName())); //拼接副表中的查询条件
            }

            //payment->customer->name
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getCustomer())
                    && !StringUtils.isEmpty(queryPayment.getCustomer().getFirstName())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleCustomerJoin.get("firstName"),
                        queryPayment.getCustomer().getFirstName())); //拼接副表中的查询条件
            }
            //payment->customer->address->phone
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getCustomer())
                    && !StringUtils.isEmpty(queryPayment.getCustomer().getAddress().getPhone())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleCustomerJoin.get("address").get("phone"),
                        queryPayment.getCustomer().getAddress().getPhone())); //拼接副表中的查询条件
            }
            query.where(predicate);
            query.distinct(true);
            return query.getRestriction();
        };
        Page<Payment> payments = paymentRepository.findAll(Specification.where(specification), pageable);
        return payments;
    }
}
