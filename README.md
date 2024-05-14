### Passwords:
1) Postgres : AlwNbzQSlcHq0nXgsL5MW00U49uTRPgi
2) Mongo : wCJnTU5gLuJbPGEB

# Assessment Journal


**Description:**  
This controller manages endpoints related to assessment journals.

**Endpoints:**
- **POST /grades/submit-grade**
    - *Description:* Submit a grade.
    - *Request Body:* Grade object.
    - *Response:* Success message or error.

- **GET /grades/{grade_id}**
    - *Description:* Get grade by ID.
    - *Path Parameters:*
        - grade_id: ID of the grade.
    - *Response:* Grade object or error.

## Classroom Login

**Description:**  
This controller handles user authentication and course management.

**Endpoints:**
- **POST /new-user**
    - *Description:* Create a new user.
    - *Request Body:* User details.
    - *Response:* Success message or error.

- **GET /get-user**
    - *Description:* Get user profile.
    - *Query Parameters:*
        - login: User login.
        - password: User password.
    - *Response:* User profile or error.

- **POST /create-course**
    - *Description:* Create a new course.
    - *Request Body:* Course details.
    - *Response:* Success message or error.

- **POST /add-to-course**
    - *Description:* Add user to a course.
    - *Request Body:* User and course details.
    - *Response:* Success message or error.

- **GET /get-course/{courseName}**
    - *Description:* Get course by name.
    - *Path Parameters:*
        - courseName: Name of the course.
    - *Response:* Course details or error.

## Gateway

**Description:**  
This controller acts as a gateway for external services.

**Endpoints:**
- **POST /new-user**
    - *Description:* Forward request to create a new user.
    - *Request Body:* User details.
    - *Response:* Response from ClassroomLogin service.

- **GET /get-user**
    - *Description:* Forward request to get user profile.
    - *Response:* Response from ClassroomLogin service.

- **POST /create-course**
    - *Description:* Forward request to create a new course.
    - *Request Body:* Course details.
    - *Response:* Response from ClassroomLogin service.

- **POST /add-to-course**
    - *Description:* Forward request to add user to a course.
    - *Request Body:* User and course details.
    - *Response:* Response from ClassroomLogin service.

- **GET /get-course/{courseName}**
    - *Description:* Forward request to get course details.
    - *Path Parameters:*
        - courseName: Name of the course.
    - *Response:* Response from ClassroomLogin service.

## Test Checker

**Description:**  
This controller manages endpoints related to tests and test submissions.

**Endpoints:**
- **POST /tests/create**
    - *Description:* Create a new test.
    - *Request Body:* Test details.
    - *Response:* Created test object.

- **GET /tests/{id}**
    - *Description:* Get test by ID.
    - *Path Parameters:*
        - id: ID of the test.
    - *Response:* Test object or error.

- **POST /tests/submit/{origin_id}**
    - *Description:* Submit a test.
    - *Path Parameters:*
        - origin_id: ID of the original test.
    - *Request Body:* Test submission details.
    - *Response:* Grade object or error.
