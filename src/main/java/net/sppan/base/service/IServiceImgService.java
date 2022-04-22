package net.sppan.base.service;

import net.sppan.base.entity.Serviceimg;
import net.sppan.base.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceImgService extends IBaseService<Serviceimg,Integer> {

    Page<Serviceimg> findAllByServiceid(Integer serviceid, PageRequest pageRequest);

    List<Serviceimg> findAllByServiceid(Integer serviceid);

    Integer deleteAllByServiceid(Integer serviceid);

    Serviceimg findByimgname(String imgname);

    void saveOrUpdate(Serviceimg serviceimg);
}
