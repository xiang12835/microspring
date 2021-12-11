package online.flyingfish.office.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis 注解版
 *
 */

@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {

            @Override
            public void customize(MybatisConfiguration configuration) {
                // 设置驼峰命名规则
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}