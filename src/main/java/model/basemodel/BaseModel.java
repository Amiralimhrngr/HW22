package model.basemodel;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public class BaseModel<ID extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ID id;

    public BaseModel() {
    }

    public BaseModel(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
        }

    public void setId(ID id) {
        this.id = id;
    }
}
