package storage;

import entity.Operation;

import java.util.List;

public interface OperationStorage {
    void add(Operation operation);

    void deleteOperation(String type);

    List<Operation> findAll();

    void removeStorage();

    public List<Operation> findByOperation(String type);
}
