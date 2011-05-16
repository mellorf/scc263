<jsp:include page="header.jsp"/>
<%

		String msg = request.getParameter("msg");
		int code = Integer.parseInt(msg);

		switch (code) {
			case 0: out.println("Erro ao inserir notícia!");
				break;
			case 1: out.println("Sucesso ao inserir notícia!");
				break;
			case 2: out.println("Erro ao remover notícia!");
				break;
			case 3: out.println("Sucesso ao remover notícia!");
				break;
			case 4: out.println("Acesso Negado!");
				break;
			case 5: out.println("Sucesso ao editar notícia!");
				break;
			case 6: out.println("Erro ao editar notícia!");
				break;
		}

		%>
<jsp:include page="footer.jsp"/>
