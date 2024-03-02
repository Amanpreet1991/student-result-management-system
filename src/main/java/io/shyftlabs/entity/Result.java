package io.shyftlabs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Score score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    public Result() {
    }

    public Result(Long id, Score score, Student student, Course course) {
        this.id = id;
        this.score = score;
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "score", nullable = false)
    @Access(AccessType.PROPERTY)
    public String getScoreAsString() {
        return score == null ? null : score.toString();
    }

    @Column(name = "score", nullable = false)
    @Access(AccessType.PROPERTY)
    public void setScoreAsString(String score) {
        this.score = Score.value(score);
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
