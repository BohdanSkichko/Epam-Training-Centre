package chapter12.videolibrary.initializer;

import java.sql.SQLException;

public class MoviesCast extends BaseTable implements  TableOperations{

    public MoviesCast() {
        super("MoviesCast");
    }

    @Override
    public void createTable() throws SQLException {

    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
