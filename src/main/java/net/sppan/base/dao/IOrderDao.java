package net.sppan.base.dao;


import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDao extends IBaseDao<Order,Integer> {
    Page<Order> getAllByOrderstatusAndCustomernameContaining(Integer orderstatus, String searchText, Pageable pageable);
    Page<Order> getAllByCustomernameContaining(String searchText, Pageable pageable);
}
