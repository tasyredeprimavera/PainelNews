package br.com.redeprimavera.painelnews.model;

import br.com.redeprimavera.painelnews.model.bean.News;
import br.com.redeprimavera.painelnews.model.bean.Paciente;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
@RequestScoped
public class ChartViewPaciente implements Serializable {

    private LineChartModel animatedModel;

    public LineChartModel getAnimatedModel(Paciente p) {
        createAnimatedModels(p);
        return animatedModel;
    }

    private void createAnimatedModels(Paciente p) {
        animatedModel = initLinearModel(p);
        animatedModel.setTitle(p.getNm_pessoa_fisica());
        animatedModel.setAnimate(true);
        animatedModel.setLegendPosition("se");
        //animatedModel.setSeriesColors("66cc66, 93b75f, E7E658, cc6666");
        Axis yAxis = animatedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(7);
        yAxis.setLabel("Pontuação");
        Axis xAxis = animatedModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(12);
        xAxis.setLabel("S.V");
    }

    private LineChartModel initLinearModel(Paciente p) {
        LineChartModel model = new LineChartModel();
        LineChartSeries series = new LineChartSeries();
        series.setLabel(String.valueOf(p.getNr_atendimento()));
        int i= 0;
        for (News news : p.getNews()) {
            series.set(i++, news.getPontuacao());
            System.out.println(news);
        }
        model.addSeries(series);
        return model;
    }
    
}
