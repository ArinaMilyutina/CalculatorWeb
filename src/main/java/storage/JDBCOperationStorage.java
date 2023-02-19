package storage;

import entity.Operation;

import java.util.Optional;

public class JDBCOperationStorage implements OperationStorage {
    @Override
    public void add(Operation operation) {

    }

    @Override
    public Optional<Operation> findByOperation(String type) {
        return Optional.empty();
    }
}
