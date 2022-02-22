package br.com.letscode.todolist.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
public class Comment{
    @Id
    @GeneratedValue
    private Integer id;
    private Date createdAt;
    private String text;
}
