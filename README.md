LMS/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── lms/
│       │           ├── controller/
│       │           │   ├── LoginServlet.java
│       │           │   ├── LogoutServlet.java
│       │           │   ├── AdminServlet.java
│       │           │   ├── AddUserServlet.java
│       │           │   ├── DeleteUserServlet.java
│       │           │   ├── UpdateUserServlet.java
│       │           │   ├── CreateCourseServlet.java
│       │           │   ├── InstructorCoursesServlet.java
│       │           │   ├── AdminCourseServlet.java
│       │           │   ├── ApproveCourseServlet.java
│       │           │   ├── RejectCourseServlet.java
│       │           │   ├── StudentCoursesServlet.java
│       │           │   ├── EnrollCourseServlet.java
│       │           │   └── StudentProgressServlet.java
│       │           │
│       │           ├── dao/
│       │           │   ├── UserDAO.java
│       │           │   ├── CourseDAO.java
│       │           │   ├── EnrollmentDAO.java
│       │           │   └── ProgressDAO.java
│       │           │
│       │           ├── model/
│       │           │   ├── User.java
│       │           │   ├── Course.java
│       │           │   ├── Enrollment.java
│       │           │   └── Progress.java
│       │           │
│       │           ├── util/
│       │           │   └── DBConnection.java
│       │           │
│       │           └── filter/
│       │               └── AuthFilter.java
│       │
│       └── webapp/
│           ├── login.jsp
│           ├── adminDashboard.jsp
│           ├── instructorDashboard.jsp
│           ├── studentDashboard.jsp
│           ├── adminCourses.jsp
│           ├── createCourse.jsp
│           ├── editUser.jsp
│           ├── addUser.jsp
│           ├── studentCourses.jsp
│           ├── studentEnrolledCourses.jsp
│           ├── studentProgress.jsp
│           │
│           └── WEB-INF/
│               └── web.xml
│
└── README.md
