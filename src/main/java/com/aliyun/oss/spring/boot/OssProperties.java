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
 * @author <a href="mailto:fangjian0423@gmail.com">Jim</a>
 * @author xiaolongzuo
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

    private boolean enabled;
    
    /**
     * Endpoint, please see <a href=
     * "https://help.aliyun.com/document_detail/32010.html?spm=a2c4g.11186623.6.659.29f145dc3KOwTh">oss
     * docs</a>.
     */
    private String endpoint;
    
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

    public OssAuthorizationMode getAuthorizationMode() {
        return authorizationMode;
    }

    public void setAuthorizationMode(OssAuthorizationMode authorizationMode) {
        this.authorizationMode = authorizationMode;
    }

    public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public ClientBuilderConfiguration getConfig() {
        return config;
    }

    public void setConfig(ClientBuilderConfiguration config) {
        this.config = config;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    
    public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public StsToken getSts() {
        return sts;
    }

    public void setSts(StsToken sts) {
        this.sts = sts;
    }

    public static class StsToken {

        private String accessKey;

        private String secretKey;

        private String securityToken;

        private String roleArn = "<role-arn>";
    	
        private String roleSessionName = "<session-name>";
    	
        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public String getSecurityToken() {
            return securityToken;
        }

        public void setSecurityToken(String securityToken) {
            this.securityToken = securityToken;
        }

		public String getRoleArn() {
			return roleArn;
		}

		public void setRoleArn(String roleArn) {
			this.roleArn = roleArn;
		}

		public String getRoleSessionName() {
			return roleSessionName;
		}

		public void setRoleSessionName(String roleSessionName) {
			this.roleSessionName = roleSessionName;
		}

    }

}
