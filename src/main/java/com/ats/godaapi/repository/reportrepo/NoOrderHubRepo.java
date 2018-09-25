package com.ats.godaapi.repository.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.dashreport.NoOrderHub;

public interface NoOrderHubRepo  extends JpaRepository<NoOrderHub, Integer>{
	
	@Query(value = "SELECT m_hub.hub_id,m_hub.hub_eng_name,m_hub.hub_mar_name,m_hub.hub_contact_no FROM "
			+ " m_hub WHERE m_hub.hub_id NOT IN "
			+ "(SELECT m_dist.hub_id FROM m_dist,t_order_header WHERE "
			+ " m_dist.dist_id!=t_order_header.dist_id AND t_order_header.order_date=:curDate) ", nativeQuery = true)
	
	List<NoOrderHub> getNoOrderHub(@Param("curDate") String curDate);

}
