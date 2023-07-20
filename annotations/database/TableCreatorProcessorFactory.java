import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;
import com.sun.mirror.util.*;
import java.util.*;
import static com.sun.mirror.util.DeclarationVisitors.*;

public class TableCreatorProcessorFactory
	implements AnnotationProcessorFactory {
	public AnnotationProcessor getProcessorFor(
		Set<AnnotationTypeDeclaration> atds,
		AnnotationProcessorEnvironment env) {
		return new TableCreatorProcessor(env);
	}
	public Collection<String> supportedAnnotationTypes() {
		return Arrays.asList(
				"DETABLE",
				"Constraints",
				"SQLString",
				"SQLInteger");
	}
	public Collection<String> supportedOptions() {
		return Collections.emptySet();
	}
	private static class TableCreatorProcessor
			implements AnnotationProcessor {
		private final AnnotationProcessorEnvironment env;
		private  String sql = "";
		public TableCreatorProcessor(
			AnnotationProcessorEnvironment env){
			this.env = env;
		}
		public void process() {
			for(TypeDeclaration typeDecl :
				env.getSpecifiedTypeDeclarations()) {
				typeDecl.accept(getDeclarationScanner(
					new TableCreatorVisitor(), NO_OP));
				sql = sql.substring(0, sql.length() - 1) + ")";
				System.out.println("creation SQL is :\n" + sql);
				sql = "";
			}
		}	
		
		private class TableCreatorVisitor
			extends SimpleDeclarationVisitor {
			public void visitClassDeclaration(
				ClassDeclaration d) {
				DBTable dbTable = d.getAnnotation(DBTable.class);
				if (dbTable != null) {
					sql += "CREATE TABLE ";
					sql += (dbTable.name().length() < 1) 
						? d.getSimpleName().toUpperCase() 
						: dbTable.name();
					sql += " (";
				}
			}
			public void visitFieldDeclaration(
				FieldDeclaration d) {
				String columnName = "";
				if (d.getAnnotation(SQLInteger.class) != null)  {
					SQLInteger sInt = d.getAnnotation(SQLInteger.class);
					if(sInt.name().length() < 1)
						columnName = d.getSimpleName().toUpperCase();
					else
						columnName = sInt.name();
					sql += "\n	" + columnName + "	INT" +
						getConstraints(sInt.constraints()) + ",";
				}
				if (d.getAnnotation(SQLDouble.class) != null)  {
					SQLDouble sDouble = d.getAnnotation(SQLDouble.class);
					if(sDouble.name().length() < 1)
						columnName = d.getSimpleName().toUpperCase();
					else
						columnName = sDouble.name();
					sql += "\n	" + columnName + "	Double" +
						getConstraints(sDouble.constraints()) + ",";
				}
				
				if (d.getAnnotation(SQLString.class) != null) {
					SQLString sString = d.getAnnotation(
						SQLString.class);
					if(sString.name().length() < 1)
						columnName = d.getSimpleName().toUpperCase();
					else
						columnName = sString.name();
					sql += "\n	" + columnName + " VARCAHR(" +
						sString.value() + ")" +
						getConstraints(sString.constraints()) + ",";
				}
			}
			private String getConstraints(Constraints con) {
				String constraints = "" ;
				if (!con.allowNull())
					constraints = " NOT NULL";
				if(con.primaryKey())
					constraints += " PRIMARY KEY";
				if (con.unique())
					constraints += " UNIQUE";
				return constraints;
			}
		}
	}
}



