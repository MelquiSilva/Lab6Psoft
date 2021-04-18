package estados;

import models.Pessoa;

public class HabilitadaSegundaDose extends Estado{

    public HabilitadaSegundaDose() {
        super.status = "A pessoa está habilitada a tomar a segunda dose";
    }

    @Override
    public String avancarStatus(Pessoa pessoa){
        pessoa.setEstado(new TomouSegundaDose());
        return "Segunda dose tomada";
    }

}
