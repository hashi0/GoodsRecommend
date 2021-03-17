package top.cyanide.GRMS.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类，用于配置Spring在运行时扫描MyBatis的包
 *
 * @author Bai
 */
@Configuration
@MapperScan(basePackages = {"top.cyanide.GRMS.dao"})
public class MyBatisConfig {
}
