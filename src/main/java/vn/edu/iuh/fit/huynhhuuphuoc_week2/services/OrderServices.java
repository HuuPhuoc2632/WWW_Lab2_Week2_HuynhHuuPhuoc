package vn.edu.iuh.fit.huynhhuuphuoc_week2.services;

import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Order;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.repositories.OrderRepository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderServices {
    private OrderRepository orderReponsitory;

    public OrderServices() {
        orderReponsitory = new OrderRepository();
    }

    public void insertOrder(Order order){
        orderReponsitory.insertOrder(order);
    }

    public void updateOrder(Order order){
        orderReponsitory.updateOrder(order);
    }

    public List<Order> getAll(){
        return orderReponsitory.getAll();
    }

    public Optional<Order> findById(long id){
        return orderReponsitory.findByOrderId(id);
    }

    public List<Order> getOrdersByDate(Date orderDate){
        java.util.Date date = new java.util.Date(orderDate.getTime());
        List<Order> orderList= getAll();
        if(!orderList.isEmpty()){
            List<Order> list = new ArrayList<>();
            for (Order order: orderList) {
                if(order.getOrderDate()==date){
                    list.add(order);
                }
            }
            return list;
        }
        return null;
    }

    public List<Order> getOrdersByTimePeriod(Date from, Date to) {
        List<Order> list= getAll();
        if (list != null) {
            // Chuyển đổi từ java.sql.Date sang java.util.Date
            java.util.Date fromDate = new java.util.Date(from.getTime());
            java.util.Date toDate = new java.util.Date(to.getTime());
            List<Order> orderList = new ArrayList<>();
            for (Order order : list) {
                if (order.getOrderDate().compareTo(fromDate)!=0 && order.getOrderDate().compareTo(toDate)!=0) {
                    orderList.add(order);
                }
            }
            return orderList;
        }
        return null;
    }

    public List<Order> getOrdersByPeriod(long empId, Date from, Date to) {
        //Kiểm tra nhân viên còn làm hay khong
        List<Order> list = orderReponsitory.findByEmployeeId(empId);
        if (list != null) {
            List<Order> orderList = getOrdersByTimePeriod(from,to);
            if(!orderList.isEmpty())
                return orderList;
        }
        return null;
    }
}
