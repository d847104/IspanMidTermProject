package com.ycw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ycw.bean.AirBean;

public class AirDaoImpl implements AirDao {
	
	private Connection getConnection() throws NamingException, SQLException{
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/airdb");
		return ds.getConnection();
	}
	
	@Override
	public int getInsert(AirBean airQuality) throws SQLException {
		String sql = "INSERT INTO AirQualityForecast ([content]"
				+ ",[publishtime]"
				+ ",[area]"
				+ ",[majorpollutant]"
				+ ",[forecastdate]"
				+ ",[aqi]"
				+ ",[minorpollutant]"
				+ ",[minorpollutantaqi]) values(?,?,?,?,?,?,?,?)";
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, airQuality.getContent());
			stmt.setDate(2, new Date(airQuality.getPublishtime().getTime()));
			stmt.setString(3, airQuality.getArea());
			stmt.setString(4, airQuality.getMajorPollutant());
			stmt.setDate(5, new Date(airQuality.getForecastDate().getTime()));
			stmt.setInt(6, airQuality.getAqi());
			stmt.setString(7, airQuality.getMinorPollutant());
			stmt.setInt(8, airQuality.getMinorPollutantAqi());
			
			return stmt.executeUpdate();
		} catch (NamingException e) {
			throw new SQLException("資料庫連線錯誤:",e);
		}
		
	}

	@Override
	public int getDelete(int id) throws SQLException {
		String sql = "DELETE FROM AirQualityForecast WHERE id=?";
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (NamingException e) {
			throw new SQLException("資料庫連線錯誤:",e);
		}
	}
	
	@Override
	public void doTruncate() throws SQLException {
		String sql = "TRUNCATE TABLE AirQualityForecast";
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.executeUpdate();
		} catch (NamingException e) {
			throw new SQLException("資料庫連線錯誤:",e);
		}
	}

	@Override
	public int getUpdate(AirBean airQuality) throws SQLException {
		String sql = "UPDATE AirQualityForecast SET "
				+ "[content]=?, "
				+ "[publishtime]=?, "
				+ "[area]=?, "
				+ "[majorpollutant]=?, "
				+ "[forecastdate]=?,"
				+ "[aqi]=?,"
				+ "[minorpollutant]=?,"
				+ "[minorpollutantaqi]=? "
				+ "WHERE id=?";
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, airQuality.getContent());
			stmt.setDate(2, airQuality.getPublishtime());
			stmt.setString(3, airQuality.getArea());
			stmt.setString(4, airQuality.getMajorPollutant());
			stmt.setDate(5, airQuality.getForecastDate());
			stmt.setInt(6, airQuality.getAqi());
			stmt.setString(7, airQuality.getMinorPollutant());
			stmt.setInt(8, airQuality.getMinorPollutantAqi());
			stmt.setInt(9, airQuality.getId());
			
			return stmt.executeUpdate();
		} catch (NamingException e) {
			throw new SQLException("資料庫連線錯誤:",e);
		}
	}
	
	@Override
	public List<String> getAllAreas() throws SQLException {
	    String sql = "SELECT DISTINCT area FROM AirQualityForecast";
	    List<String> areas = new ArrayList<>();
	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            areas.add(rs.getString("area"));
	        }
	    } catch (NamingException e) {
	        throw new SQLException("資料庫連線錯誤:", e);
	    }
	    return areas;
	}

	@Override
	public List<AirBean> getArea(String area) throws SQLException {
		String sql = "SELECT * FROM AirQualityForecast WHERE area=?";
		List<AirBean> airQualityList = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
				
				stmt.setString(1, area);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					AirBean airQuality = new AirBean();
					airQuality.setId(rs.getInt("id"));
					airQuality.setContent(rs.getString("content"));
					airQuality.setPublishtime(rs.getDate("publishtime"));
					airQuality.setArea(rs.getString("area"));
					airQuality.setMajorPollutant(rs.getString("majorpollutant"));
					airQuality.setForecastDate(rs.getDate("forecastdate"));
	                airQuality.setAqi(rs.getInt("aqi"));
	                airQuality.setMinorPollutant(rs.getString("minorpollutant"));
	                airQuality.setMinorPollutantAqi(rs.getInt("minorpollutantaqi"));
	                airQuality.setCreatetime(rs.getDate("createtime"));
	                airQualityList.add(airQuality);
				}				
			} catch (NamingException e) {
				throw new SQLException("資料庫連線錯誤:",e);
			}
		return airQualityList;
	}
	
	@Override
	public List<AirBean> getAll() throws SQLException {
		String sql = "SELECT * FROM AirQualityForecast order by id";
		List<AirBean> airQualityList = new ArrayList<>();
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				AirBean airQuality = new AirBean();
				airQuality.setId(rs.getInt("id"));
				airQuality.setContent(rs.getString("content"));
				airQuality.setPublishtime(rs.getDate("publishtime"));
				airQuality.setArea(rs.getString("area"));
				airQuality.setMajorPollutant(rs.getString("majorpollutant"));
				airQuality.setForecastDate(rs.getDate("forecastdate"));
                airQuality.setAqi(rs.getInt("aqi"));
                airQuality.setMinorPollutant(rs.getString("minorpollutant"));
                airQuality.setMinorPollutantAqi(rs.getInt("minorpollutantaqi"));
                airQuality.setCreatetime(rs.getDate("createtime"));
                airQualityList.add(airQuality);
			}				
		} catch (NamingException e) {
			throw new SQLException("資料庫連線錯誤:",e);
		}
		return airQualityList;
	}
	
