package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Sservice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface ISserviceDao extends IBaseDao<Sservice,Integer> {
    Page<Sservice> findAllByServicenameContaining(String searchText, Pageable pageable);
}
