package top.cyanide.GRMS.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类，用于配置Spring在运行时扫描MyBatis的包
 */
@Configuration
@MapperScan(basePackages={"com.briup.bigdata.pre.grms.web.dao"})
public class MyBatisConfig{}
