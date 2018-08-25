package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetItem;

public interface GetItemRepo extends JpaRepository<GetItem, Integer> {

	@Query(value = "SELECT i.* ,sum(o.order_qty) as order_qty FROM m_item i ,m_category c,t_order_detail o ,t_order_header h WHERE i.cat_id=c.cat_id  AND c.cat_id=:catId AND o.item_id=i.item_id AND h.order_date=:orderDate AND  h.order_header_id=o.order_header_id GROUP BY o.item_id", nativeQuery = true)
	List<GetItem> getData(@Param("catId") int catId, @Param("orderDate") String orderDate);

	@Query(value = "SELECT i.* ,sum(o.order_qty) as order_qty FROM m_item i ,m_category c,t_order_detail o ,t_order_header h WHERE i.cat_id=c.cat_id  AND o.item_id=i.item_id AND h.order_date=:orderDate AND  h.order_header_id=o.order_header_id GROUP BY o.item_id", nativeQuery = true)
	List<GetItem> getDataByDate(@Param("orderDate") String orderDate);

	@Query(value = "SELECT m_item.*,COALESCE((SELECT sum(order_qty) FROM t_order_detail o ,t_order_header h,m_item WHERE o.item_id=m_item.item_id AND h.order_date=:orderDate AND h.order_header_id=o.order_header_id and h.dist_id=:distId GROUP BY o.item_id),0) AS order_qty FROM m_item,m_category WHERE m_item.cat_id=m_category.cat_id AND m_item.cat_id=:catId", nativeQuery = true)
	List<GetItem> getDataByDistId(@Param("distId") int distId, @Param("catId") int catId,
			@Param("orderDate") String orderDate);
}
