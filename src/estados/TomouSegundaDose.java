package estados;

import models.Pessoa;

public class TomouSegundaDose extends Estado{
    public TomouSegundaDose() {
        super.status = "A pessoa tomou a segunda dose";
    }

    @Override
    public String avancarStatus(Pessoa pessoa){
        return "A pessoa já finalizou sua vacinação";
    }
}
