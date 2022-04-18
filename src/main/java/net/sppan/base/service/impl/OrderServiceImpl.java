package net.sppan.base.service.impl;

import net.sppan.base.dao.IOrderDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Customer;
import net.sppan.base.entity.Order;
import net.sppan.base.service.IOrderService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, Integer>  implements IOrderService {

    @Autowired
    IOrderDao orderDao;

    @Override
    public Page<Order> findAllByCustomernameContining(String searchText,Integer orderstatus, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return orderDao.findAllByCustomernameContainingAndOrderstatusGreaterThan(searchText,orderstatus,pageRequest);
    }

    @Override
    public Page<Order> findAllByOrdertatusAndCustomernameConting(Integer orderstatus, String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return  orderDao.findAllByOrderstatusAndCustomernameContaining(orderstatus,searchText,pageRequest);
    }

    @Override
    public void saveOrUpdate(Order order) {
        if(order.getId()!=null)
        {
            Order tmp=find(order.getId());
            tmp.setCustomername(order.getCustomername());
            tmp.setCustomertel(order.getCustomertel());
            tmp.setServicename(order.getServicename());
            tmp.setMassagername(order.getMassagername());
            tmp.setOrderstatus(order.getOrderstatus());
            tmp.setServiceprice(order.getServiceprice());
            tmp.setOrderdeletestatus(order.getOrderdeletestatus());
            tmp.setCustomervip(order.getCustomervip());
            tmp.setCreatedate(order.getCreatedate());
            tmp.setUpdatedate(new Date());
            System.out.println(order.toString());
            update(tmp);
        }
        else {

            order.setCreatedate(new Date());
            order.setUpdatedate(new Date());
            //dSystem.out.println(order.toString());
            save(order);
        }
    }

    @Override
    public IBaseDao<Order, Integer> getBaseDao() {
        return this.orderDao;
    }
}
