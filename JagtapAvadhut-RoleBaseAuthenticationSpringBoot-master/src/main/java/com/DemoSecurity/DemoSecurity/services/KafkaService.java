package com.DemoSecurity.DemoSecurity.services;

import com.DemoSecurity.DemoSecurity.config.KafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> template;

    public boolean updateLocation(String location){
        template.send(KafkaConfig.LOCATION_TOPICS_NAME,location);
        return true;
    }
}
