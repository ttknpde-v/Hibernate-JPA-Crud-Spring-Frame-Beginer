package net.spring.coding.repository;

import java.util.List;
import java.util.Objects;

public interface EmployeeRepository<T> {

/*  public List<Object[]> read(); */
    public T create(T object);
    public List<T> read();
    public T readById(Long id);
    public void update(T object , Long id);
    public void delete(Long id);


}
