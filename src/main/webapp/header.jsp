<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table cellspacing="0">
    <tr>
        <td rowspan="2"><a href="index.jsp"><img src="images/clouder.png" width="400" height="60"></a></td>
        <td>
            <div>
                <a href="/locale?loc=en"><button>EN</button></a>
                <a href="/locale?loc=ru"><button>RU</button></a>
            </div>
        </td>
        <td>
            <div id="headerButtons">
                <jsp:include page="/header"/>
            </div>
        </td>
    </tr>
</table>