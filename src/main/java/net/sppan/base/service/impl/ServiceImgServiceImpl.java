package net.sppan.base.service.impl;

import net.sppan.base.dao.IServiceImgDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Serviceimg;
import net.sppan.base.service.IServiceImgService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceImgServiceImpl extends BaseServiceImpl<Serviceimg,Integer> implements IServiceImgService {
    @Autowired
    IServiceImgDao serviceImgDao;

    @Override
    public IBaseDao<Serviceimg, Integer> getBaseDao() {
        return null;
    }

    @Override
    public Page<Serviceimg> findAllByServiceid(Integer serviceid, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Set<Serviceimg> findAllByServiceid(Integer serviceid) {
        return null;
    }

    @Override
    public Integer deleteAllByServiceid(Integer serviceid) {
        return serviceImgDao.deleteAllByServiceid(serviceid);
    }
}
