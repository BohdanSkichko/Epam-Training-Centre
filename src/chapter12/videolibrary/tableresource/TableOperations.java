package chapter12.videolibrary.tableresource;

import java.sql.SQLException;

public interface TableOperations {
    void createTable() throws SQLException;

    void createForeignKeys() throws SQLException;

    void createUniqueIndex() throws SQLException;


}
