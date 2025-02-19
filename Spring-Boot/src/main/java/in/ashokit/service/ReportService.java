package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import in.ashokit.dao.ReportDao;
/**
 * Service class for implement autowired ReportDao object.
 * @author Bhanu Gawshinde
 * @category Service
 */
@Service
public class ReportService {
	private ReportDao reportDao;
	
	/**
	 * setter method for ReportDao
	 * @param reportDao
	 */
	@Autowired
	@Qualifier("oracle")
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
	/**
	 * method to get data using reportDao object findData method.
	 */
	public void generateData() {
		System.out.println("ReportService : "+reportDao.findData());	
	}
	
	
}
