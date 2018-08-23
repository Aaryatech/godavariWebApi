package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Notification;

public interface NotifiRepo extends JpaRepository<Notification, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Notification SET isRead=:isRead   WHERE notifi_id=:notifiId")
	int updateRead(@Param("notifiId") int notifiId, @Param("isRead") int isRead);

	Notification findByNotifiId(int notifiId);

	List<Notification> findByNotifiToAndNotifiTypeAndIsRead(int notifiTo, int notifiType, int isRead);

}