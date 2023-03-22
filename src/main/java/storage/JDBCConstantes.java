package storage;

interface JDBCConstantes {
    String DELETE_USERS = "truncate table users";
    String SELECT_USERS = "select*from users";
    String DELETE_BY_USERNAME = "delete from users where username=?";
    String INSERT_USERS = "insert into users values(default, ?, ?, ?)";
    String INSERT_OPERATIONS = " insert into operations values (default,?,?,?,?)";
    String FIND_OPERATIONS_BY_TYPE = "select *from operations where type=?";
    String DELETE_BY_TYPE = "delete from operations where type=?";
    String SELECT_OPERATIONS = "select *from operations";
    String DELETE_OPERATIONS = "truncate table operations";
    String FIND_USER_BY_USERNAME = "select * from users where username = ?";

}
