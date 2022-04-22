package net.sppan.base.service;

import net.sppan.base.entity.Serviceimg;
import net.sppan.base.entity.Sservice;
import net.sppan.base.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;

public interface ISserviceService extends IBaseService<Sservice,Integer> {

    public Page<Sservice> findAllByLike(String searchText, PageRequest pageRequest);

    public List<Serviceimg> findAllServiceimg(Integer serviceid);

    public void saveOrUpdate(Sservice sservice);
}
