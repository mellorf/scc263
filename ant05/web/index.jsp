<%@ page import="java.sql.*, org.usp.news.*, java.util.*" %>
<jsp:include page="header.jsp" />
<!-- chama header para execução e depois inclui aqui -->

<tr>
	<td>
		<table align="left" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="#dddddd" width="570" class="news">Notícias</td>
				<td bgcolor="#eeeeee" width="200" class="news">RSS</td>
			</tr>
			<tr>
				<td bgcolor="#ffffff" width="570" class="news">
					<table>
					<%

					ResultSet rs = News.findByDateTime();
					News news = null;

					while ((news = News.next(rs)) != null) {
						out.println("<tr><td class=\"newstitle\">"+news.getTitle()+"</td></tr>");
						out.println("<tr><td class=\"newsbody\">"+news.getBody()+"</td></tr>");
						out.println("<tr><td class=\"newsbody\">&nbsp;</td></tr>");
					}

					%>
					</table>
				</td>
				<td bgcolor="#eeeeee" width="200" class="news">
					<table>
					<%

					rs = RSS.findByDateTime();
					RSS rss = null;

					while ((rss = RSS.next(rs)) != null) {
						out.println("<tr><td class=\"rsstitle\">"+rss.getTitle()+"</td></tr>");
						out.println("<tr><td class=\"rssbody\">"+rss.getDescription()+"</td></tr>");
						out.println("<tr><td class=\"rssbody\">&nbsp;</td></tr>");
					}

					%>
					</table>
			
				</td>
			</tr>

		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
