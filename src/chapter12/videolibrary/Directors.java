package chapter12.videolibrary;

import java.sql.SQLException;

public class Directors extends BaseTable implements TableOperations{
    public Directors() {
        super("directors");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS directors (Id serial primary key, Name VARCHAR(50)," +
                "Surname VARCHAR(50), Birthday DATE)","table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
