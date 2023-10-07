package com.whgcdx.demo1.domain.response;


import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;


public class ResponseResultDTO<T> {

    private Integer code;
    private  String msg;
    private Boolean success;
    private T data;


    //构造方法
    public ResponseResultDTO(ResponseCodeConst responseCodeConst , String msg){
        this.code = responseCodeConst.code;
        this.msg = msg;
        this.success = responseCodeConst.success;
    }

    public ResponseResultDTO(ResponseCodeConst responseCodeConst , T data){
        this.code = responseCodeConst.code;
        this.data = data;
        this.success = responseCodeConst.success;
    }

    public ResponseResultDTO(ResponseCodeConst responseCodeConst ,T data ,  String msg){
        this.code = responseCodeConst.code;
        this.msg = msg;
        this.data = data;
        this.success = responseCodeConst.success;
    }

    public ResponseResultDTO(ResponseCodeConst responseCodeConst){
        this.code = responseCodeConst.code;
        this.success = responseCodeConst.success;
        this.msg = responseCodeConst.msg;
    }

    public ResponseResultDTO(ResponseResultDTO responseResultDTO){
        this.code = responseResultDTO.getCode();
        this.success = responseResultDTO.getSuccess();
        this.msg = responseResultDTO.getMsg();
        this.data = (T) responseResultDTO.getData();
    }

    public ResponseResultDTO(JSONObject jsonObject) throws JSONException {
        this.code = jsonObject.getInt("code");
        this.data = (T) jsonObject.get("data");
        this.msg = jsonObject.getString("msg");
        this.success = jsonObject.getBoolean("success");
    }


    //内部方法
    public static <T> ResponseResultDTO<T> wrap(ResponseCodeConst responseCodeConst){
        return new ResponseResultDTO(responseCodeConst);
    }
    public static <T> ResponseResultDTO<T> wrap(ResponseCodeConst responseCodeConst , T data){
        return new ResponseResultDTO(responseCodeConst,data);
    }
    public static <T> ResponseResultDTO<T> wrap(ResponseCodeConst responseCodeConst , String msg){
        return new ResponseResultDTO(responseCodeConst,msg);
    }
    public static <T> ResponseResultDTO<T> wrap(ResponseCodeConst responseCodeConst, T data ,String msg){
        return new ResponseResultDTO(responseCodeConst , data ,msg);
    }


    /* Getter and Setter */
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResultDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}
