package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Serviceimg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceImgDao extends IBaseDao<Serviceimg,Integer> {
    Page<Serviceimg> findAllByServiceid(Integer serviceid, Pageable pageable);

    List<Serviceimg> findAllByServiceid(Integer serviceid);

    Serviceimg findByImgname(String imgname);

    Integer deleteAllByServiceid(int serviceid);
}
