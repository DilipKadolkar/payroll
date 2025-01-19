//package com.example.payroll;
//
//
//import com.example.payroll.controller.EmployeeController;
//import com.example.payroll.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//
//@WebMvcTest(EmployeeController.class)
//class EmployeeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EmployeeService employeeService;
//
//    @Test
//    void testCreateEmployee() throws Exception {
//        // Create a mock Employee object
//        Employee mockEmployee = new Employee();
//        mockEmployee.setEmployeeID(1);
//        mockEmployee.setFirstName("John");
//        mockEmployee.setLastName("Doe");
//        mockEmployee.setEmail("john.doe@example.com");
//        mockEmployee.setPhoneNumber("1234567890");
//        mockEmployee.setJobTitle("Developer");
//        mockEmployee.setDepartment("IT");
//
//        // Mock the service call
//        Mockito.when(employeeService.saveEmployee(any(Employee.class))).thenReturn(mockEmployee);
//
//        // JSON input for the POST request
//        String employeeJson = """
//                {
//                    "firstName": "John",
//                    "lastName": "Doe",
//                    "email": "john.doe@example.com",
//                    "phoneNumber": "1234567890",
//                    "jobTitle": "Developer",
//                    "department": "IT"
//                }
//                """;
//
//        // Perform the POST request and assert the result
//        mockMvc.perform(post("/api/employees") // Endpoint
//                        .contentType(MediaType.APPLICATION_JSON) // Set content type to JSON
//                        .content(employeeJson)) // Provide JSON input
//                .andExpect(status().isOk()) // Assert response status is 200 OK
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Assert response type
//                .andExpect(content().json("""
//                        {
//                            "employeeID": 1,
//                            "firstName": "John",
//                            "lastName": "Doe",
//                            "email": "john.doe@example.com",
//                            "phoneNumber": "1234567890",
//                            "jobTitle": "Developer",
//                            "department": "IT"
//                        }
//                        """)); // Assert returned JSON matches the mock response
//    }
//}
//
