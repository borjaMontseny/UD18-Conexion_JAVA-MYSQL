package conexionMySQL;

import java.sql.*;
import javax.swing.JOptionPane;

public class Driver {

	// Declaramos la variable de tipo conexion
	public static Connection conexion;

	// METODO QUE ABRE LA CONEXION CON SERVER MYSQL
	public static void openConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC",
					"root", "Facebook2!"); // credenciales temporales
			System.out.print("Server Connected");

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.println(ex.getMessage());

		}

	}

	// METODO QUE CIERRA LA CONEXION CON SERVER MYSQL
	public static void closeConnection() {
		try {
			conexion.close();
			System.out.print("Server Disconnected");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.print("Error cerrando conexion");

		}
	}

	// METODO QUE CREA LA BASE DE DATOS
	public static void createDB(String name) {
		try {
			String Query = "CREATE DATABASE " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("");
			System.out.println("DB creada con exito!");

			JOptionPane.showMessageDialog(null, "Se ha creado la DB " + name + " de forma exitosa.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la DB.");
		}
	}

	// METODO QUE CREA TABLAS MYSQL
	public static void createTable(String db, String name, String query) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name + " " + query;

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");

		}

	}

	// METODO QUE INSERTA DATOS EN TABLAS MYSQL
	public static void insertData(String db, String table_name, String insercion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + " " + insercion;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");
			;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}

	}
	
	// METODO QUE ACTUALIZA (UPDATE) DATOS EN TABLAS MYSQL
	public static void updateData(String db, String table_name, String insercion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "UPDATE " + table_name + " " + insercion;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos actualizados correctamente");
			;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la actualizacion");
		}

	}

	// METODO QUE OBTIENE VALORES MYSQL DEL EJERCICIO 1
	public static void getValues_ex01(String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				System.out.println("");
				System.out.println("Codigo: " + resultSet.getString("Codigo") + " " + "Nombre: "
						+ resultSet.getString("Nombre") + " " + "Precio:" + resultSet.getString("Precio") + " "
						+ "Fabricante: " + resultSet.getString("Fabricante"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}

	}

	// METODO QUE OBTIENE VALORES MYSQL DEL EJERCICIO 2
	public static void getValues_ex02(String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				System.out.println("");
				System.out.println("DNI: " + resultSet.getString("DNI") + " " + "Nombre: "
						+ resultSet.getString("nombre") + " " + "Apellidos:" + resultSet.getString("apellidos") + " "
						+ "Departamento: " + resultSet.getString("departamento"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
	}
		
	// METODO QUE LIMPIA TABLAS MYSQL
	public static void deleteRecord(String db, String table_name, int Codigo) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "DELETE FROM " + table_name + " WHERE Codigo = \"" + Codigo + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Registros de tabla ELIMINADOS con exito!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}

	// METODO QUE ELIMINA TABLAS MYSQL
	public static void deleteTAbla(String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "DROP TABLE " + table_name + ";";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("TABLA ELIMINADA con exito!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando la tabla");
		}
	}
}