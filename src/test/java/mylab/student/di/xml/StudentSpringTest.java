package mylab.student.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {

    @Autowired
    private Course course;

    @Autowired
    private GradeService gradeService;

    // Course 테스트
    @Test
    public void testCourse() {

        assertNotNull(course);

        // 학생 수 3
        assertEquals(3, course.getStudents().size());

        // course 이름
        assertEquals("Spring Framework", course.getCourseName());

        // 학생 이름
        assertEquals("홍길동", course.getStudents().get(0).getName());
        
        System.out.println(course.toString());
    }

    // GradeService Bean 테스트
    @Test
    public void testGradeService() {

        assertNotNull(gradeService);

        // Course 주입 검증
        assertNotNull(gradeService.getCourse());

        // 80점 이상 2명
        assertEquals(2, gradeService.getHighScoreStudents(80).size());

        // 등급
        assertEquals("A", gradeService.calculateGrade("S001"));

        assertEquals("B", gradeService.calculateGrade("S002"));

        assertEquals("C", gradeService.calculateGrade("S003"));
        
        System.out.println(gradeService.toString());
    }
}
