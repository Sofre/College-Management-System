package collegeapplication.common;



import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetToTableModel {

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();


        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];

        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnLabel(column);
        }


        DefaultTableModel model = new DefaultTableModel(columnNames, 0);


        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int col = 1; col <= columnCount; col++) {
                row[col - 1] = rs.getObject(col);
            }
            model.addRow(row);
        }

        return model;
    }
}
