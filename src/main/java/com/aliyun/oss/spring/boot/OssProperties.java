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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.aliyun.oss.ClientBuilderConfiguration;


/**
 * {@link ConfigurationProperties} for configuring OSS.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @author xiaolongzuo
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@ConfigurationProperties(OssConstants.PREFIX)
public class OssProperties {

    /**
     * Authorization Mode, please see <a href=
     * "https://help.aliyun.com/document_detail/32010.html?spm=a2c4g.11186623.6.659.29f145dc3KOwTh">oss
     * docs</a>.
     */
    @Value("${" + OssConstants.PREFIX + ".authorization-mode:AK_SK}")
    private OssAuthorizationMode authorizationMode;

    /** Whether the OSS auto-configuration is enabled. */
    private boolean enabled;

    /** Default OSS bucket. */
	private String bucket;

    /**
     * Endpoint, please see <a href=
     * "https://help.aliyun.com/document_detail/32010.html?spm=a2c4g.11186623.6.659.29f145dc3KOwTh">oss
     * docs</a>.
     */
    private String endpoint;

    /** Logical bucket name. Defaults to {@code <default>}. */
    private String bucketName = "<default>";

    /**
     * alibaba cloud access key.
     */
    private String accessKey;

    /**
     * alibaba cloud secret key.
     */
    private String secretKey;

    /**
     * Sts token, please see <a href=
     * "https://help.aliyun.com/document_detail/32010.html?spm=a2c4g.11186623.6.659.29f145dc3KOwTh">oss
     * docs</a>.
     */
    private StsToken sts;

    /**
     * Client Configuration, please see <a href=
     * "https://help.aliyun.com/document_detail/32010.html?spm=a2c4g.11186623.6.659.29f145dc3KOwTh">oss
     * docs</a>.
     */
    private ClientBuilderConfiguration config;

    /**
     * Returns the authorization mode.
     *
     * @return the authorization mode
     */
    public OssAuthorizationMode getAuthorizationMode() {
        return authorizationMode;
    }

    /**
     * Sets the authorization mode.
     *
     * @param authorizationMode the authorization mode
     */
    public void setAuthorizationMode(OssAuthorizationMode authorizationMode) {
        this.authorizationMode = authorizationMode;
    }

    /**
     * Returns the enabled.
     *
     * @return the enabled
     */
    public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * Returns the bucket.
	 *
	 * @return the bucket
	 */
	public String getBucket() {
		return bucket;
	}

	/**
	 * Sets the bucket.
	 *
	 * @param bucket the bucket
	 */
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	/**
	 * Returns the config.
	 *
	 * @return the config
	 */
	public ClientBuilderConfiguration getConfig() {
        return config;
    }

    /**
     * Sets the config.
     *
     * @param config the config
     */
    public void setConfig(ClientBuilderConfiguration config) {
        this.config = config;
    }

    /**
     * Returns the endpoint.
     *
     * @return the endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the endpoint.
     *
     * @param endpoint the endpoint
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    
    /**
     * Returns the bucket name.
     *
     * @return the bucket name
     */
    public String getBucketName() {
		return bucketName;
	}

	/**
	 * Sets the bucket name.
	 *
	 * @param bucketName the bucket name
	 */
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	/**
	 * Returns the access key.
	 *
	 * @return the access key
	 */
	public String getAccessKey() {
		return accessKey;
	}

	/**
	 * Sets the access key.
	 *
	 * @param accessKey the access key
	 */
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	/**
	 * Returns the secret key.
	 *
	 * @return the secret key
	 */
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * Sets the secret key.
	 *
	 * @param secretKey the secret key
	 */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	/**
	 * Returns the sts.
	 *
	 * @return the sts
	 */
	public StsToken getSts() {
        return sts;
    }

    /**
     * Sets the sts.
     *
     * @param sts the sts
     */
    public void setSts(StsToken sts) {
        this.sts = sts;
    }

    /** Security Token Service (STS) credentials used by the {@link OssAuthorizationMode#STS} mode. */
    public static class StsToken {

    	/**
         * STS Endpoint, please see <a href=
         * "https://help.aliyun.com/document_detail/28756.html?spm=a2c4g.11186623.6.791.62d327f1QNuJxZ">STS
         * Docs</a>.
         */
        private String endpoint;

        /** Temporary access key id issued by STS. */
        private String accessKey;

        /** Temporary access key secret issued by STS. */
        private String secretKey;

        /** Temporary security token issued by STS. */
        private String securityToken;

        /** ARN of the role assumed for the STS session. Defaults to {@code <role-arn>}. */
        private String roleArn = "<role-arn>";

        /** Name of the STS role session. Defaults to {@code <session-name>}. */
        private String roleSessionName = "<session-name>";
    	
        /**
         * Returns the endpoint.
         *
         * @return the endpoint
         */
        public String getEndpoint() {
			return endpoint;
		}

		/**
		 * Sets the endpoint.
		 *
		 * @param endpoint the endpoint
		 */
		public void setEndpoint(String endpoint) {
			this.endpoint = endpoint;
		}

		/**
		 * Returns the access key.
		 *
		 * @return the access key
		 */
		public String getAccessKey() {
            return accessKey;
        }

        /**
         * Sets the access key.
         *
         * @param accessKey the access key
         */
        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        /**
         * Returns the secret key.
         *
         * @return the secret key
         */
        public String getSecretKey() {
            return secretKey;
        }

        /**
         * Sets the secret key.
         *
         * @param secretKey the secret key
         */
        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        /**
         * Returns the security token.
         *
         * @return the security token
         */
        public String getSecurityToken() {
            return securityToken;
        }

        /**
         * Sets the security token.
         *
         * @param securityToken the security token
         */
        public void setSecurityToken(String securityToken) {
            this.securityToken = securityToken;
        }

		/**
		 * Returns the role arn.
		 *
		 * @return the role arn
		 */
		public String getRoleArn() {
			return roleArn;
		}

		/**
		 * Sets the role arn.
		 *
		 * @param roleArn the role arn
		 */
		public void setRoleArn(String roleArn) {
			this.roleArn = roleArn;
		}

		/**
		 * Returns the role session name.
		 *
		 * @return the role session name
		 */
		public String getRoleSessionName() {
			return roleSessionName;
		}

		/**
		 * Sets the role session name.
		 *
		 * @param roleSessionName the role session name
		 */
		public void setRoleSessionName(String roleSessionName) {
			this.roleSessionName = roleSessionName;
		}

    }

}
