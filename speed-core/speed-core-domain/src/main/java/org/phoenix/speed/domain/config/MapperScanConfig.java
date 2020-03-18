package org.phoenix.speed.domain.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan("org.phoenix.speed.domain.dao")
@Component
public class MapperScanConfig {
}
