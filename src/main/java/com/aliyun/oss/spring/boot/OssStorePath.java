/** 
 * Copyright (C) 2018 Jeebiz (http://jeebiz.net).
 * All Rights Reserved. 
 */
package com.aliyun.oss.spring.boot;

public class OssStorePath {

    private String bucket;

    private String path;

	/**
	 * 缩略图访问地址（图片类型文件）
	 */
	private String thumb;

    /**
     * 存储文件路径
     */
    public OssStorePath() {
        super();
    }

    /**
     * 存储文件路径
     *
     * @param bucket
     * @param path
     */
    public OssStorePath(String bucket, String path) {
        super();
        this.bucket = bucket;
        this.path = path;
    }

    /**
     * 存储文件路径
     *
     * @param bucket
     * @param path
     * @param thum
     */
    public OssStorePath(String bucket, String path, String thumb) {
        super();
        this.bucket = bucket;
        this.path = path;
        this.thumb = thumb;
    }
    
    /**
     * @return the bucket
     */
    public String getBucket() {
        return bucket;
    }

    /**
     * @param bucket the bucket to set
     */
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	
}
