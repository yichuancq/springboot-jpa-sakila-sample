package com.example.service.payment;

import com.example.domain.payment.Payment;
import com.example.domain.staff.Staff;
import com.example.repostiory.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        //
        //表关联查询 Payment 为主表
        Specification<Payment> specification = (Specification<Payment>) (root, query, cb) -> {
            //
            Predicate predicate = cb.conjunction();
            //left join
            Join<Payment, Staff> ruleJoin = root.join("staff", JoinType.LEFT);
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
            query.where(predicate);
            query.distinct(true);
            return query.getRestriction();
        };
        List<Payment> payments = paymentRepository.findAll(Specification.where(specification));
        return payments;
    }
}
