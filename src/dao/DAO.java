package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import package2.MENU;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import connector.database;
import package2.MENU;

public class DAO {
	
	Random random = new Random();
	
	private Connection connection;
	
	public DAO() {
		
		connection = database.database();
		
	}
	
	public void insert(MENU menu) {

		try {
			Statement stmt = connection.createStatement(); 
			
			String query = String.format("insert into MENU values ('%s', '%s', '%s','%s')", getLatestKode(), menu.getNama(), menu.getHarga(), menu.getStok());
			
			stmt.execute(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String getLatestKode() {
			String kode = "BC-";
			
			for(int x = 0 ; x < 3 ; x++) {
				kode += random.nextInt(10);
			}
			
			return kode;
		}
		
		
		

	public Vector<Vector<String>> getMenus(){
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		try {
			Statement stmt = connection.createStatement();
			
			String query = "select * from menu";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				Vector<String> subData = new Vector<String>();
				
				subData.add(rs.getString(1));
				subData.add(rs.getString(2));
				subData.add(rs.getString(3));
				subData.add(rs.getString(4));
				
				data.add(subData);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	public void delete(String NamaMenu) {
		
		try {
			Statement stmt = connection.createStatement();
			
			String query = "delete from menu where NamaMenu = '"+NamaMenu+"'";
					
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


