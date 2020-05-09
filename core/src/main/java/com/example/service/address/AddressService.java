package com.example.service.address;

import com.example.domain.address.Address;


/**
 * @author yichuan
 */
public interface AddressService {

    /**
     * 通过ID查询地址
     *
     * @param addressId
     * @return
     */
    Address findOneById(Integer addressId);
}
