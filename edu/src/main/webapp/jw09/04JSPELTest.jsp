<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%session.setAttribute("client",new jw09.Client()); %>

    name : ${client.name}
    addr : ${client.addr}
    age : ${client.age}
    
    empty : ${empty client.info}
    
    index 1 value : ${client.info[0]}
    index 2 value : ${client.info[1]}