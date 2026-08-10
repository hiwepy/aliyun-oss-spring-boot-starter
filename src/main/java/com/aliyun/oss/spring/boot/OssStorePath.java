/** 
 * Copyright (C) 2018 Jeebiz (http://jeebiz.net).
 * All Rights Reserved. 
 */
package com.aliyun.oss.spring.boot;

/**
 * Stores the OSS bucket and object path (plus optional thumbnail path) of an uploaded resource.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class OssStorePath {

    /** OSS bucket name. */
    private String bucket;

    /** Object key (path) within the bucket. */
    private String path;

    /** Optional thumbnail object key (path). */
    private String thumb;

    /** Default constructor. */
    public OssStorePath() {
        super();
    }

    /**
     * Creates a store path for the given bucket and object path.
     * @param bucket the OSS bucket name
     * @param path the object key (path)
     */
    public OssStorePath(String bucket, String path) {
        super();
        this.bucket = bucket;
        this.path = path;
    }

    /**
     * Creates a store path for the given bucket, object path and thumbnail path.
     * @param bucket the OSS bucket name
     * @param path the object key (path)
     * @param thumb the thumbnail object key (path)
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

    /** @return the thumbnail object key (path) */
	public String getThumb() {
		return thumb;
	}

    /** @param thumb the thumbnail object key (path) to set */
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

}
