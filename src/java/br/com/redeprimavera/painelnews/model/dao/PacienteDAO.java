package br.com.redeprimavera.painelnews.model.dao;

import br.com.redeprimavera.painelnews.model.bean.Paciente;
import br.com.redeprimavera.painelnews.model.exception.SQLConsultException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PacienteDAO extends DAO<Paciente> {

    @Override
    protected Paciente instantElementFromResultSet(Connection connection) throws SQLConsultException {
        Paciente s = new Paciente();
        try {
            s.setCd_pessoa_fisica(getRs().getInt("CD_PESSOA_FISICA"));
            s.setNr_atendimento(getRs().getInt("NR_ATENDIMENTO"));
            s.setNm_pessoa_fisica(getRs().getString("NM_PESSOA_FISICA"));
            s.setNews(new NewsDAO().getAllLast12Hours(connection, s.getNr_atendimento()));
        } catch (SQLException ex) {
            throw new SQLConsultException(ex.getMessage());
        }
        return s;
    }

    public List<Paciente> getAllLast12Hours(Connection connection, int cd_setor_atendimento) throws SQLConsultException {
        return getList(connection, "select distinct v.cd_pessoa_fisica, v.NR_ATENDIMENTO, v.nm_pessoa_fisica from tasy.hp_news_v v where v.dt_sinal_vital >= sysdate - (1/2) and v.CD_SETOR_ATENDIMENTO =" + cd_setor_atendimento);
    }

}
