package lab6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab6 {
	static Connection conn = null;
	static ResultSet res = null;
	static PreparedStatement stmt = null;

	public static void main(String args[]) {
//		creatDb();
		addClient();
getClients();
//		changeClient();
//		deletClient();
	}

	public static void creatDb() {

		try {
			conn = DbConnection.Connection_to_my_db_Max();
			Statement statement = conn.createStatement();
			String query = "CREATE DATABASE studentDB";
			statement.execute(query);

		} catch (

		SQLException se) {
			se.printStackTrace();
		} 
	}
	
	public static void getClients() {
		try {
			conn = DbConnection.Connection_to_my_db_Max();
			Statement statement = conn.createStatement();
			String query = "select*from clients";
			statement.execute(query);
			res=statement.executeQuery(query);
				while(res.next()) {
					System.out.println(res.getInt(1)+res.getString(2)+res.getString(3)+res.getString(4)+res.getString(5)+res.getString(6)+res.getString(7));
				}
			

		} catch (

		SQLException se) {
			se.printStackTrace();
		} 
	}
		public static void changeClient() {
			try {
				conn = DbConnection.Connection_to_my_db_Max();
				Statement statement = conn.createStatement();
				String query = "update clients set имя='Институт ядерных технологий',телефон='511-11-11' where код_клиента=4";
				statement.execute(query);
				

			} catch (

			SQLException se) {
				se.printStackTrace();
			} 
		}
		public static void deletClient() {
			try {
				conn = DbConnection.Connection_to_my_db_Max();
				Statement statement = conn.createStatement();
				String query = "delete from clients where код_клиента=5";
				statement.execute(query);
				
			} catch (

			SQLException se) {
				se.printStackTrace();
			} 
		}
		public static void addClient() {
			try {
				conn = DbConnection.Connection_to_my_db_Max();
				Statement statement = conn.createStatement();
				String query = "insert into clients values(7,'шуба','Россия','Чебоксары','ул.Петрова 4','237-89-09','mex@mail.ru')";
				statement.execute(query);
				

			} catch (

			SQLException se) {
				se.printStackTrace();
			} 
		}
		
}
