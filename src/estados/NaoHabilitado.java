package estados;

import controllers.GovernoController;
import models.Pessoa;


public class NaoHabilitado extends Estado{

    public NaoHabilitado() {
        super.status = "A pessoa não está habilitada a tomar nenhuma dose";
    }

    @Override
    public void checar(GovernoController governo, Pessoa pessoa){
        boolean checagemNecessaria = false;
        for (String comorbidade: pessoa.getComorbidades()){
            if(governo.getComorbidadesValidas().contains(comorbidade)){
                checagemNecessaria = true;
                break;
            }
        }
        if(governo.getProfissoesValidas().contains(pessoa.getProfissao())){
            checagemNecessaria = true;
        }
        if(pessoa.getIdade() >= governo.getIdadeValida()){
            checagemNecessaria = true;
        }
        if(checagemNecessaria) {
            pessoa.setEstado(new HabilitadaPrimeiraDose());
        }

    }
}
