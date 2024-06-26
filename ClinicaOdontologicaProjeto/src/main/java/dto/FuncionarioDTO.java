package dto;

import java.util.LinkedList;
import java.util.List;
import model.Funcao;
import model.Funcionario;
import model.Login;

public class FuncionarioDTO extends DTO {

    public String nomeFuncionario;
    public String numeroRegistro;
    public LoginDTO login;
    public Funcao funcao;

    public Funcionario builder() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nomeFuncionario);
        funcionario.setId(id != null ? Long.valueOf(id) : 0l);
        funcionario.setRg(numeroRegistro);

        Login loginModel = new Login();
        loginModel.setId(login.id);
        loginModel.setSenha(login.senha);
        loginModel.setUsuario(login.usuario);
        loginModel.setFuncionario(funcionario);

        funcionario.setLogin(loginModel);
        funcionario.setFuncao(funcao);

        System.out.println(funcionario.getRg());
        return funcionario;
    }

    public List getListaDados(List<Funcionario> dados) {
        List dadosDTO = new LinkedList();
        for (Funcionario dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }

    public Object converte(Funcionario f) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.nomeFuncionario = f.getNome();
        dto.id = f.getId();
        dto.numeroRegistro = f.getRg();
        LoginDTO loginDto = new LoginDTO();
        dto.login = (LoginDTO) loginDto.converte(f.getLogin());
        dto.funcao = f.getFuncao();
        return dto;
    }

    @Override
    public String toString() {
        return this.nomeFuncionario;
    }

}
