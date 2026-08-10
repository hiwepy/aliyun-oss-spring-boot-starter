package com.aliyun.oss.spring.boot;


/**
 * Alibaba Cloud OSS authorisation modes.
 *
 * @author xiaolongzuo
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public enum OssAuthorizationMode {

    /** Authorise with an AccessKey id and AccessKey secret. */
    AK_SK,
    /** Authorise with a Security Token Service (STS) token. */
    STS

}
