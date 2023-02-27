package storage;

import entity.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationStorage {
    void add(Operation operation);

    Optional<Operation> findByOperation(String type);

    void deleteOperation(String type);

    List<Operation> findAll();

    void removeStorage();

    Optional<Operation> findOperationByUsername(String username);
}
