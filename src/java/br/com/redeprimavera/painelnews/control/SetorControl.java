package br.com.redeprimavera.painelnews.control;

import br.com.redeprimavera.painelnews.model.bean.SetorAtendimento;
import br.com.redeprimavera.painelnews.model.dao.SetorAtendimentoDAO;
import br.com.redeprimavera.painelnews.model.util.MessagesView;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.LineChartModel;

@ManagedBean
@RequestScoped
public class SetorControl extends Control {

    private List<SetorAtendimento> setores;
    private SetorAtendimentoDAO dao;

    @PostConstruct
    public void init() {
        try {
            initSetores();
        } catch (SQLException ex) {
            MessagesView.msgError("Erro ao listar Setores", ex.getMessage());
        }
    }

    private void initSetores() throws SQLException {
        begin();
        dao = new SetorAtendimentoDAO();
        setores = dao.getAllLast12(getConnection());
        end();
    }

    public List<SetorAtendimento> getSetores() {
        return setores;
    }

    private LineChartModel animatedModel;

    public LineChartModel getAnimatedModel() {
        return animatedModel;
    }

}
