package net.sppan.base.service.impl;

import net.sppan.base.dao.IMassagerDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Massager;
import net.sppan.base.service.IMassagerService;
import net.sppan.base.service.support.IBaseService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MassagerServiceImpl extends BaseServiceImpl<Massager,Integer> implements IMassagerService {


    @Autowired
    IMassagerDao massagerDao;

    @Override
    public Page<Massager> findALlByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return massagerDao.findAllByMassagernameContaining(searchText,pageRequest);
    }

    @Override
    public void SaveOrUpdate(Massager massager) {
        if(massager.getId()!= null) {
            Massager tmp=find(massager.getId());
            tmp.setMassagername(massager.getMassagername());
            tmp.setMassagerage(massager.getMassagerage());
            tmp.setMassagertel(massager.getMassagertel());
            tmp.setMassagerjob(massager.getMassagerjob());
            tmp.setMassagersex(massager.getMassagersex());
            tmp.setMassagerinfo(massager.getMassagerinfo());
            tmp.setMassagerinfo(massager.getMassagerinfo());
            update(tmp);
        }
        else{
            save(massager);
        }

    }

    @Override
    public IBaseDao<Massager, Integer> getBaseDao() {
        return this.massagerDao;
    }
}
