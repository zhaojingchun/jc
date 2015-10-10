package com.jc.http;


import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-9-28
 * Time: 下午1:46
 * To change this template use File | Settings | File Templates.
 */
public class HttpClientUtil {
    private final static Logger logHttp = LogManager.getLogger(HttpClientUtil.class);
    private int soTimeOut = 5000;
    private String charSet = "utf-8";

    public void setSoTimeOut(int soTimeOut) {
        this.soTimeOut = soTimeOut;
    }
    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String executeHttpRequest(String url, String requestContent,String contentType) {
        HttpClient client = new HttpClient();
        BufferedReader in = null;
        PostMethod postMethod = new PostMethod(url);
        try {
            postMethod.setRequestEntity(new StringRequestEntity(requestContent, contentType, charSet));
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charSet);
            postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, soTimeOut);
            int statusCode = client.executeMethod(postMethod);
            in = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(), charSet));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            if (statusCode != HttpStatus.SC_OK) {
                logHttp.error("Method:HttpClientUtil.executeHttpRequest---->请求返回状态不为200,url:" + url + ",返回结果:" + sb.toString());
                return "";
            }
            logHttp.info("Method:HttpClientUtil.executeHttpRequest---->请求返回状态为200,url:" + url + ",返回结果:" + sb.toString());
            return sb.toString();
        }catch (SocketException e) {
            //连接超时
            logHttp.error("Method:HttpClientUtil.executeHttpRequest----> Connection reset by peer: socket write error,img url:" + url, e);
            return null;
        }
        catch (SocketTimeoutException e) {
            //下载超时
            logHttp.error("Method:HttpClientUtil.executeHttpRequest----> Read timed out,img url:" + url, e);
            return null;
        }catch (Exception e) {
            logHttp.error("Method:HttpClientUtil.executeHttpRequest---->发生异常！请检查网络和参数"+e.getMessage(), e);
        }
        finally {
            if(postMethod!=null){
                postMethod.releaseConnection();
            }
            if(in != null){
                try {
                    in.close();
                } catch (Exception e) {
                    logHttp.error("Method:HttpClientUtil.executeHttpRequest---->发生异常!"+e.getMessage(), e);
                }
            }
        }
        return null;
    }

    public String httpJsonRequest(String url, String requestContent) {
        String contentType =  "application/json; charset=" + charSet;
        return executeHttpRequest(url,requestContent,contentType);
    }

    public String httpXmlRequest(String url, String requestContent) {
        String contentType = "text/xml; charset=" + charSet;
        return executeHttpRequest(url,requestContent,contentType);
    }

    public String httpFormRequest(String url, String requestContent) {
        String contentType = "application/x-www-form-urlencoded; charset=" + charSet;
        return executeHttpRequest(url,requestContent,contentType);

    }

}
