package net.sppan.base.service.impl;

import net.sppan.base.common.utils.MD5Utils;
import net.sppan.base.dao.ICustomerDao;
import net.sppan.base.dao.IUserDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Customer;
import net.sppan.base.entity.Resource;
import net.sppan.base.entity.User;
import net.sppan.base.service.ICustomerService;
import net.sppan.base.service.IRoleService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Integer> implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Override
    public Customer findByCustomerName(String customername) {
        return customerDao.findByCustomername(customername);
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        if(customer.getId() != null)
        {
            Customer tmp;
            tmp=find(customer.getId());
            tmp.setCustomeremail(customer.getCustomeremail());
            tmp.setCustomeraddress(customer.getCustomeraddress());
            tmp.setCustomervip(customer.getCustomervip());
            tmp.setCustomername(customer.getCustomername());
            tmp.setCustomernickname(customer.getCustomernickname());
            tmp.setCustomerbirth(customer.getCustomerbirth());
            tmp.setCustomersex(customer.getCustomersex());
            tmp.setCustomertel(customer.getCustomertel());
            update((tmp));
        }else{
            customer.setCustomerdeletestatus(0);
            //customer.setCustomerpwd("111111");
            save(customer);
        }
    }

    @Override
    public void grant(Integer id, String[] customerIds) {

    }

    @Override
    public Page<Customer> findAllByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return customerDao.findAllByCustomernicknameContaining(searchText,pageRequest);
    }

    @Override
    public void updatePwd(Customer customer, String oldPassword, String password1, String password2) {
        Assert.notNull(customer, "??????????????????");
        Assert.notNull(oldPassword, "????????????????????????");
        Assert.notNull(password1, "?????????????????????");
        Assert.notNull(password2, "????????????????????????");

        Customer dbCustomer = customerDao.findByCustomername(customer.getCustomername());
        Assert.notNull(dbCustomer, "???????????????");

        Assert.isTrue(customer.getCustomerpwd().equals(oldPassword), "?????????????????????");;
        Assert.isTrue(password1.equals(password2), "?????????????????????");
        dbCustomer.setCustomerpwd(password1);
        customerDao.saveAndFlush(dbCustomer);
    }

    @Override
    public Page<Customer> findAllByvip(String searchText, Integer customervip, Pageable pageable) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return customerDao.findAllByCustomernicknameContainingAndCustomervip(searchText,customervip,pageable);
    }

    @Override
    public IBaseDao<Customer, Integer> getBaseDao() {
        return this.customerDao;
    }
}
