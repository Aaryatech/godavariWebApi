package com.ats.godaapi.repository.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.report.CategoryDistReport;

public interface CategoryDistReportRepo extends JpaRepository<CategoryDistReport, Integer> {

	@Query(value = "SELECT m_category.cat_id,m_category.cat_eng_name,m_category.cat_mar_name, COALESCE((select SUM(t_order_detail.order_qty) "
			+ "from t_order_detail,t_order_header,m_item where t_order_detail.item_id=m_item.item_id AND m_item.cat_id=m_category.cat_id AND "
			+ "t_order_header.order_header_id=t_order_detail.order_header_id AND t_order_header.order_date BETWEEN :fromDate AND :toDate AND "
			+ "t_order_header.dist_id IN ( :distIdList) AND t_order_header.order_status=:orderStatus),0) as order_qty,"
			+ "" + "COALESCE((select SUM(t_order_detail.item_total) from t_order_detail,t_order_header,m_item where "
			+ "t_order_detail.item_id=m_item.item_id AND m_item.cat_id=m_category.cat_id AND "
			+ "t_order_header.order_header_id=t_order_detail.order_header_id AND t_order_header.order_date "
			+ "BETWEEN :fromDate AND :toDate AND t_order_header.dist_id IN ( :distIdList)  AND t_order_header.order_status=:orderStatus),0) "
			+ "as item_total FROM m_category ", nativeQuery = true)
	List<CategoryDistReport> getCategoryDistReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("distIdList") List<Integer> distIdList, @Param("orderStatus") int orderStatus);

	@Query(value = "SELECT m_category.cat_id,m_category.cat_eng_name,m_category.cat_mar_name, COALESCE((select SUM(t_order_detail.order_qty) "
			+ "from t_order_detail,t_order_header,m_item where t_order_detail.item_id=m_item.item_id AND m_item.cat_id=m_category.cat_id AND "
			+ "t_order_header.order_header_id=t_order_detail.order_header_id AND t_order_header.order_date BETWEEN :fromDate AND :toDate AND "
			+ " t_order_header.order_status=:orderStatus),0) as order_qty," + ""
			+ "COALESCE((select SUM(t_order_detail.item_total) from t_order_detail,t_order_header,m_item where "
			+ "t_order_detail.item_id=m_item.item_id AND m_item.cat_id=m_category.cat_id AND "
			+ "t_order_header.order_header_id=t_order_detail.order_header_id AND t_order_header.order_date "
			+ "BETWEEN :fromDate AND :toDate   AND t_order_header.order_status=:orderStatus),0) "
			+ "as item_total FROM m_category ", nativeQuery = true)
	List<CategoryDistReport> getAllCategoryDistReport(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("orderStatus") int orderStatus);

	@Query(value = "SELECT m_category.cat_id, m_category.cat_eng_name,"
			+ "    m_category.cat_mar_name, COALESCE((SELECT SUM(t_order_detail.order_qty)"
			+ "    FROM t_order_detail,t_order_header, m_item,m_dist "
			+ "    WHERE t_order_detail.item_id=m_item.item_id " + "        AND m_item.cat_id=m_category.cat_id "
			+ "        AND t_order_header.order_header_id=t_order_detail.order_header_id "
			+ "        AND t_order_header.order_date=:curDate"
			+ "     AND m_dist.dist_id=t_order_header.dist_id AND m_dist.hub_id=:hubId),"
			+ "    0) AS order_qty,COALESCE((SELECT SUM(t_order_detail.item_total) "
			+ "  FROM t_order_detail, t_order_header, m_item,m_dist "
			+ "    WHERE t_order_detail.item_id=m_item.item_id " + "        AND m_item.cat_id=m_category.cat_id "
			+ "        AND t_order_header.order_header_id=t_order_detail.order_header_id "
			+ "        AND t_order_header.order_date=:curDate "
			+ "       AND m_dist.dist_id=t_order_header.dist_id AND m_dist.hub_id=:hubId),"
			+ "    0) AS item_total FROM m_category ", nativeQuery = true)
	List<CategoryDistReport> getHubReportCatWise(@Param("curDate") String curDate, @Param("hubId") int hubId);

	@Query(value = "SELECT m_category.cat_id, m_category.cat_eng_name,"
			+ "    m_category.cat_mar_name, COALESCE((SELECT SUM(t_order_detail.order_qty)"
			+ "    FROM t_order_detail,t_order_header, m_item,m_dist "
			+ "    WHERE t_order_detail.item_id=m_item.item_id " + "        AND m_item.cat_id=m_category.cat_id "
			+ "        AND t_order_header.order_header_id=t_order_detail.order_header_id "
			+ "        AND t_order_header.order_date=:curDate" + "     AND m_dist.dist_id=t_order_header.dist_id),"
			+ "    0) AS order_qty,COALESCE((SELECT SUM(t_order_detail.item_total) "
			+ "  FROM t_order_detail, t_order_header, m_item,m_dist "
			+ "    WHERE t_order_detail.item_id=m_item.item_id " + "        AND m_item.cat_id=m_category.cat_id "
			+ "        AND t_order_header.order_header_id=t_order_detail.order_header_id "
			+ "        AND t_order_header.order_date=:curDate " + "       AND m_dist.dist_id=t_order_header.dist_id),"
			+ "    0) AS item_total FROM m_category ", nativeQuery = true)
	List<CategoryDistReport> getAllHubReportCatWise(@Param("curDate") String curDate);

	@Query(value = "SELECT m_category.cat_id,m_category.cat_eng_name,m_category.cat_mar_name, COALESCE((select SUM(t_order_detail.order_qty) "
			+ "from t_order_detail,t_order_header,m_item,m_dist WHERE t_order_detail.item_id=m_item.item_id AND m_item.cat_id=m_category.cat_id AND "
			+ "t_order_header.order_header_id=t_order_detail.order_header_id AND t_order_header.order_date BETWEEN :fromDate AND :toDate AND "
			+ "t_order_header.dist_id=m_dist.dist_id AND m_dist.hub_id IN (:hubIdList)  AND t_order_header.order_status=:orderStatus),0) as order_qty,"
			+ ""
			+ "COALESCE((select SUM(t_order_detail.item_total) from t_order_detail,t_order_header,m_item,m_dist WHERE "
			+ "t_order_detail.item_id=m_item.item_id AND m_item.cat_id=m_category.cat_id AND "
			+ "t_order_header.order_header_id=t_order_detail.order_header_id AND t_order_header.order_date "
			+ "BETWEEN :fromDate AND :toDate AND t_order_header.dist_id=m_dist.dist_id AND m_dist.hub_id IN (:hubIdList)   AND t_order_header.order_status=:orderStatus),0) "
			+ "as item_total FROM m_category ", nativeQuery = true)
	List<CategoryDistReport> getCategoryDistReportForHubs(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("hubIdList") List<Integer> hubIdList,
			@Param("orderStatus") int orderStatus);

	@Query(value = "SELECT m_category.cat_id,m_category.cat_eng_name,m_category.cat_mar_name, COALESCE((select SUM(t_order_detail.order_qty) "
			+ "from t_order_detail,t_order_header,m_item,m_dist WHERE t_order_detail.item_id=m_item.item_id AND m_item.cat_id=m_category.cat_id AND "
			+ "t_order_header.order_header_id=t_order_detail.order_header_id AND t_order_header.order_date BETWEEN :fromDate AND :toDate AND "
			+ "t_order_header.dist_id=m_dist.dist_id  AND t_order_header.order_status=:orderStatus),0) as order_qty,"
			+ ""
			+ "COALESCE((select SUM(t_order_detail.item_total) from t_order_detail,t_order_header,m_item,m_dist WHERE "
			+ "t_order_detail.item_id=m_item.item_id AND m_item.cat_id=m_category.cat_id AND "
			+ "t_order_header.order_header_id=t_order_detail.order_header_id AND t_order_header.order_date "
			+ "BETWEEN :fromDate AND :toDate AND t_order_header.dist_id=m_dist.dist_id   AND t_order_header.order_status=:orderStatus),0) "
			+ "as item_total FROM m_category ", nativeQuery = true)
	List<CategoryDistReport> getAllCategoryDistReportForHubs(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("orderStatus") int orderStatus);

}
