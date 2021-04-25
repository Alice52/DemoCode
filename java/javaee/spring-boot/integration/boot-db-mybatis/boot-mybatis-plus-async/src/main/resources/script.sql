CREATE TABLE IF NOT EXISTS `boot_cache_all_star_phase`
(
    `id`            BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `phase_code`    VARCHAR(255) NOT NULL COMMENT '阶段编码',
    `phase_name`    VARCHAR(255) NOT NULL COMMENT '阶段名称',
    `start_time`    datetime(3)  NULL COMMENT '阶段开始时间',
    `end_time`      datetime(3)  NULL COMMENT '阶段结束时间',
    `type`          VARCHAR(255) NULL COMMENT '阶段类型',
    `status`        VARCHAR(255) NULL COMMENT '阶段状态',

    `is_deleted`    tinyint(1)            DEFAULT '0' COMMENT '是否已删除。删除后不可撤回。 0=记录未删除，1=记录已删除',
    `inserted_by`   BIGINT(20)   NULL,
    `updated_by`    BIGINT(20)   NULL,
    `inserted_time` datetime(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    `updated_time`  datetime(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='阶段表';