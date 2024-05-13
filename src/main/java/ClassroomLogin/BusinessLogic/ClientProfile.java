package ClassroomLogin.BusinessLogic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class ClientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column
    private String institution;

    @Column(nullable = false)
    private String position;
    
    @Column
    
    private String status;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<Course> courses;

    public ClientProfile(String login, String password, String fullName, String institution, String status, String position) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.position = position;
        this.institution = institution;
        this.status = status;
    }
}
