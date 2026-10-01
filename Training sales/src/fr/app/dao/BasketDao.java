/**
 * 
 */
package fr.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.app.config.DatabaseConnection;
import fr.app.entities.Basket;
import fr.app.entities.Training;

/**
 * 
 */
public class BasketDao implements Dao<Basket> {
	private static final String ID_BASKET_SQL = "ba_id_basket";
	private static final String TOTAL_PRICE_SQL = "ba_total_price";
	private static final String BUY_SQL = "ba_buy";
	
	@Override
	public void create(Basket basket) throws SQLException, ClassNotFoundException {
		String execute = "INSERT INTO basket(ba_total_price, ba_buy) VALUES (?,?);";

		try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(execute,
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setFloat(1, basket.getTotalPrice());
			ps.setBoolean(2, basket.getIsBuy());
			ps.executeUpdate();

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					basket.setId(generatedKeys.getInt(1));
					for (Training training: basket.getListTraining()) {
						execute = "INSERT INTO contains(co_id_basket, co_id_training) VALUES (?,?);";
						
						try (PreparedStatement ps1 = DatabaseConnection.getConnection().prepareStatement(execute)) {
							ps1.setInt(1, basket.getId());
							ps1.setInt(2, training.getId());
							ps1.executeUpdate();
						}
					}
				} else {
					throw new SQLException("Insert succeeded but no ID obtained.");
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.warning("Error create training request: " + e.getLocalizedMessage());
		}
		
	}

	@Override
	public List<Basket> readAll() throws SQLException, ClassNotFoundException {
		List<Basket> listTraining = new ArrayList<Basket>();
		List<Product> listproduct = new ArrayList<Product>();
		String execute = "SELECT ba_id_basket, ba_total_price, ba_buy, co_id_training FROM basket "
				+ "JOIN contains ON constains.co_id_basket = basket.ba_id_basket;";

		try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(execute)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					listTraining.add(new Basket(rs.getInt(ID_BASKET_SQL), rs.getString(TOTAL_PRICE_SQL),
							rs.getBoolean(TOTAL_PRICE_SQL)));
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.warning("Error read all training request: " + e.getLocalizedMessage());
		}
		return listTraining;
	}

	@Override
	public Basket read(int id) throws SQLException, ClassNotFoundException {
		return null;
	}

	@Override
	public void update(Basket t) throws SQLException, ClassNotFoundException {
		
	}

	@Override
	public void delete(Basket t) throws SQLException, ClassNotFoundException {
		
	}

}
