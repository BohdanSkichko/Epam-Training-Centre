package chapter12.videolibrary;

import java.sql.SQLException;

public class Movies extends BaseTable implements TableOperations{
    public Movies() {
        super("movies");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS movies (Id serial primary key, Name VARCHAR(50), NameActor VARCHAR," +
                "Release_data DATE, Country VARCHAR)","table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }

}
