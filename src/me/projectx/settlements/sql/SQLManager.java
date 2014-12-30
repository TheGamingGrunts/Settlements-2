package me.projectx.settlements.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import me.projectx.settlements.Settlements;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * A very simple SQLManager class. Waaay more lightweight and easier to use than the old one. Also uses Prepared Statements!
 *
 * @author mattrick
 */
public class SQLManager {

	private static SQLManager manager;

	private FileConfiguration fc = Settlements.getPlugin().getConfig();
	private Connection conn;

	private SQLManager() {
		manager = this;
	}

	/**
	 * Gets the current SQLManager instance
	 *
	 * @return The current SQLManager instance
	 */
	public static SQLManager getManager() {
		if (manager != null) {
			return manager;
		}
		return new SQLManager();
	}

	/**
	 * Connects to the MySQL database
	 */
	public void connect() {
		Properties connectionProps = new Properties();
		connectionProps.put("user", fc.getString("mysql.user"));
		connectionProps.put("password", fc.getString("mysql.password"));
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://" +
							fc.getString("mysql.host") +
							":3306/" + fc.getString("mysql.database"), connectionProps);
		} catch (SQLException e) {
			System.out.println("Could not connect to MySQL database, are the connection paramaters correct?");
			e.printStackTrace();
		}
		setupTables();
	}

	/**
	 * Sets up tables for use in Settlements
	 */
	public void setupTables(){
		//TODO Needs to be tested, I did a lot without double checking to see if they work :P
		update("CREATE TABLE IF NOT EXISTS settlements(id BIGINT, leader BIGINT, name VARCHAR(255), description VARCHAR(255), deleted TINYINT(1))");
		update("CREATE TABLE IF NOT EXISTS citizens(id BIGINT, name VARCHAR(16), uuid VARCHAR(255), settlement BIGINT, rank TINYINT(3))");
		update("CREATE TABLE IF NOT EXISTS chunks(id BIGINT, player BIGINT, world VARCHAR(255), x BIGINT, z BIGINT");
		update("CREATE TABLE IF NOT EXISTS alliances(id BIGINT, setA BIGINT, setB BIGINT)");
		update("CREATE TABLE IF NOT EXISTS wars(id BIGINT, setA BIGINT, setB BIGINT)");
		update("CREATE TABLE IF NOT EXISTS sethomes(id BIGINT, x BITINT, y BIGINT, z BIGINT, pitch BIGINT, yaw BIGINT, world VARCHAR(255), player BIGINT)");
	}

	/**
	 * Sends a query out to the database.
	 *
	 * For use with UPDATE and CREATE queries.
	 *
	 * @param sql A valid SQL statement (replace values with ? marks)
	 * @param args An Object that will replace the ? marks. Put IN THE ORDER of the ? mark you want to replace
	 * @throws SQLException
	 */
	public void update(String sql, Object... args){
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets information from the database
	 *
	 * For use with SELECT
	 *
	 * @param sql A valid SQL statement
	 * @param args An Object that will replace the ? marks. Put IN THE ORDER of the ? mark you want to replace
	 * @return A ResultSet of the query executed
	 * @throws SQLException
	 */
	public ResultSet query(String sql, Object... args){
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeQuery();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
