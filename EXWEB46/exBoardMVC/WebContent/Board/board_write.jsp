<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
   <head><title>게시판 작성</title>
    <link rel="stylesheet" type="text/css" href="/stylesheet.css">

</head>
 <body topmargin="0" leftmargin="0">
 <!-- 탑 메뉴 영역 삽입-->

<table border="0" width="800">
<tr>
  <td width="20%"  bgcolor="#ecf1ef" valign="top" style="padding-left:0;">
	
	<!--로그인 영역 삽입-->
  </td>
   <script>
   	function send(){
   		if(board.name.value == ""){
   			alert("이름을 입력해주세요!");
   			board.name.focus();
   			return;
   		}
   		if(board.email.value == ""){
   			alert("이메일을 입력해주세요!");
   			board.email.focus();
   			return;
   		}
   		if(board.subject.value == ""){
   			alert("제목을 입력해주세요!");
   			board.subject.focus();
   			return;
   		}
   		if(board.contents.value == ""){
   			alert("내용을 입력해주세요!");
   			board.name.focus();
   			return;
   		}
   		if(board.pass.value == ""){
   			alert("비밀번호를 입력해주세요!");
   			board.pass.focus();
   			return;
   		}
   		board.submit();
   	}
   </script>

   </td>

   <td width="80%" valign="top">&nbsp;<br>
     <img src="Board/img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>반갑습니다</b></font>
     <font size="2"> - 글쓰기</font><p>
     <img src="Board/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="Board/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form method="post" name="board" action="Board?cmd=board_write_pro">
     <input type="hidden" name="page" value="${page }">

	  <table border="0">
       <tr>
         <td width="5%" align="right"><img src="Board/img/bullet-02.gif"></td>
         <td width="15%"><font size="2 face="돋움"">글쓴이</font></td>
         <td width="80%">
         <input type="text" size="20" name="name"></td>
       </tr>
       <tr>
         <td align="right">&nbsp;</td>
         <td ><font size="2 face="돋움"">메일주소</font></td>
         <td>
          <input type="text" size="20" name="email"></td>
       </tr>
	   <tr>
         <td align="right"><img src="Board/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" name="subject" ></td>
       </tr>
       <tr>
         <td align="right"><img src="Board/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60"></textarea></td>
       </tr>
	   <tr>
         <td align="right"><img src="Board/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">비밀번호</font></td>
          <td><input type="password" size="10" name="pass" ><font size="2" face="돋움">*.수정과 삭제시 꼭 입력하셔야 합니다.</font></td>
        </tr>
        <tr></tr>
		<tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td>
                     <a href="javascript:send()"><img src="Board/img/save.gif" border=0></a>&nbsp;&nbsp;&nbsp;
                     <a href="javascript:history.back()"><img src="Board/img/cancle.gif" border=0></a>
          </td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
  </table>
  </body>
  </html>
