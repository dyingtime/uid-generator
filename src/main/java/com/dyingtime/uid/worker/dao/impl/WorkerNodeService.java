package com.dyingtime.uid.worker.dao.impl;

import com.dyingtime.uid.worker.dao.WorkerNodeDAO;
import com.dyingtime.uid.worker.entity.WorkerNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dyingtime
 * @version 1.0
 * @date 2019/3/7 14:13
 * @description
 */
@Service
public class WorkerNodeService implements WorkerNodeDAO {

    @Autowired
    WorkerNodeRepository workerNodeRepository;

    @Override
    public WorkerNode getWorkerNodeByHostPort(String host, String port) {
        return workerNodeRepository.findByHostNameAndPort(host, port);
    }

    @Override
    public void addWorkerNode(WorkerNode workerNode) {
        workerNodeRepository.save(workerNode);
    }
}
