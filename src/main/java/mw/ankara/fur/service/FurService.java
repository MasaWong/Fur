package mw.ankara.fur.service;

import mw.ankara.fur.dao.FurDao;
import mw.ankara.fur.model.Fur;
import mw.ankara.fur.model.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FurService {

    @Autowired
    private FurDao furDao;

    public void addFur(Fur fur) {
        furDao.add(fur);
    }

    public Fur getFurBy(String id) {
        return furDao.get(id);
    }

    public void updateFur(Fur fur) {
        furDao.update(fur);
    }

    public void deleteFur(String id) {
        furDao.delete(id);
    }

    public List<Fur> getFursAt(int page) {
        return furDao.gets(new PageInfo(page * 20, 20));
    }
}
