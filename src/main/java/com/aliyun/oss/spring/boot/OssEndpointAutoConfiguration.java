package com.aliyun.oss.spring.boot;


import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliyun.oss.spring.boot.actuate.OssEndpoint;

/**
 * OSS {@link Endpoint} Auto-{@link Configuration}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@ConditionalOnClass(Endpoint.class)
public class OssEndpointAutoConfiguration {

	/**
	 * Registers the OSS actuator endpoint when it is available.
	 * @return the OSS endpoint
	 */
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnAvailableEndpoint
	public OssEndpoint ossEndpoint() {
		return new OssEndpoint();
	}

}
