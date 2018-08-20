package br.com.redeprimavera.painelnews.model.dao;

import br.com.redeprimavera.painelnews.model.bean.SetorAtendimento;
import br.com.redeprimavera.painelnews.model.exception.SQLConsultException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SetorAtendimentoDAO extends DAO<SetorAtendimento> {

    @Override
    protected SetorAtendimento instantElementFromResultSet(Connection connection) throws SQLConsultException {
        SetorAtendimento s = new SetorAtendimento();
        try {
            s.setCd_setor_atendimento(getRs().getInt("CD_SETOR_ATENDIMENTO"));
            s.setDs_setor_atendimento(getRs().getString("DS_SETOR_ATENDIMENTO"));
            s.setPacientes(new PacienteDAO().getAllLast12Hours(connection, s.getCd_setor_atendimento()));
        } catch (SQLException ex) {
            throw new SQLConsultException(ex.getMessage());
        }
        return s;
    }

    public List<SetorAtendimento> getAllLast12(Connection connection) throws SQLConsultException {
        return getList(connection, "select CD_SETOR_ATENDIMENTO,DS_SETOR_ATENDIMENTO from tasy.hp_news_setores");
    }

}
