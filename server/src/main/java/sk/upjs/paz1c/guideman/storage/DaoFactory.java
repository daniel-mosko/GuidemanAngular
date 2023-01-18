package sk.upjs.paz1c.guideman.storage;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

public enum DaoFactory {

	INSTANCE;

	private JdbcTemplate jdbcTemplate;
	private UserDao userDao;
	private LocationDao locationDao;
	private EventDao eventDao;
	private TourDao tourDao;
	private boolean testing;
	// tu zmenit na false
	// ked je true tak je to testovacia databaza

	public void testing() {
		testing = true;
	}

	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new MysqlUserDao(getJdbcTemplate());
		}
		return userDao;
	}

	public LocationDao getLocationDao() {
		if (locationDao == null) {
			locationDao = new MysqlLocationDao(getJdbcTemplate());
		}
		return locationDao;
	}

	public EventDao getEventDao() {
		if (eventDao == null) {
			eventDao = new MysqlEventDao(getJdbcTemplate());
		}
		return eventDao;
	}

	public TourDao getTourDao() {
		if (tourDao == null) {
			tourDao = new MysqlTourDao(getJdbcTemplate());
		}
		return tourDao;
	}

	private JdbcTemplate getJdbcTemplate() {
    if (jdbcTemplate == null) {
      MysqlDataSource dataSource = new MysqlDataSource();
      if (testing) {
        dataSource.setDatabaseName("guidemantest");
        dataSource.setUser("guideman2022test");
        dataSource.setPassword("test");
      } else {
        dataSource.setDatabaseName("guideman");
        dataSource.setUser("guideman2022");
        dataSource.setPassword("eE87#H06g");
      }
      jdbcTemplate = new JdbcTemplate(dataSource);
    }
    return jdbcTemplate;
  }
	}

