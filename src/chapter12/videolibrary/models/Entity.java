package chapter12.videolibrary.models;


import java.io.Serial;
import java.io.Serializable;

public abstract class Entity implements Serializable, Cloneable {
    @Serial
    private static final long serialVersionUID = 1L;
    protected int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;

        Entity entity = (Entity) o;

        return getId() == entity.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public Entity clone() {
        try {
            Entity clone = (Entity) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

