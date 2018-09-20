package com.jiaxin.dubbo.base;

import org.apache.commons.lang3.StringUtils;

/**
 * 返回给web客户端的响应对象类
 * @author <a href="mailto:ken.wu@wolaidai.com">ken.wu</a>
 */
public class ResponseVo<T> {

    /**
     * 响应状态码
     */
    private Integer status = 200;

    /**
     * 响应码
     */
    private String code;

    /**
     * 描述信息
     */
    private String message = "success";

    /**
     * 响应明细
     */
    private T data;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 版本号
     */
    private int version = 1;

    public ResponseVo() {}

    public ResponseVo(T data) {
        this.data = data;
    }

    /**
     * 设置http状态响应码为200，并返回ResponseVo的建造者对象
     * @return
     */
    public static ResponseVoBuilder ok() {
        return ResponseVoBuilder.create().status(200);
    }

    /**
     * 设置设置相应数据对象，并返回ResponseVo的建造者对象
     * @param data
     * @return
     */
    public static <T> ResponseVoBuilder data(T data) {
        return ok().data(data);
    }

    public ResponseVo(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseVo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }

    public static class ResponseVoBuilder {

        private int status;
        private Object data;
        private String code;
        private String message;

        public static ResponseVoBuilder create() {
            return new ResponseVoBuilder();
        }

        /**
         * 设置http状态响应码
         * @param status
         * @return
         */
        public ResponseVoBuilder status(int status) {
            this.status = status;
            return this;
        }

        /**
         * 设置相应数据对象
         * @param data
         * @return
         */
        public ResponseVoBuilder data(Object data) {
            this.data = data;
            return this;
        }

        /**
         * 设置业务响应码
         * @param code
         * @return
         */
        public ResponseVoBuilder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * 设置响应信息
         * @param message
         * @return
         */
        public ResponseVoBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ResponseVo<?> build() {
            ResponseVo<?> response = new ResponseVo<>(data);
            if (status != 0) {
                response.setStatus(status);
            }
            if (StringUtils.isNotBlank(message)) {
                response.setMessage(message);
            }
            response.setCode(code);
            return response;
        }
    }
}
