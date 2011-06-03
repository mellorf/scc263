package events;

import java.util.*;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;

    // Hibernate obriga tal método com construtor vazio
    // Ele utiliza Reflection API para criar objetos, por
    // isso necessita desse construtor
    public Event() {} 
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
