package de.fhb.dassystem.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class UserDAO extends JdbcDAOBase {
	protected static Logger logger = Logger.getLogger(UserDAO.class.getName());

	public List<User> getall() {
		List<User> users;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sqlStr = "SELECT * FROM user";

		try {
			con = getConnection();
			ps = con.prepareStatement(sqlStr);
			rs = ps.executeQuery();

			users = (List<User>) transformSet(rs);

			logger.info(users.toString());

		} catch (SQLException sqle) {
			throw new DataAccessException("Error executing " + sqlStr, sqle);
		} finally {
			try {
				// close the resources
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException sqlee) {
				throw new DataAccessException("Can't close connection", sqlee);
			}
		}
		return users;

	}

	public List<User> findByEmail(String email) {
		List<User> vos;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sqlStr = "Select * FROM user WHERE email = ?";

		try {
			System.out.println("before Connection");
			con = getConnection();
			System.out.println("after Connection");
			ps = con.prepareStatement(sqlStr);
			ps.setString(1, email);
			System.out.println("Statement");
			rs = ps.executeQuery();
			System.out.println("Query");
			vos = (List<User>) transformSet(rs);
		} catch (SQLException sqle) {
			throw new DataAccessException("Error executing " + sqlStr, sqle);
		} finally {
			try {
				// close the resources
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException sqlee) {
				throw new DataAccessException("Can't close connection", sqlee);
			}
		}
		return vos;
	}

	public User findByID(int id) {
		User vo;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sqlStr = "Select * FROM user WHERE id = ?";

		try {
			System.out.println("before Connection");
			con = getConnection();
			System.out.println("after Connection");
			ps = con.prepareStatement(sqlStr);
			ps.setInt(1, id);
			System.out.println("Statement");
			rs = ps.executeQuery();
			System.out.println("Query");
			vo = (User) transformSetToVO(rs);
		} catch (SQLException sqle) {
			throw new DataAccessException("Error executing " + sqlStr, sqle);
		} finally {
			try {
				// close the resources
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException sqlee) {
				throw new DataAccessException("Can't close connection", sqlee);
			}
		}
		return vo;
	}

	/*
	 * INSERT INTO `user`(`id`, `email`, `forename`, `surname`, `password`,
	 * `birthdate`) VALUES (2,'a@a.de','hans','pettersen','123','1985-10-01')
	 * 
	 * INSERT INTO `user`(`email`, `forename`, `surname`, `password`) VALUES
	 * ('a@a.de','hans','pettersen','123')
	 */
	public void create(User user) {

		Connection con = null;
		PreparedStatement ps = null;

		String sqlStr = "INSERT INTO `user`(`email`, `forename`, `surname`, `password`) VALUES (?,?,?,?)";
		;

		try {
			System.out.println("before Connection");
			con = getConnection();
			System.out.println("after Connection");
			ps = con.prepareStatement(sqlStr);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getForename());
			ps.setString(3, user.getSurname());
			ps.setString(4, user.getPassword());
			System.out.println("Statement");
			ps.executeUpdate();
			System.out.println("Query");
		} catch (SQLException sqle) {
			throw new DataAccessException("Error executing " + sqlStr, sqle);
		} finally {
			try {
				// close the resources
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException sqlee) {
				throw new DataAccessException("Can't close connection", sqlee);
			}
		}

	}

	@Override
	protected Object map2VO(ResultSet rs) throws SQLException {
		User user = new User();
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		return user;
	}

}
