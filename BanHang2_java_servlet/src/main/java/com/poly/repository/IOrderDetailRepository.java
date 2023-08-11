package com.poly.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Heo;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
	@Query("Select o.heo from OrderDetail o where o.order.createDate = CURRENT_DATE() "
			+ "and o.order.status = 2 Group by o.heo Order by SUM(o.quantity) desc ")
	List<Heo> getBanChayNgay(Pageable pageable);
	@Query("Select SUM(o.quantity) from OrderDetail o where o.order.createDate = CURRENT_DATE() "
			+ "and o.order.status = 2 Group by o.heo Order by SUM(o.quantity) desc ")
	List<Long> getSLBanChayNgay(Pageable pageable);
	@Query("Select SUM(o.quantity * o.price) from OrderDetail o where o.order.createDate = CURRENT_DATE() "
			+ "and o.order.status = 2 Group by o.heo Order by SUM(o.quantity) desc ")
	List<Long> getDTBanChayNgay(Pageable pageable);
	//Tháng
	@Query("Select o.heo from OrderDetail o where Month(o.order.createDate) = Month(CURRENT_DATE()) and Year(o.order.createDate) = Year(CURRENT_DATE()) "
			+ "and o.order.status = 2 Group by o.heo Order by SUM(o.quantity) desc ")
	List<Heo> getBanChaythang(Pageable pageable);
	@Query("Select SUM(o.quantity) from OrderDetail o where Month(o.order.createDate) = Month(CURRENT_DATE()) and Year(o.order.createDate) = Year(CURRENT_DATE()) "
			+ "and o.order.status = 2 Group by o.heo Order by SUM(o.quantity) desc ")
	List<Long> getSLBanChaythang(Pageable pageable);
	@Query("Select SUM(o.quantity * o.price) from OrderDetail o where Month(o.order.createDate) = Month(CURRENT_DATE()) and Year(o.order.createDate) = Year(CURRENT_DATE()) "
			+ "and o.order.status = 2 Group by o.heo Order by SUM(o.quantity) desc ")
	List<Long> getDTBanChaythang(Pageable pageable);
	//Nam
		@Query("Select o.heo from OrderDetail o where  Year(o.order.createDate) = Year(CURRENT_DATE()) "
				+ "and o.order.status = 2 Group by o.heo Order by SUM(o.quantity) desc ")
		List<Heo> getBanChayNam(Pageable pageable);
		@Query("Select SUM(o.quantity) from OrderDetail o where  Year(o.order.createDate) = Year(CURRENT_DATE()) "
				+ "and o.order.status = 2 Group by o.heo Order by SUM(o.quantity) desc ")
		List<Long> getSLBanChayNam(Pageable pageable);
		@Query("Select SUM(o.quantity * o.price) from OrderDetail o where Year(o.order.createDate) = Year(CURRENT_DATE()) "
				+ "and o.order.status = 2 Group by o.heo Order by SUM(o.quantity) desc ")
		List<Long> getDTBanChayNam(Pageable pageable);
		
		
		@Query("Select o from OrderDetail o where o.order = :order")
		List<OrderDetail> getByOrder(@Param("order") Order o);
		
		
		@Query("SELECT  Month(o.order.createDate),SUM(o.price)  FROM OrderDetail o WHERE Year(o.order.createDate) = Year(CURRENT_DATE()) and o.order.status = 2 "
				+ "GROUP by Month(o.order.createDate) "
				+ "ORDER by  Month(o.order.createDate) asc")
		List<Object[]> getChart();  
}
