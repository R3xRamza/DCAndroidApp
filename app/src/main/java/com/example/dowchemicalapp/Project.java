package com.example.dowchemicalapp;

public class Project {

    private String[] name;
    private String[] creator;
    private String[] description;
    private String[] coworkers;
    private String[] email;
    private String[] dateSubmitted;
    private String[] completionStatus;
    private String[] dateAssigned;

        // Constructor
        public Project(String[] name, String[] creator, String[] description, String[] coworkers, String[] email, String[] dateSubmitted, String[] dateAssigned, String[] completionStatus) {
            this.name = name;
            this.creator = creator;
            this.description = description;
            this.coworkers = coworkers;
            this.email = email;
            this.dateSubmitted = dateSubmitted;
            this.completionStatus = completionStatus;
            this.dateAssigned = dateAssigned;
        }

        // Getter and Setter methods

        public String[] getName() {
            return this.name;
        }

        public void setName(String[] name) {
            this.name = name;
        }

        public String[] getCreator() {
            return this.creator;
        }

        public void setCreator(String[] creator) {
            this.creator = creator;
        }

        public String[] getDescription() {
            return this.description;
        }

        public void setDescription(String[] description) {
            this.description = description;
        }

        public String[] getCoworkers() {
            return this.coworkers;
        }

        public void setCoworkers(String[] coworkers) {
            this.coworkers = coworkers;
        }

        public String[] getEmail() {
            return this.email;
        }

        public void setEmail(String[] email) {
            this.email = email;
        }

        public String[] getDateSubmitted() {
            return this.dateSubmitted;
        }

        public void setDateSubmitted(String[] dateSubmitted) {
            this.dateSubmitted = dateSubmitted;
        }

        public String[] getCompletionStatus() {
            return this.completionStatus;
        }

        public void setCompletionStatus(String[] completionStatus) {
            this.completionStatus = completionStatus;
        }

        public String[] getDateAssigned() {
        return this.dateAssigned;
    }

        public void setDateAssigned(String[] dateAssigned) {
        this.dateAssigned = dateAssigned;
    }
    }


