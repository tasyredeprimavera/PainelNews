package br.com.redeprimavera.painelnews.model.dao;

import br.com.redeprimavera.painelnews.model.bean.News;
import br.com.redeprimavera.painelnews.model.exception.SQLConsultException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NewsDAO extends DAO<News>{

    @Override
    protected News instantElementFromResultSet(Connection connection) throws SQLConsultException {
        News n = new News();
        try {
            n.setNr_sequencia(getRs().getInt("nr_seq_sinal_vital"));
            n.setDt_sinal_vital(getRs().getDate("dt_sinal_vital"));
            n.setPontuacao(getRs().getInt("vl_news"));
        } catch (SQLException ex) {
            throw new SQLConsultException(ex.getMessage());
        }
        return n;
    }

    public List<News> getAllLast12Hours(Connection connection, int nr_atendimento) throws SQLConsultException {
        return getList(connection, "select v.nr_seq_sinal_vital, v.dt_sinal_vital, v.vl_news from tasy.hp_news_v v where rownum < 13 and v.NR_ATENDIMENTO = " + nr_atendimento + "order by v.nr_seq_sinal_vital");
    }

}
