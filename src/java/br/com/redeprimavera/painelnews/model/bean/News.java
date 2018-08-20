package br.com.redeprimavera.painelnews.model.bean;

import java.util.Date;
import java.util.Objects;

public class News {

    private Integer nr_sequencia;
    private Date dt_sinal_vital;
    private int pontuacao;

    public News(Integer nr_sequencia, Date dt_sinal_vital, int pontuacao) {
        this.nr_sequencia = nr_sequencia;
        this.dt_sinal_vital = dt_sinal_vital;
        this.pontuacao = pontuacao;
    }

    public News() {}

    public Integer getNr_sequencia() {
        return nr_sequencia;
    }

    public void setNr_sequencia(Integer nr_sequencia) {
        this.nr_sequencia = nr_sequencia;
    }

    public Date getDt_sinal_vital() {
        return dt_sinal_vital;
    }

    public void setDt_sinal_vital(Date dt_sinal_vital) {
        this.dt_sinal_vital = dt_sinal_vital;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "News{" + "nr_sequencia=" + nr_sequencia + ", dt_sinal_vital=" + dt_sinal_vital + ", pontuacao=" + pontuacao + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.nr_sequencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final News other = (News) obj;
        return (!Objects.equals(this.nr_sequencia, other.nr_sequencia));
    }

}
