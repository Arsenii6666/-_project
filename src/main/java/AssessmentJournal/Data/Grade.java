package AssessmentJournal.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "grades")
public class Grade {

    @Id
    private String id;

    @Field("client_profile_id")
    private String clientProfileId;

    @Field("course_id")
    private String courseId;

    @Field("grade")
    private float grade;

    @Field("test_id")
    private String testId;
}