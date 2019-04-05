package io.github.jiezhi.wx.miniapp.error;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-04-01 14:05
 * Function:
 */
public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
