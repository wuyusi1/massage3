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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, Integer>  implements IOrderService {

    @Autowired
    IOrderDao orderDao;

    @Override
    public Page<Order> getByCustomernameContining(String searchText, Pageable pageable) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return orderDao.getAllByCustomernameContaining(searchText,pageable);
    }

    @Override
    public Page<Order> getByOrdertatusAndCustomernameConting(Integer orderstatus, String searchText, Pageable pageable) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return  orderDao.getAllByOrderstatusAndCustomernameContaining(orderstatus,searchText,pageable);
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
            update(tmp);
        }
        else {
            save(order);
        }
    }

    @Override
    public IBaseDao<Order, Integer> getBaseDao() {
        return this.orderDao;
    }
}
