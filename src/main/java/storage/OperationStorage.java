package storage;

import entity.Operation;

import java.util.List;

public interface OperationStorage {
    void add(Operation operation);

    List<Operation> findByOperation(String type);

    void deleteOperation(String type);

    List<Operation> findAll();

    void removeStorage();

}
