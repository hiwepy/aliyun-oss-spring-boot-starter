package com.aliyun.oss.spring.boot;


/**
 * 阿里云授权模式
 *
 * @author xiaolongzuo
 */
public enum OssAuthorizationMode {

    /**
     * AK/SK授权
     */
    AK_SK,
    /**
     * STS授权
     */
    STS

}
