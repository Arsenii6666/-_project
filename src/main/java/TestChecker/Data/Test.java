package TestChecker.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import AssessmentJournal.Data.Grade;

import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tests")
public class Test implements Externalizable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private List<Question> questions;

    public Test(List<Question> aQuestions) {
        this.questions = aQuestions;
    }

    @Column(nullable = false)
    private Long originId;

    public Grade evaluate(Test test) {
        return new Grade();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(id);
        out.writeObject(questions);
        out.writeObject(originId);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = (Long) in.readObject();
        questions = (List<Question>) in.readObject();
        originId = (Long) in.readObject();
    }
}
