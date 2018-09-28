package com.ats.godaapi.repository.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.dashreport.NoOrderDist;

public interface NoOrderDistRepo extends JpaRepository<NoOrderDist, Integer> {
	
	@Query(value = " SELECT m_dist.dist_id,m_dist.dist_eng_name,m_dist.dist_mar_name,m_dist.dist_contact_no "
			+ "FROM m_dist WHERE m_dist.is_used=1 AND m_dist.dist_id NOT IN( SELECT dist_id from t_order_header "
			+ "WHERE order_date=:curDate)", nativeQuery = true)
	
	List<NoOrderDist> getNoOrderDist(@Param("curDate") String curDate);
	
}
