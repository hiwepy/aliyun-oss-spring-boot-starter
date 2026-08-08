/** 
 * Copyright (C) 2018 Jeebiz (http://jeebiz.net).
 * All Rights Reserved. 
 */
package com.aliyun.oss.spring.boot;

import java.util.Calendar;
import java.util.Date;

import com.aliyun.oss.OSS;

/**
 * Helper for generating pre-signed access URLs for OSS objects.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class OssTemplate {

	/** The underlying OSS client. */
	private OSS ossClient;

	/**
	 * Creates a template bound to the given client.
	 * @param ossClient the OSS client used to generate pre-signed URLs
	 */
	public OssTemplate(OSS ossClient) {
		this.ossClient = ossClient;
	}

	/**
	 * Generates a pre-signed URL valid until the end of the current day (23:59:59).
	 * @param bucket the OSS bucket name
	 * @param path the object key (path)
	 * @return the pre-signed access URL
	 * @throws Exception if URL generation fails
	 */
	public String getAccsssURL(String bucket, String path) throws Exception {
		// Expiry is set to 23:59:59 of the current day.
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date expiration = new Date(cal.getTimeInMillis());
		return getOssClient().generatePresignedUrl(bucket, path, expiration).toString();
	}

	/**
	 * Generates a pre-signed URL for the main object of the given store path.
	 * @param storePath the bucket/object descriptor
	 * @return the pre-signed access URL
	 * @throws Exception if URL generation fails
	 */
	public String getAccsssURL(OssStorePath storePath) throws Exception {
		return this.getAccsssURL(storePath.getBucket(), storePath.getPath());
	}

	/**
	 * Generates a pre-signed URL for the thumbnail object of the given store path.
	 * @param storePath the bucket/object descriptor
	 * @return the pre-signed thumbnail access URL
	 * @throws Exception if URL generation fails
	 */
	public String getThumbAccsssURL(OssStorePath storePath) throws Exception {
		return this.getAccsssURL(storePath.getBucket(), storePath.getThumb());
	}

	/** @return the underlying OSS client */
	public OSS getOssClient() {
		return ossClient;
	}

}