//	@Override
//    public List<AirBean> getDate(Date forecastDate) throws SQLException {
//        String sql = "SELECT * FROM air_quality WHERE forecastdate=?";
//        List<AirBean> airQualityList = new ArrayList<>();
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setDate(1, new java.sql.Date(forecastDate.getTime()));
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//            	AirBean airQuality = new AirBean();
//                airQuality.setId(rs.getInt("id"));
//                airQuality.setContent(rs.getString("content"));
//                airQuality.setPublishtime(rs.getDate("publishtime"));
//                airQuality.setArea(rs.getString("area"));
//                airQuality.setMajorPollutant(rs.getString("majorpollutant"));
//                airQuality.setForecastDate(rs.getDate("forecastdate"));
//                airQuality.setAqi(rs.getInt("aqi"));
//                airQuality.setMinorPollutant(rs.getString("minorpollutant"));
//                airQuality.setMinorPollutantAqi(rs.getInt("minorpollutantaqi"));
//                airQualityList.add(airQuality);
//            }
//        } catch (NamingException e) {
//            throw new SQLException("資料庫連線錯誤:",e);
//        }
//        return airQualityList;
//    }
	
	@Override
	public AirBean getOne(int id) throws SQLException {
		String sql = "SELECT * FROM AirQualityForecast WHERE id=?";
		AirBean airQuality = new AirBean();
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
				
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					airQuality.setId(rs.getInt("id"));
					airQuality.setContent(rs.getString("content"));
					airQuality.setPublishtime(rs.getDate("publishtime"));
					airQuality.setArea(rs.getString("area"));
					airQuality.setMajorPollutant(rs.getString("majorpollutant"));
					airQuality.setForecastDate(rs.getDate("forecastdate"));
	                airQuality.setAqi(rs.getInt("aqi"));
	                airQuality.setMinorPollutant(rs.getString("minorpollutant"));
	                airQuality.setMinorPollutantAqi(rs.getInt("minorpollutantaqi"));
	                airQuality.setCreatetime(rs.getDate("createtime"));
				}				
			} catch (NamingException e) {
				throw new SQLException("資料庫連線錯誤:",e);
			}
		return airQuality;
	}
	
	@Override
	public List<AirBean> getAllPaged(int offset, int limit) throws SQLException {
	    String sql = "SELECT * FROM ("
	            + " SELECT *, ROW_NUMBER() OVER (ORDER BY id) AS rownum FROM AirQualityForecast"
	            + ") AS temp WHERE rownum BETWEEN ? AND ?";
	    List<AirBean> airQualityList = new ArrayList<>();
	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, offset + 1); // Start from offset + 1
	        stmt.setInt(2, offset + limit); // End at offset + limit
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            AirBean airQuality = new AirBean();
	            airQuality.setId(rs.getInt("id"));
	            airQuality.setContent(rs.getString("content"));
	            airQuality.setPublishtime(rs.getDate("publishtime"));
	            airQuality.setArea(rs.getString("area"));
	            airQuality.setMajorPollutant(rs.getString("majorpollutant"));
	            airQuality.setForecastDate(rs.getDate("forecastdate"));
	            airQuality.setAqi(rs.getInt("aqi"));
	            airQuality.setMinorPollutant(rs.getString("minorpollutant"));
	            airQuality.setMinorPollutantAqi(rs.getInt("minorpollutantaqi"));
	            airQuality.setCreatetime(rs.getDate("createtime"));
	            airQualityList.add(airQuality);
	        }
	    } catch (NamingException e) {
	        throw new SQLException("資料庫連線錯誤:", e);
	    }
	    return airQualityList;
	}

	@Override
	public int getTotalCount() throws SQLException {
	    String sql = "SELECT COUNT(*) AS total FROM AirQualityForecast";
	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("total");
	        }
	    } catch (NamingException e) {
	        throw new SQLException("資料庫連線錯誤:", e);
	    }
	    return 0;
	}
	
