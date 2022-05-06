package ejercicio1;

public class QuerysEj1 {
	private String queryTablaFabricantes;
	private String queryTablaArticulos;
	private String insertFabricantes;
	private String insertArticulos;
	private String updateFabricantes;
	
	public QuerysEj1() {
		
		this.queryTablaFabricantes = "(codigo int AUTO_INCREMENT,"
				+ "nombre varchar(100) DEFAULT NULL,"
				+ "PRIMARY KEY (codigo));";
		
		this.queryTablaArticulos = "(codigo int AUTO_INCREMENT,"
				+ "nombre varchar(100) DEFAULT NULL,"
				+ "precio int DEFAULT NULL,"
				+ "fabricante int NOT NULL,"
				+ "PRIMARY KEY (codigo),"
				+ "KEY Fabricante (fabricante),"
				+ "FOREIGN KEY (fabricante) REFERENCES fabricantes (codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE);";
		
		this.insertArticulos = "(nombre, precio, fabricante)"
				+ "values "
				+ "('Disco Duro', 40, '1'),"
				+ "('Cooler', 15, '2'),"
				+ "('Thermal Paste', 8, '3'),"
				+ "('Pantalla', 100, '4'),"
				+ "('CPU 4200K', 300, '5');";
		
		this.insertFabricantes = "(nombre)"
				+ "values "
				+ "('Seagate'), "
				+ "('Noctua'), "
				+ "('Cool Master'), "
				+ "('AOC'), "
				+ "('AMD');";

		this.updateFabricantes = "SET"
				+ "nombre = 'AMD Microchips'"
				+ "where nombre = 'AMD';";
	}

	// Getters & Setters
	public String getQueryTablaFabricantes() {
		return this.queryTablaFabricantes;
	}
	
	public String getQueryTablaArticulos() {
		return this.queryTablaArticulos;
	}

	public String getInsertFabricantes() {
		return insertFabricantes;
	}

	public void setInsertFabricantes(String insertFabricantes) {
		this.insertFabricantes = insertFabricantes;
	}

	public String getInsertArticulos() {
		return insertArticulos;
	}

	public void setInsertArticulos(String insertArticulos) {
		this.insertArticulos = insertArticulos;
	}
	
	
	
	
}
