package storage;

import entity.Operation;

import java.util.Optional;

public interface OperationStorage {
    void add(Operation operation);

    Optional<Operation> findByOperation(String type);
}
