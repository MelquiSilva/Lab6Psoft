package estados;

import models.Pessoa;

public class TomouPrimeiraDose extends Estado{

    public TomouPrimeiraDose() {
        super.status = "A pessoa tomou a primeira dose";
    }
    @Override
    public String avancarStatus(Pessoa pessoa){
        pessoa.setEstado(new HabilitadaSegundaDose());
        return "Passados 20 dias. A pessoa agora esta habilitada para tomar segunda dose";
    }
}
