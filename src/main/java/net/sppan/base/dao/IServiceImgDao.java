package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Serviceimg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface IServiceImgDao extends IBaseDao<Serviceimg,Integer> {
    Page<Serviceimg> findAllByServiceid(Integer serviceid, Pageable pageable);

    Set<Serviceimg> findAllByServiceid(Integer serviceid);

    Integer deleteAllByServiceid(int serviceid);
}