//	@Override
//	public List<AirBean> getAreaPaged(String area, int offset, int limit) throws SQLException {
//	    String sql = "SELECT * FROM ("
//	            + " SELECT *, ROW_NUMBER() OVER (ORDER BY id) AS rownum FROM AirQualityForecast WHERE area=?"
//	            + ") AS temp WHERE rownum BETWEEN ? AND ?";
//	    List<AirBean> airQualityList = new ArrayList<>();
//	    try (Connection conn = getConnection();
//	         PreparedStatement stmt = conn.prepareStatement(sql)) {
//	        stmt.setString(1, area);
//	        stmt.setInt(2, offset + 1); // Start from offset + 1
//	        stmt.setInt(3, offset + limit); // End at offset + limit
//	        ResultSet rs = stmt.executeQuery();
//	        while (rs.next()) {
//	            AirBean airQuality = new AirBean();
//	            airQuality.setId(rs.getInt("id"));
//	            airQuality.setContent(rs.getString("content"));
//	            airQuality.setPublishtime(rs.getDate("publishtime"));
//	            airQuality.setArea(rs.getString("area"));
//	            airQuality.setMajorPollutant(rs.getString("majorpollutant"));
//	            airQuality.setForecastDate(rs.getDate("forecastdate"));
//	            airQuality.setAqi(rs.getInt("aqi"));
//	            airQuality.setMinorPollutant(rs.getString("minorpollutant"));
//	            airQuality.setMinorPollutantAqi(rs.getInt("minorpollutantaqi"));
//	            airQuality.setCreatetime(rs.getDate("createtime"));
//	            airQualityList.add(airQuality);
//	        }
//	    } catch (NamingException e) {
//	        throw new SQLException("資料庫連線錯誤:", e);
//	    }
//	    return airQualityList;
//	}
//
//	@Override
//	public int getCountByArea(String area) throws SQLException {
//	    String sql = "SELECT COUNT(*) AS total FROM AirQualityForecast WHERE area=?";
//	    try (Connection conn = getConnection();
//	         PreparedStatement stmt = conn.prepareStatement(sql)) {
//	        stmt.setString(1, area);
//	        ResultSet rs = stmt.executeQuery();
//	        if (rs.next()) {
//	            return rs.getInt("total");
//	        }
//	    } catch (NamingException e) {
//	        throw new SQLException("資料庫連線錯誤:", e);
//	    }
//	    return 0;
//	}

}
