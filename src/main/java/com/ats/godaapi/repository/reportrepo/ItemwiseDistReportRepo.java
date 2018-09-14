package com.ats.godaapi.repository.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.report.ItemwiseDistReport;

public interface ItemwiseDistReportRepo extends JpaRepository<ItemwiseDistReport, Integer> {

	@Query(value = "SELECT t_order_detail.order_detail_id,m_item.item_eng_name,m_item.item_mar_name,m_item.item_wt,"
			+ "m_uom.uom_name,"
			+ " m_dist.dist_eng_name,m_dist.dist_mar_name,m_dist.dist_contact_no,SUM(t_order_detail.order_qty) "
			+ "AS order_qty,  "
			+ " SUM(t_order_detail.deliver_qty) AS deliver_qty, SUM(t_order_detail.item_total) AS item_total"
			+ "	 FROM m_item,t_order_detail,m_uom,t_order_header,m_dist"
			+ "	 WHERE m_item.item_id=t_order_detail.item_id AND m_item.item_uom_id=m_uom.uom_id"
			+ "	 AND t_order_detail.order_header_id=t_order_header.order_header_id AND t_order_header.order_date "
			+ "	BETWEEN :fromDate AND :toDate"
			+ "	 AND t_order_header.dist_id IN (:distIdList) AND t_order_header.order_status=:orderStatus "
			+ "AND t_order_header.dist_id=m_dist.dist_id"
			+ "	GROUP BY m_item.item_id, t_order_header.dist_id ", nativeQuery = true)
	List<ItemwiseDistReport> getItemwiseDistReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("distIdList") List<Integer> distIdList, @Param("orderStatus") int orderStatus);

}
