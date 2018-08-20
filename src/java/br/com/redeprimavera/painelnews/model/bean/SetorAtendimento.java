package br.com.redeprimavera.painelnews.model.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SetorAtendimento implements Serializable {

    private Integer cd_setor_atendimento;
    private String ds_setor_atendimento;
    private List<Paciente> pacientes;

    public SetorAtendimento(Integer cd_setor_atendimento, String ds_setor_atendimento) {
        this.cd_setor_atendimento = cd_setor_atendimento;
        this.ds_setor_atendimento = ds_setor_atendimento;
    }

    public SetorAtendimento() {
    }
    
    public Integer getCd_setor_atendimento() {
        return cd_setor_atendimento;
    }

    public void setCd_setor_atendimento(Integer cd_setor_atendimento) {
        this.cd_setor_atendimento = cd_setor_atendimento;
    }

    public String getDs_setor_atendimento() {
        return ds_setor_atendimento;
    }

    public void setDs_setor_atendimento(String ds_setor_atendimento) {
        this.ds_setor_atendimento = ds_setor_atendimento;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    @Override
    public String toString() {
        return ds_setor_atendimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cd_setor_atendimento);
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
        final SetorAtendimento other = (SetorAtendimento) obj;
        return Objects.equals(this.cd_setor_atendimento, other.cd_setor_atendimento);
    }

}
