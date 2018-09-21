package com.ats.godaapi.repository.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.godaapi.model.dashreport.AllHubLatestOrder;

public interface AllHubLatestOrderRepo extends JpaRepository<AllHubLatestOrder, Integer>{
	@Query(value = "SELECT h.order_header_id, h.order_type, h.dist_id, h.order_date, h.order_total,"
			+ "m_dist.dist_eng_name,m_dist.dist_mar_name,m_dist.dist_contact_no FROM t_order_header h,"
			+ "m_dist WHERE h.dist_id=:distId and m_dist.dist_id=h.dist_id ORDER BY h.order_header_id "
			+ "DESC LIMIT 3 ", nativeQuery = true)
	
	
	List<AllHubLatestOrder> getAllHubLatestOrder();
	
	
	

}
