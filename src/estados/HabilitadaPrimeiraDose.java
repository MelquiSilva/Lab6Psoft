package estados;

import controllers.GovernoController;
import models.Pessoa;

import java.util.Collections;

public class HabilitadaPrimeiraDose extends Estado{

    public HabilitadaPrimeiraDose() {
        super.status = "A pessoa está habilitada a tomar a primeira dose";
    }

    @Override
    public void checar(GovernoController governo, Pessoa pessoa){
        boolean checagemNecessaria = true;
        for (String comorbidade: pessoa.getComorbidades()){
            if(governo.getComorbidadesValidas().contains(comorbidade)){
                checagemNecessaria = false;
                break;
            }
        }
        if(governo.getProfissoesValidas().contains(pessoa.getProfissao())){
            checagemNecessaria = false;
        }
        if(pessoa.getIdade() >= governo.getIdadeValida()){
            checagemNecessaria = false;
        }
        if(checagemNecessaria) {
            pessoa.setEstado(new NaoHabilitado());
        }
    }

    @Override
    public String avancarStatus(Pessoa pessoa){
        pessoa.setEstado(new TomouPrimeiraDose());
        return "Primeira dose tomada";
    }

}
