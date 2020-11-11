package com.netcracker.hwapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private long taskId;

    private String title;

    private String description;

    private boolean done;

    private Date createdAt;
}
