package in.ashokit.dao.impl;

import org.springframework.stereotype.Repository;

import in.ashokit.dao.ReportDao;

@Repository("oracle")
public class OracleReportDaoImpl implements ReportDao{

	@Override
	public String findData() {
		return "OracleReportDaoImpl - Data Generate";
	}

}
