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
 * @author <a href="mailto:fangjian0423@gmail.com">Jim</a>
 */
@ConditionalOnClass(Endpoint.class)
public class OssEndpointAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnAvailableEndpoint
	public OssEndpoint ossEndpoint() {
		return new OssEndpoint();
	}

}
