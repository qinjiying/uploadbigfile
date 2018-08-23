package org.demo.common;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.io.FileUtils;


public class DownloadThread extends Thread{
	private MultipartFileParam param;
	private String finalDirPath;
	
	public DownloadThread(MultipartFileParam param ,String finalDirPath) {
		this.param = param;
		this.finalDirPath = finalDirPath;
	}
	public void run() {
		try {
			
	    	   String fileName = param.getName();
	    	   String uploadDirPath = finalDirPath + param.getMd5();
	    	   String tempFileName = fileName + "_tmp";
	    	   File tmpDir = new File(uploadDirPath);
	    	   File tmpFile = new File(uploadDirPath, tempFileName);
	    	   if (!tmpDir.exists()) {
	    		   tmpDir.mkdirs();
	    	   }
	    	   
	    	   RandomAccessFile tempRaf = new RandomAccessFile(tmpFile, "rw");
	    	   FileChannel fileChannel = tempRaf.getChannel();
	    	   System.out.println(param);
	    	   //写入该分片数据
//	        long offset = CHUNK_SIZE * param.getChunk();
	    	   long offset = param.getChunkSize()* param.getChunk();
	    	   System.out.println("offset:"+offset+"chunkSize:"+param.getChunkSize());
	    	   byte[] fileData = param.getFile().getBytes();
//	    	   MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, offset, fileData.length);
//	    	   mappedByteBuffer.put(fileData);
//	    	   // 释放
//	    	   FileMD5Util.freedMappedByteBuffer(mappedByteBuffer);
//	    	   fileChannel.close();
	    	   tempRaf.seek(offset);  
	    	   tempRaf.write(fileData);
	    	   tempRaf.close();
	    	   boolean isOk = checkAndSetUploadProgress(param, uploadDirPath);
	 	 	   if (isOk) {
	 	 		    boolean flag = renameFile(tmpFile, fileName);
	 	 		    System.out.println("upload complete !!" + flag + " name=" + fileName);
	 	 	   }
			} catch (IOException e) {
					e.printStackTrace();
			}
	}
	
    /**
     * 检查并修改文件上传进度
     *
     * @param param
     * @param uploadDirPath
     * @return
     * @throws IOException
     */
    private boolean checkAndSetUploadProgress(MultipartFileParam param, String uploadDirPath) throws IOException {
        String fileName = param.getName();
        File confFile = new File(uploadDirPath, fileName + ".conf");
        RandomAccessFile accessConfFile = new RandomAccessFile(confFile, "rw");
        //把该分段标记为 true 表示完成
        System.out.println("set part " + param.getChunk() + " complete");
        accessConfFile.setLength(param.getChunks());
        accessConfFile.seek(param.getChunk());
        accessConfFile.write(Byte.MAX_VALUE);

        //completeList 检查是否全部完成,如果数组里是否全部都是(全部分片都成功上传)
        byte[] completeList = FileUtils.readFileToByteArray(confFile);
        byte isComplete = Byte.MAX_VALUE;
        for (int i = 0; i < completeList.length && isComplete == Byte.MAX_VALUE; i++) {
            //与运算, 如果有部分没有完成则 isComplete 不是 Byte.MAX_VALUE
            isComplete = (byte) (isComplete & completeList[i]);
            System.out.println("check part " + i + " complete?:" + completeList[i]);
        }

        accessConfFile.close();
        if (isComplete == Byte.MAX_VALUE) {
//            stringRedisTemplate.opsForHash().put(Constants.FILE_UPLOAD_STATUS, param.getMd5(), "true");
//            stringRedisTemplate.opsForValue().set(Constants.FILE_MD5_KEY + param.getMd5(), uploadDirPath + "/" + fileName);
            return true;
        } 
//            else {
//            if (!stringRedisTemplate.opsForHash().hasKey(Constants.FILE_UPLOAD_STATUS, param.getMd5())) {
//                stringRedisTemplate.opsForHash().put(Constants.FILE_UPLOAD_STATUS, param.getMd5(), "false");
//            }
//            if (stringRedisTemplate.hasKey(Constants.FILE_MD5_KEY + param.getMd5())) {
//                stringRedisTemplate.opsForValue().set(Constants.FILE_MD5_KEY + param.getMd5(), uploadDirPath + "/" + fileName + ".conf");
//            }
            return false;
//        }
    }
    
    public boolean renameFile(File toBeRenamed, String toFileNewName) {
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
            return false;
        }
        String p = toBeRenamed.getParent();
        File newFile = new File(p + File.separatorChar + toFileNewName);
        //修改文件名
        return toBeRenamed.renameTo(newFile);
    }
}
