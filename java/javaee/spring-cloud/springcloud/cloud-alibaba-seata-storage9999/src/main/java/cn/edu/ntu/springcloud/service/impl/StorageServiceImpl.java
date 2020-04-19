package cn.edu.ntu.springcloud.service.impl;

import cn.edu.ntu.springcloud.dao.StorageDao;
import cn.edu.ntu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

  private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

  @Resource private StorageDao storageDao;

  /** 扣减库存 */
  @Override
  //@GlobalTransactional(name = "cloud_seata_tx_group")
  public void decrease(Long productId, Integer count) {
    LOGGER.info("------->storage-service中扣减库存开始");
    storageDao.decrease(productId, count);
    LOGGER.info("------->storage-service中扣减库存结束");
  }
}
