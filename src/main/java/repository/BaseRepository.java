package repository;


import model.basemodel.BaseModel;

import java.io.Serializable;
import java.util.List;


public interface BaseRepository<T extends BaseModel<ID> , ID extends Serializable> {
    ID create(T t);
    T read(ID id);
    T update (ID id, T t);
    ID delete(ID id);
    List<T> findAll();
}
