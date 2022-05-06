package ejercicio1;

// usaremos los metodos de la clase Driver
import conexionMySQL.Driver;

public class ejercicio1App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuerysEj1 ej1 = new QuerysEj1();

		// Nos conectamos al MySQL, funcionará si las credenciales están bien
		Driver.openConnection();

		// Los DELETE. cruD

		// CRUD C [Create]
		// Creamos la DB, por parámetro le daremos el nombre que le queremos poner
		Driver.createDB("informatica");

		// Creamos tabla("nombreBD", "nombreTabla", queryTabla)
		Driver.createTable("informatica", "fabricantes", ej1.getQueryTablaFabricantes());

		Driver.createTable("informatica", "articulos", ej1.getQueryTablaArticulos());

		Driver.insertData("informatica", "fabricantes", ej1.getInsertFabricantes());

		Driver.insertData("informatica", "articulos", ej1.getInsertArticulos());

		// CRUD R [Read]
		// select * from
		// Me da error porqué enseña el precio en fabricantes, y esta tabla no tiene ese
		// parámetro
		// debo perfeccionar el método si encuentro la oportunidad
		Driver.getValues_ex01("informatica", "articulos");
		Driver.getValues_ex01("informatica", "fabricantes");

		// CRUD U [Update]
		// Inserto into "bd", "table", queryUpdate
		// Puede dar error MySQL 1175, hay que desactivar el modo seguro para realizar
		// el update
		Driver.updateData("informatica", "fabricantes", null);
	}

}
