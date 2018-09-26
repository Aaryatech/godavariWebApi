package com.ats.godaapi.repository.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.dashreport.HubLatestOrder;

public interface HubLatestOrderRepo extends JpaRepository<HubLatestOrder, Integer>{
	@Query(value = "SELECT h.order_header_id, h.order_type, h.order_total,h.order_date, m_hub.hub_id,m_hub.hub_eng_name,m_hub.hub_mar_name,"
			+ "m_hub.hub_contact_no FROM t_order_header h,m_dist, m_hub WHERE h.dist_id=m_dist.dist_id "
			+ "AND m_dist.hub_id=:hubId and m_hub.hub_id=m_dist.hub_id ORDER BY m_hub.hub_id DESC LIMIT 3 ", 
			nativeQuery = true)
	
	List<HubLatestOrder> getAllHubLatestOrder(@Param("hubId") int hubId);
	
}
