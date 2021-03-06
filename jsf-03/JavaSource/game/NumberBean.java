package game;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
import java.util.ResourceBundle;

public class NumberBean {

  private Integer userNumber; 
  private int randomNumber; 

  public NumberBean () {
    randomNumber = (int)(Math.random()*100);
    System.out.println ( "Random number: "+randomNumber);
  }

  public void setUserNumber (Integer value){ this.userNumber = value; }
  public Integer getUserNumber () { return this.userNumber; } 

  // CONTROLLER
  public String playagain () {
    // obtem o contexto do jsf
    FacesContext context = FacesContext.getCurrentInstance();

    // usa o contexto para recuperar a sessao http
    HttpSession session = 
	    (HttpSession) context.getExternalContext().
	    	getSession(false);

    // invalida a sessao
    session.invalidate();

    return "playagain"; 
  }

  // checa o numero escolhido pelo usuario
  public String checkGuess () {
     
    if ( userNumber.intValue() == randomNumber ) {
      return "success";
    } else {
      // obtem o contexto do jsf
      FacesContext context = 
	      FacesContext.getCurrentInstance();

      // Pegando referencia para arquivo de mensagens (usa o contexto)
      ResourceBundle bundle =
                ResourceBundle.getBundle("game.messages",
                    	context.getViewRoot().getLocale());

      System.out.println("Locale: "+
		      context.getViewRoot().getLocale());

      String msg = "";

      // se o numero for maior
      if ( userNumber.intValue() > randomNumber ) 
         msg = bundle.getString("tryagain_smaller");
      else // se o numero for menor
         msg = bundle.getString("tryagain_bigger");
      
      // addicionando a mensagem para ser apresentada <h:messages>
      context.addMessage (null, new FacesMessage(msg)); 

      // null indica a inicializacao da aplicacao (cria uma nova instancia para numberBean)
      return null;
    }
  }
}
