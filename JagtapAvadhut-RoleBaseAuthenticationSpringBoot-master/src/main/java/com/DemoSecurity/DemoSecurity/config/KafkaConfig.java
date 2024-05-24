package com.DemoSecurity.DemoSecurity.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaConfig {

    public static final String LOCATION_TOPICS_NAME="location-update-topic";
    public static final String GROUP_ID="group-1";


    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(LOCATION_TOPICS_NAME)
//               .partitions()
//               .replicas()
                .build();
    }
}
