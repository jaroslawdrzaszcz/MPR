package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Person;

public class PersonRepository {

	private Connection connection;
	
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	private String createTableSql = "CREATE TABLE person(id INT GENERATED BY DEFAULT AS IDENTITY, name VARCHAR(20), surname VARCHAR(50), age INT)";
	
	private String insertSql = "INSERT INTO person(name, surname, age) VALUES(?,?,?)";
	
	private String updateSQL = "UPDATE person SET name=?, surname=?, age=? WHERE id=?";
	
	private String deleteSQL = "DELETE FROM person WHERE id=?";
	
	private String selectAllSql = "SELECT * FROM person";
	private String selectByIdSql = "SELECT * FROM person WHERE id=?";
	
	private Statement createTable;
	private PreparedStatement insert;
	private PreparedStatement selectAll;
	private PreparedStatement update;
	private PreparedStatement delete;
	private PreparedStatement selectById;
	
	public PersonRepository(){
		
		try {
			connection = DriverManager.getConnection(url);
			createTable = connection.createStatement();
			insert = connection.prepareStatement(insertSql);
			update = connection.prepareStatement(updateSQL);
			delete = connection.prepareStatement(deleteSQL);
			selectAll = connection.prepareStatement(selectAllSql);
			selectById = connection.prepareStatement(selectByIdSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Person> getAll(){
		List<Person> result = new ArrayList<Person>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()){
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setAge(rs.getInt("age"));
				p.setName(rs.getString("name"));
				p.setSurname(rs.getString("surname"));
				result.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Person> getById(){
		List<Person> result = new ArrayList<Person>();
	try{
	ResultSet rs = selectById.executeQuery();
	while(rs.next()){
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setAge(rs.getInt("age"));
		p.setName(rs.getString("name"));
		p.setSurname(rs.getString("surname"));
		result.add(p);
	}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return result;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void add(Person p){
		try {
			insert.setString(1, p.getName());
			insert.setString(2, p.getSurname());
			insert.setInt(3, p.getAge());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updaet(Person p){
		try {
			update.setString(1, p.getName());
			update.setString(2, p.getSurname());
			update.setInt(3, p.getAge());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void delete(Person p){
		try {
			delete.setString(1, p.getName());
			delete.setString(2, p.getSurname());
			delete.setInt(3, p.getAge());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	//wywołać tą metodę
	public void createTable(){
		try {
			createTable.executeUpdate(createTableSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
