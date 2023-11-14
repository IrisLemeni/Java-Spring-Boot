package Controller;

import java.util.ArrayList;

abstract public class BaseController<T> {

    public abstract boolean remove(int id);

    public abstract ArrayList<T> getAll();
}
