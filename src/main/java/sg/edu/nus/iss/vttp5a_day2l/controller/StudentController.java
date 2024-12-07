package sg.edu.nus.iss.vttp5a_day2l.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5a_day2l.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
    
    List<Student> students;

    public StudentController() {
        students = new ArrayList<>();
    }

    
    @GetMapping("/allStudents")
    public String studentListing(Model model) throws ParseException {
        
        //convert a date string to epoch(long)
        String dob = "18 Dec 1975 10:25:00.000 SGT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS zzz");
        Date dDob = sdf.parse(dob);
        Long epochDob = dDob.getTime();

        Student s1 = new Student(1, "Damien", "Jennings",
        epochDob, "damienj@nus.edu.sg", "25 HMKT 119615");
        students.add(s1);

        Student s2 = new Student(2, "Damien", "Cummings",
        epochDob, "damienc@nus.edu.sg", "25 HMKT 119615");
        students.add(s2);

        Student s3 = new Student(3, "Damien", "Leggings",
        epochDob, "damienl@nus.edu.sg", "25 HMKT 119615");
        students.add(s3);

        // convert epoch Long to Date
        /* Long epochTime = 188103300000L;
         * Date dTime = new Date(epochTime);
         * String formattedTime = sdf.format(dTime);
         * System.out.println(formattedTime);
         */

        model.addAttribute("students", students);
        return "studentList";
    }
}
