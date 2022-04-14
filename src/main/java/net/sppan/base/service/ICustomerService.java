package net.sppan.base.service;

import net.sppan.base.entity.Customer;
import net.sppan.base.entity.User;
import net.sppan.base.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


public interface ICustomerService extends IBaseService<Customer, Integer> {
    Customer findByCustomerName(String customername);

    /**
     * 增加或者修改用户
     * @param customer
     */
    void saveOrUpdate(Customer customer);

    /**
     * 给用户分配角色
     * @param id 用户ID
     * @param customerIds 角色Ids
     */
    void grant(Integer id, String[] customerIds);

    /**
     * 根据关键字获取分页
     * @param searchText
     * @param pageRequest
     * @return
     */
    Page<Customer> findAllByLike(String searchText, PageRequest pageRequest);

    /**
     * 修改用户密码
     * @param customer
     * @param oldPassword
     * @param password1
     * @param password2
     */
    void updatePwd(Customer customer, String oldPassword, String password1, String password2);

    Page<Customer> findAllByvip(String searchText,Integer customervip,Pageable pageable);
}
