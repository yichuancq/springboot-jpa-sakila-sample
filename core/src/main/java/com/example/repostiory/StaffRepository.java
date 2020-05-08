package com.example.repostiory;

import com.example.domain.staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 * 员工
 */
public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
