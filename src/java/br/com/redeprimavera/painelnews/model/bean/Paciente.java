package br.com.redeprimavera.painelnews.model.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paciente {

    private Integer cd_pessoa_fisica;
    private Integer nr_atendimento;
    private String nm_pessoa_fisica;
    private List<News> news = new ArrayList<>();

    public Integer getCd_pessoa_fisica() {
        return cd_pessoa_fisica;
    }

    public void setCd_pessoa_fisica(Integer cd_pessoa_fisica) {
        this.cd_pessoa_fisica = cd_pessoa_fisica;
    }

    public Integer getNr_atendimento() {
        return nr_atendimento;
    }

    public void setNr_atendimento(Integer nr_atendimento) {
        this.nr_atendimento = nr_atendimento;
    }

    public String getNm_pessoa_fisica() {
        return nm_pessoa_fisica;
    }

    public void setNm_pessoa_fisica(String nm_pessoa_fisica) {
        this.nm_pessoa_fisica = nm_pessoa_fisica;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(nr_atendimento).append(" - ").append(nm_pessoa_fisica).toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.cd_pessoa_fisica);
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
        final Paciente other = (Paciente) obj;
        return Objects.equals(this.cd_pessoa_fisica, other.cd_pessoa_fisica);
    }

}
