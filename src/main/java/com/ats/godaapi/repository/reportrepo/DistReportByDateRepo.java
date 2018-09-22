package com.ats.godaapi.repository.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.report.DistReportByDate;

public interface DistReportByDateRepo extends JpaRepository<DistReportByDate, Integer> {

	@Query(value = "SELECT t_order_header.order_header_id, SUM(t_order_header.order_total) AS order_total, SUM(t_order_header.prev_pending_crate_bal) AS prev_pending_crate_bal,"
			+ "	SUM(t_order_header.crates_received) as crates_received, SUM(t_order_header.crates_issued) AS crates_issued,"
			+ "	SUM(t_order_header.prev_pending_amt) AS prev_pending_amt, SUM(t_order_header.amt_received) amt_received,SUM(t_order_header.bal_amount) as bal_amount,t_order_header.order_date,"
			+ "	 m_dist.dist_eng_name,m_dist.dist_mar_name,m_dist.dist_contact_no FROM m_dist,t_order_header "
			+ "	 WHERE t_order_header.order_date BETWEEN :fromDate AND :toDate AND t_order_header.dist_id IN (:distIdList) AND t_order_header.dist_id=m_dist.dist_id AND t_order_header.order_status=:orderStatus "
			+ "	 GROUP BY t_order_header.dist_id,t_order_header.order_date ", nativeQuery = true)
	List<DistReportByDate> getDistReportByDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("distIdList") List<Integer> distIdList, @Param("orderStatus") int orderStatus);

	@Query(value = " SELECT t_order_header.order_header_id, SUM(t_order_header.order_total) AS order_total,"
			+ " SUM(t_order_header.prev_pending_crate_bal) AS prev_pending_crate_bal,"
			+ " SUM(t_order_header.crates_received) as crates_received,SUM(t_order_header.crates_issued)"
			+ " AS crates_issued,SUM(t_order_header.prev_pending_amt) AS prev_pending_amt,"
			+ " SUM(t_order_header.amt_received) amt_received,SUM(t_order_header.bal_amount) as bal_amount,"
			+ " t_order_header.order_date, m_dist.dist_eng_name, m_dist.dist_mar_name, m_dist.dist_contact_no "
			+ " FROM  m_dist, t_order_header  "
			+ " WHERE  t_order_header.order_date BETWEEN :fromDate AND :toDate AND"
			+ " t_order_header.dist_id=m_dist.dist_id AND  m_dist.hub_id=:hubId AND "
			+ " t_order_header.order_status=:orderStatus  "
			+ " GROUP BY m_dist.hub_id ", nativeQuery = true)
	List<DistReportByDate> getDistReportByDateForHub(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("hubId") int hubId, @Param("orderStatus") int orderStatus);

}
