package service;

import model.basemodel.BaseModel;
import repository.BaseRepository;
import java.io.Serializable;
import java.util.List;


public interface BaseService<T extends BaseModel<ID>, ID extends Serializable, R extends BaseRepository<T, ID>> {
    ID create(T t);
    T read(ID id);
    T update (ID uuid, T t);
    ID delete(ID id);
    List<T> findAll();
}
