//package annotation.database;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class TableCreator {
	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("arguments: annotated classes");
			System.exit(0);
		}
		for (String className: args) {
			Class<?> cl = Class.forName(className);
			DBTable dbtable = cl.getAnnotation(DBTable.class);
			if (dbtable == null) {
				System.out.println(
					" No DbTable annotations in class " + className);
				continue;
			}
			String tableName = dbtable.name();
			// If the name is empty: use the Class name:
			if(tableName.length() < 1)
				tableName = cl.getName().toUpperCase();
			List<String> columnDefs = new ArrayList<String>();
			String sqlString = "";
			for (Field field : cl.getDeclaredFields()) {
				String columnName = null;
				Annotation[] anns = field.getDeclaredAnnotations();
				if (anns.length < 1)
					continue;
				if (anns[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) anns[0];
					// Use fieldName if name not specified
					if (sInt.name().length() < 1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sInt.name();
					columnDefs.add(columnName + " INT" +
							getConstraints(sInt.constraints()));
				}
				if (anns[0] instanceof SQLString) {
					SQLString sString = (SQLString) anns[0];
					// Use field name if name not specified.
					if (sString.name().length() < 1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sString.name();
					columnDefs.add(columnName + " VARCHAR(" +
							sString.value() + ")" +
							getConstraints(sString.constraints()));
				}
//				if (anns[0] instanceof SQLDouble) {
//					SQLDouble sDouble = (SQLDouble) anns[0];
//					// Use field name if name not specified.
//					if (sDouble.name().length() < 1)
//						columnName = field.getName().toUpperCase();
//					else
//						columnName = sDouble.name();
//					columnDefs.add(columnName + " Double" +
//							getConstraints(sDouble.constraints()));
//				}				
				StringBuilder createCommand = new StringBuilder(
					"CREATE TABLE " + tableName + "(");
				for(String columnDef : columnDefs) 
					createCommand.append("\n	" + columnDef + ",");
				// Removetrailing comma
				String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
				System.out.println("table Creation SQL for " +
					className + " is :\n" + tableCreate);
				sqlString = tableCreate;
			}
			JdbcAccess access = new JdbcAccess("test");
			access.execute(sqlString);
		}
	}
	private static String getConstraints(Constraints con) {
		String constraints = "";
		if (!con.allowNull())
			constraints = " NOT NULL";
		if (con.primaryKey())
			constraints += " PRIMARY KEY ";
		if (con.unique())
			constraints += " UNIQUE";
		return constraints;
	}
}
