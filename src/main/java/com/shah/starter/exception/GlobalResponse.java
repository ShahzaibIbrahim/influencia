package com.shah.starter.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GlobalResponse {

    private String message;
    private LocalDateTime dateTime = LocalDateTime.now();
    private List<String> violations;
    private Object data;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public List<String> getViolations() {
        if(violations== null) {
            violations = new ArrayList<>();
        }

        return violations;
    }

    public void setViolations(List<String> violations) {
        this.violations = violations;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
