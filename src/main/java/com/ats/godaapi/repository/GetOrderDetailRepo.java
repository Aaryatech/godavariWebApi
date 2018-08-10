package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetOrderDetail;

public interface GetOrderDetailRepo extends JpaRepository<GetOrderDetail, Integer> {

	@Query(value = "SELECT d.*,s.sa_name,u.user_name ,rel.user_name AS manager_name FROM t_fb_header d,m_sa s,m_user u,m_user rel  WHERE d.del_status=0 AND d.fb_date BETWEEN :fromDate AND :toDate  AND d.company_id=:companyId AND d.sa_id=s.sa_id AND d.rel_man_id=u.user_id AND rel.user_id=d.rel_man_id", nativeQuery = true)
	List<GetOrderDetail> getOrderDetailHistory(@Param("orderHeaderId") int orderHeaderId);

}
