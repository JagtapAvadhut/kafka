package com.DemoSecurity.DemoSecurity.Controller;

import com.DemoSecurity.DemoSecurity.Entites.EmployeeManagement;
import com.DemoSecurity.DemoSecurity.Repository.EmpRepo;
import com.DemoSecurity.DemoSecurity.Dto.EmployeeManagementDto;
import com.DemoSecurity.DemoSecurity.config.KafkaConfig;
import com.DemoSecurity.DemoSecurity.services.KafkaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@RequestMapping("/emp-management")
@RestController
public class EmployeeController {
    @Autowired
    private EmpRepo empRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/new-emp-create")
    public ResponseEntity<Object> createEmp(@RequestBody EmployeeManagementDto management) {
        try {
            EmployeeManagement employeeManagement = modelMapper.map(management, EmployeeManagement.class);
            empRepo.save(employeeManagement);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-emp")
    public ResponseEntity<Object> getAllEmp() {
        try {
            List<EmployeeManagement> all = empRepo.findAll();
            return new ResponseEntity<>(all, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/produce")
    public ResponseEntity<?> updateLocation() {
//        for (int i = 1; i <= 100000; i++) {
        kafkaService.updateLocation("(" + Math.random() * 100 + " , " + Math.random() * 100 + ")");
//        }

        return new ResponseEntity<>(Map.of("massage", "updated successfully"), HttpStatus.OK);
    }

    Queue<String> queue = new LinkedList<>();

    @GetMapping("/consume")
    public ResponseEntity<?> getLocation() {

        return new ResponseEntity<>(queue.poll(), HttpStatus.OK);
    }


    @KafkaListener(topics = KafkaConfig.LOCATION_TOPICS_NAME, groupId = KafkaConfig.GROUP_ID)
    public void kafkaListener(String value) {
        System.out.println(" value :\t" + value);
        queue.offer(value);
    }
}
