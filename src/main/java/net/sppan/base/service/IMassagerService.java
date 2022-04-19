package net.sppan.base.service;

import net.sppan.base.entity.Massager;
import net.sppan.base.entity.User;
import net.sppan.base.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IMassagerService extends IBaseService<Massager,Integer> {

   Page<Massager> findALlByLike(String searchText,PageRequest pageRequest);

   void SaveOrUpdate(Massager massager);
}
