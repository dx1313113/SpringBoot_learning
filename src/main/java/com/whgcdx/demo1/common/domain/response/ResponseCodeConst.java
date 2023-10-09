package com.whgcdx.demo1.common.domain.response;
/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.domain.response
 * @className: ResponseCodeConst
 * @author: dx
 * @description: TODO 定义 response 基本状态码
 * @date: 2023/10/8 21:36
 * @version: 1.0
 */

public class ResponseCodeConst {

    protected int code;

    protected String msg;

    protected boolean success;

//    定义基础返回状态码与状态
    public static final ResponseCodeConst SUCCESS = new ResponseCodeConst(0 ,"操作成功"  , true);
    public static final ResponseCodeConst ERROR_PARAM = new ResponseCodeConst(1 ,"参数异常"  );
    public static final ResponseCodeConst SYSTEM_ERROR = new ResponseCodeConst(2 ,"系统错误"  );
    public static final ResponseCodeConst DEVELOPMENT = new ResponseCodeConst(3 ,"此功能正在开发中"  );
    public static final ResponseCodeConst NOT_EXIST = new ResponseCodeConst(4 ,"数据不存在"  );
    public static final ResponseCodeConst REQUEST_METHOD_ERROR = new ResponseCodeConst(5 ,"请求方法错误"  );
    public static final ResponseCodeConst JSON_FORMAT_ERROR = new ResponseCodeConst(6 ,"JSON格式错误"  );


    public ResponseCodeConst(int code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public ResponseCodeConst(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseCodeConst(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
