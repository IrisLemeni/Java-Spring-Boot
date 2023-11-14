package Repository;

import java.util.ArrayList;


public abstract class BaseRepository<T> {

    public abstract void add(T item);

    public abstract boolean remove(int id);

    public abstract ArrayList<T> getAll();
}
