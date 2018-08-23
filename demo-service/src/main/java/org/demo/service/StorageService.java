package org.demo.service;


import java.io.IOException;

import org.demo.common.MultipartFileParam;

/**
 * 存储操作的service
 * Created by qij on 2017/5/2.
 */
public interface StorageService {

    /**
     * 删除全部数据
     */
    void deleteAll();

    /**
     * 初始化方法
     */
    void init();

    /**
     * 上传文件方法1
     *
     * @param param
     * @throws IOException
     */
    void uploadFileRandomAccessFile(MultipartFileParam param) throws IOException;

    /**
     * 上传文件方法2
     * 处理文件分块，基于MappedByteBuffer来实现文件的保存
     *
     * @param param
     * @throws IOException
     */
    void uploadFileByMappedByteBuffer(MultipartFileParam param) throws IOException;
    
    void uploadFileByMappedByteBuffers(MultipartFileParam param) throws IOException;
}
