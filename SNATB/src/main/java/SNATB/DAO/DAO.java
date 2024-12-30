package SNATB.DAO;

import java.util.List;

public abstract class DAO <Entity,Key>{
	public abstract List<Entity> findAll();
	
	public abstract Entity findById(Key key);

    public abstract Entity save(Entity entity);

    public abstract void deleteById(Key key);

    public abstract boolean existsBy(Key key);
}
