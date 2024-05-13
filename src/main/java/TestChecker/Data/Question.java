package TestChecker.Data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String questionText;

    @Column(nullable = false)
    private Boolean answer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "test_id")
    private Test test;

    public Question(String questionText, Boolean answer, Test test) {
        this.questionText = questionText;
        this.answer = answer;
    }
}
