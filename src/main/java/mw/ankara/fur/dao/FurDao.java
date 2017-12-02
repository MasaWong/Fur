package mw.ankara.fur.dao;

import mw.ankara.fur.model.Fur;
import mw.ankara.fur.model.PageInfo;

import java.util.List;

public interface FurDao {

    void add(Fur fur);

    Fur get(String id);

    void update(Fur fur);

    void delete(String id);

    List<Fur> gets(PageInfo page);
}
