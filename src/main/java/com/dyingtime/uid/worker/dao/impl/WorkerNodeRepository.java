package com.dyingtime.uid.worker.dao.impl;

import com.dyingtime.uid.worker.entity.WorkerNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dyingtime
 * @version 1.0
 * @date 2019/3/7 14:10
 * @description
 */
@Repository
public interface WorkerNodeRepository extends JpaRepository<WorkerNode, Long> {

    WorkerNode findByHostNameAndPort(String hostname, String port);
}
