package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Customer;
import net.sppan.base.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerDao extends IBaseDao<Customer, Integer> {

    Customer findByCustomername(String customername);

    Customer findById(Integer id);

    Page<Customer> findAllByCustomernicknameContaining(String searchText, Pageable pageable);

    Page<Customer> findAllByCustomernicknameContainingAndCustomervip(String searchText,Integer customervip,Pageable pageable);
}