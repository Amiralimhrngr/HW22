package service.impl;

import exception.EntityNotFoundException;
import model.basemodel.BaseModel;
import repository.BaseRepository;
import service.BaseService;

import java.io.Serializable;
import java.util.List;


public abstract class BaseServiceImpl<T extends BaseModel<ID>, ID extends Serializable, R extends BaseRepository<T, ID>> implements BaseService<T, ID, R> {
    R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public ID create(T t) {
        validation(t);
        return repository.create(t);
    }

    @Override
    public T read(ID id) throws EntityNotFoundException {
        T t = repository.read(id);
        if (t == null) {
            throw new EntityNotFoundException("Couldn't find entity!");
        }
        return t;
    }

    @Override
    public T update(ID id, T t) throws EntityNotFoundException {
        validation(t);
        try {
            return repository.update(id, t);
        } catch (NullPointerException e) {
            throw new EntityNotFoundException("Couldn't find " + t.getClass().getSimpleName());
        }
    }

    @Override
    public ID delete(ID id) {
        return repository.delete(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    public abstract void validation(T t);
}
