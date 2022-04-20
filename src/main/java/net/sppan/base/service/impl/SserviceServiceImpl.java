package net.sppan.base.service.impl;

import net.sppan.base.dao.IServiceImgDao;
import net.sppan.base.dao.ISserviceDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Serviceimg;
import net.sppan.base.entity.Sservice;
import net.sppan.base.service.ISserviceService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SserviceServiceImpl extends BaseServiceImpl<Sservice,Integer> implements ISserviceService {

    @Autowired
    ISserviceDao sserviceDao;

    @Autowired
    IServiceImgDao serviceImgDao;

    @Override
    public IBaseDao<Sservice, Integer> getBaseDao() {
        return this.sserviceDao;
    }

    @Override
    public Page<Sservice> findAllByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return sserviceDao.findAllByServicenameContaining(searchText,pageRequest);
    }

    @Override
    public Set<Serviceimg> findAllServiceimg(Integer serviceid) {
        return serviceImgDao.findAllByServiceid(serviceid);
    }

    @Override
    public void saveOrUpdate(Sservice sservice) {
        if(sservice.getId()!=null) {
            Sservice tmp=find(sservice.getId());
            tmp.setServicename(sservice.getServicename());
            tmp.setServiceinfo(sservice.getServiceinfo());
            tmp.setServiceprice(sservice.getServiceprice());
            tmp.setServicefunc(sservice.getServicefunc());
            tmp.setServicetag(sservice.getServicetag());
            tmp.setServicehavesaved(sservice.getServicehavesaved());
            tmp.setServicedeletestatus(sservice.getServicedeletestatus());
            update(tmp);
        }
        else{
            save(sservice);
        }
    }
}
