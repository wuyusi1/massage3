package net.sppan.base.dao;


import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Massager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface IMassagerDao extends IBaseDao<Massager, Integer> {
    //对于按摩师的操作有增删改查和模糊查询，模糊查询按照按摩师名字进行查询
    Page<Massager> findAllByMassagernameContaining(String searchText, Pageable pageable);

}
