package br.com.letscode.todolist.model;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;



@Entity
@Builder
@NoArgsConstructor
public class Task {
        @Id @GeneratedValue
        private Integer id;
        private String title;
        private String description;
        private State state;
        private Date createdAt;
        private Date updateA;
        @OneToMany
        private Collection<Comment> comments;
}
