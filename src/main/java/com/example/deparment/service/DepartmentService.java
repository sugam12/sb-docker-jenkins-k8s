package com.example.deparment.service;

import com.example.deparment.dto.Order;
import com.example.deparment.entity.Department;
import com.example.deparment.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Department saveDepartment(Department department) {
        departmentRepository.save(department);
        return department;
        // saveOrder(department);
    }

    private void saveOrder(Department department) {
        Order order = new Order();
        order.setOrderStatus(true);
        order.setOrderType("Sales");
        order.setDepartmentId(department.getId());
        try {
            ResponseEntity<Order> orderResponseEntity = restTemplate.postForEntity("http://localhost:8182/order/", order, Order.class);
            Order body = orderResponseEntity.getBody();
            if (body != null) {
                System.out.println("Ok");
            }
        } catch (Exception exception) {

        }

    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow();
    }
}
