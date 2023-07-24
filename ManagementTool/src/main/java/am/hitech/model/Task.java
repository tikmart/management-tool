package am.hitech.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "task")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "creator_id")
    private int creatorId; //user_id

    private int asignee; //user_id

    private String summary;

    @Column(name = "dsc")
    private String description;

    private String status;

    private String priority;

    private int progress;

    @Column(name = "created_date")
    private int createdDate;

    @Column(name = "due_date")
    private int dueDate;

    @Column(name = "estimated_time")
    private int estimatedTime;

    @Column(name = "project_id")
    private int projectId;




}
