/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.model;
import java.io.Serializable;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

 @Entity // Para decir que sera la entidad a mapear por el ORM
 @Table(name = "evento") // Le asignamos un nombre de tabla
 @Getter // Lombok para evitar crear los métodos get de forma manual
 @Builder // Para usar el patrón builder
 @Setter // Lombok para evitar crear los métodos set de forma manual
 @AllArgsConstructor  // Lombok para evitar crear el constructor con todos los argumentos de forma manual
 @NoArgsConstructor // Lombok para evitar crear el constructor sin los argumentos de forma manual
/**
 *
 * @author KevinHP
 */
public class evento implements Serializable {
    @Id // Declaramos que este campo va a ser el identificador
//    @GeneratedValue(generator = "UUID") // Será generado de forma automática
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    ) // Tipo de estrategia a utilizar para autegeneral el campo
@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long idevento;
     private String nombreEvento;
     private String tipo;
     private String alcance;
     private int edicion;
     private Date fechaInicio;
     private Date fechaFin;
     private String prog_evento;

    public evento(String nombreEvento, String tipo, String alcance, int edicion, Date fechaInicio, Date fechaFin, String prog_evento) {
        this.nombreEvento = nombreEvento;
        this.tipo = tipo;
        this.alcance = alcance;
        this.edicion = edicion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.prog_evento = prog_evento;
    }
     
     
}
