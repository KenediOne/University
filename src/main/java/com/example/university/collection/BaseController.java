package com.example.university.collection;

public abstract class BaseController {

    //It's api of application
    public static final String API = "/api/university";

    //It's list of students
    public static final String STUDENTS = API +"/students";
    public static final String STUDENTS_ALL = STUDENTS +"/all";

    //It's list of lectures
    public static final String LECTURES = API + "/lectures";
    public static final String LECTURES_ALL = LECTURES + "/all";

    //It's list of teachers
    public static final String TEACHERS = API + "/teachers";
    public static final String TEACHERS_ALL = TEACHERS + "/all";

    //It's list of auditory
    public static final String AUDITORY = API + "/auditory";
    public static final String AUDITORY_ALL = AUDITORY + "/all";

}
