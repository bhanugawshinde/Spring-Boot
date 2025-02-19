package in.ashokit.dao.impl;

import org.springframework.stereotype.Repository;

import in.ashokit.dao.ReportDao;

@Repository("mysql")
public class MySqlReportDaoImpl implements ReportDao{

	@Override
	public String findData() {
		return "MySqlReportDaoImpl - Generate Data";
	}

}
