/** 
 * Copyright (C) 2018 Jeebiz (http://jeebiz.net).
 * All Rights Reserved. 
 */
package com.aliyun.oss.spring.boot;

import java.util.Calendar;
import java.util.Date;

import com.aliyun.oss.OSS;

public class OssTemplate {
	
	private OSS ossClient;
	
	public OssTemplate(OSS ossClient) {
		this.ossClient = ossClient;
	}
	
	/**
	 * 判断当前时间距离第二天凌晨的秒数
	 * 
	 * @return 返回值单位为[s:秒]
	 */
	private long getSecondsNextEarlyMorning() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
	}

	public String getAccsssURL(String group, String path) throws Exception {
		// 过期时间为当日23:59:59
		Date expiration = new Date(getSecondsNextEarlyMorning());
		return getOssClient().generatePresignedUrl(group, path, expiration).toString();
	}
	
	public String getAccsssURL(OssStorePath storePath) throws Exception {
		return this.getAccsssURL(storePath.getBucket(), storePath.getPath());
	}
	
	public String getThumbAccsssURL(OssStorePath storePath) throws Exception {
		return this.getAccsssURL(storePath.getBucket(), storePath.getThumb());
	}
	
	public OSS getOssClient() {
		return ossClient;
	}

}
