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

package com.aliyun.oss.spring.boot;

/**
 * OSS constants.
 *
 * @author <a href="mailto:fangjian0423@gmail.com">Jim</a>
 */
public final class OssConstants {

	/**
	 * Prefix of OSSConfigurationProperties.
	 */
	public static final String PREFIX = "aliyun.oss";

	/**
	 * Enable OSS.
	 */
	public static final String ENABLED = PREFIX + ".enabled";

	/**
	 * OSS ThreadPool bean name.
	 */
	public static final String OSS_TASK_EXECUTOR_BEAN_NAME = "ossTaskExecutor";

	private OssConstants() {
		throw new AssertionError("Must not instantiate constant utility class");
	}

}
