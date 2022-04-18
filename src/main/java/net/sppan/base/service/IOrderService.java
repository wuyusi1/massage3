package net.sppan.base.service;

import net.sppan.base.entity.Customer;
import net.sppan.base.entity.Order;
import net.sppan.base.service.support.IBaseService;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IBaseService<Order, Integer> {

    Page<Order> findAllByCustomernameContining(String searchText,Integer orderstatus, PageRequest pageRequest);

    Page<Order>findAllByOrdertatusAndCustomernameConting(Integer orderstatus,String searchText,PageRequest pageRequest);

    void saveOrUpdate(Order order);
}
