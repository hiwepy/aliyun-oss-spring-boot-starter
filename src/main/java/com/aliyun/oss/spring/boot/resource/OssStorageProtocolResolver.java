/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyun.oss.spring.boot.resource;

import com.aliyun.oss.OSS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * A {@link ProtocolResolver} implementation for the {@code oss://} protocol.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class OssStorageProtocolResolver
		implements ProtocolResolver, BeanFactoryPostProcessor, ResourceLoaderAware {

	/**
	 * protocol of oss resource.
	 */
	public static final String PROTOCOL = "oss://";

	private static final Logger log = LoggerFactory
			.getLogger(OssStorageProtocolResolver.class);

	private ConfigurableListableBeanFactory beanFactory;

	private OSS oss;

	/**
	 * Lazily resolves the {@link OSS} client from the bean factory.
	 * @return the OSS client
	 */
	private OSS getOSS() {
		if (this.oss == null) {
			if (this.beanFactory.getBeansOfType(OSS.class).size() > 1) {
				log.warn(
						"There are multiple OSS instances, consider marking one of them as @Primary to resolve oss "
								+ "protocol.");
			}
			this.oss = this.beanFactory.getBean(OSS.class);
		}
		return this.oss;
	}

	/**
	 * Resolves the given location into an OSS resource when it uses the {@code oss://} protocol.
	 * @param location the resource location
	 * @param resourceLoader the resource loader (unused)
	 * @return the {@link OssStorageResource}, or {@code null} when the protocol does not match
	 */
	@Override
	public Resource resolve(String location, ResourceLoader resourceLoader) {
		if (!location.startsWith(PROTOCOL)) {
			return null;
		}
		return new OssStorageResource(getOSS(), location, beanFactory);
	}

	/**
	 * Registers this resolver with the default resource loader when applicable.
	 * @param resourceLoader the resource loader to register with
	 */
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		if (DefaultResourceLoader.class.isAssignableFrom(resourceLoader.getClass())) {
			((DefaultResourceLoader) resourceLoader).addProtocolResolver(this);
		}
		else {
			log.warn("The provided delegate resource loader is not an implementation "
					+ "of DefaultResourceLoader. Custom Protocol using oss:// prefix will not be enabled.");
		}
	}

	@Override
	/**
	 * post Process Bean Factory.
	 *
	 * @param beanFactory the bean factory
	 */
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		this.beanFactory = beanFactory;
	}

}
