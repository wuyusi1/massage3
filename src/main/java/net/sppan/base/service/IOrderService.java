package net.sppan.base.service;

import net.sppan.base.entity.Customer;
import net.sppan.base.entity.Order;
import net.sppan.base.service.support.IBaseService;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IBaseService<Order, Integer> {

    Page<Order> getByCustomernameContining(String searchText, Pageable pageable);

    Page<Order>getByOrdertatusAndCustomernameConting(Integer orderstatus,String searchText,Pageable pageable);

    void saveOrUpdate(Order order);
}
