package chapter12.videolibrary.initializer;

import java.sql.SQLException;

public interface TableOperations {
    void createTable() throws SQLException;
    void createForeignKeys() throws SQLException;
}
