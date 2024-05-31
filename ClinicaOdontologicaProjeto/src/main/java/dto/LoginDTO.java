package dto;

import java.util.LinkedList;
import java.util.List;
import model.Login;

public class LoginDTO extends DTO {

    public String usuario;
    public String senha;

    @Override
    public Object builder() {
        Login login = new Login();
        login.setId(id != null ? Long.valueOf(id) : 0l);
        login.setUsuario(usuario);
        login.setSenha(senha);
        return login;
    }
    
     public List getListaDados(List<Login> dados) {
        List dadosDTO = new LinkedList();
        for (Login dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }

    private Object converte(Login l) {
        LoginDTO dto = new LoginDTO();
        dto.usuario = l.getUsuario();
        dto.id = l.getId().toString();
        dto.senha = l.getSenha();
        return dto;
    }
}
