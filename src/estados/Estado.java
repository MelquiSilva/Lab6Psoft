package estados;

import controllers.GovernoController;
import models.Pessoa;

public class Estado {
    protected String status;
    public void checar(GovernoController governo, Pessoa pessoa){

    }

    public String avancarStatus(Pessoa pessoa){
        return "A pessoa não pode avançar Status, ela não está habilitada";
    }

    public String getStatus() {
        return status;
    }
}
