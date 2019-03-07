package com.dyingtime.uid;

import com.dyingtime.uid.impl.CachedUidGenerator;
import com.dyingtime.uid.impl.DefaultUidGenerator;
import com.dyingtime.uid.worker.DisposableWorkerIdAssigner;
import com.dyingtime.uid.worker.WorkerIdAssigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dyingtime
 * @version 1.0
 * @date 2019/3/6 22:29
 * @description
 */
@Configuration
@ConditionalOnClass({DefaultUidGenerator.class, CachedUidGenerator.class})
@EnableConfigurationProperties(UidProperties.class)
public class UidGeneratorAutoConfigure {

    @Autowired
    private UidProperties properties;

    @Bean
    @ConditionalOnMissingBean
    DefaultUidGenerator defaultUidGenerator() {
        return new DefaultUidGenerator(properties);
    }

    @Bean
    @ConditionalOnMissingBean
    CachedUidGenerator cachedUidGenerator() {
        return new CachedUidGenerator(properties);
    }

    @Bean
    @ConditionalOnMissingBean
    WorkerIdAssigner workerIdAssigner() {
        return new DisposableWorkerIdAssigner();
    }
}
