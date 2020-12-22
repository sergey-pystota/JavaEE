package by.teachmeskills.module;

public abstract class  Entity implements IEntity {
    protected Long id;

    public Entity() {
    }

    public Entity(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
