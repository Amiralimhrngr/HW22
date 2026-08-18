package repository.impl;

import model.basemodel.BaseModel;

import repository.BaseRepository;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<T extends BaseModel<ID>, ID extends Serializable> implements BaseRepository<T, ID> {
    @Override
    public ID create(T t) {
        return HibernateUtil.inTxReturn(em -> {
            em.persist(t);
            return t.getId();
        });
    }

    @Override
    public T read(ID id) {
        return HibernateUtil.read(em -> em.find(getEntityClass(), id));
    }

    @Override
    public T update(ID id, T newEntity) {
        return HibernateUtil.inTxReturn(
                em -> {
                    T upgradingEntity = em.find(getEntityClass(), id);
                    settingAttributes(upgradingEntity, newEntity);
                    return upgradingEntity;
                });
    }

    @Override
    public ID delete(ID id) {
        return HibernateUtil.inTxReturn(
                em -> {
                    T t = em.find(getEntityClass(), id);
                    if (t == null) {
                        return id;
                    }
                    em.remove(t);
                    return id;
                }
        );
    }

    @Override
    public List<T> findAll() {
       return HibernateUtil.read(
               em ->
                       em.createQuery("FROM " + getEntityClass().getSimpleName(), getEntityClass()).getResultList());
    }

    public abstract Class<T> getEntityClass();

    public abstract void settingAttributes(T upgradingEntity, T newEntity);
}
