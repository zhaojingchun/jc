<%--
  Created by IntelliJ IDEA.
  User: zhaojingchun
  Date: 15-10-10
  Time: 下午5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>服务器线程信息</title>
</head>
<body>
<%
    for(Map.Entry<Thread,StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()){
        Thread thread = (Thread)stackTrace.getKey();
        StackTraceElement[] stack = (StackTraceElement[])stackTrace.getValue();
        if(thread.equals(Thread.currentThread())){
            continue;
        }
        out.print("\n 线程： "+thread.getName()+"\n");
        for(StackTraceElement element : stack){
            out.print("\t 线程： "+element+"\n");
        }

    }
%>
</body>
