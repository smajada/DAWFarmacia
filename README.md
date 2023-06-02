# DAWFarmacia
This project focuses on the creation of a web application that allows the registration and tracking of doctors and patients, as well as the control of the chips used and information related to medicines and expiry dates. The system consists of a frontend and a backend, developed using specific technologies.


## Key Features

-   Registration and authentication of doctors
-   Display of tables with patient chips
-   Detailed information about medications and expiration dates
-   Form-based chip registration functionality


## Project Structure

The project is organized as follows:

-   `frontend`: Folder containing files related to the frontend of the application.
    
    -   `css`: CSS files used for application design and styling.
    -   `js`: JavaScript files used for interactive functionality.
    -   `img`: Images used in the user interface.
-   `backend`: Folder containing files related to the backend of the application.
    
    -   `src`: Folder containing the backend source code.
        -   `BBDDFarmacia.java`: Class representing the management of the pharmacy database.
        -   `Doctor.java`: Class representing a doctor in the system.
        -   `Login.java`: Class handling user authentication.
        -   `Medicine.java`: Class representing a medication.
        -   `Patient.java`: Class representing a patient in the system.
        -   `Person.java`: Base class containing attributes and methods common to both doctors and patients.
        -   `Release.java`: Class managing medication expiration dates.
        -   `ServePatients.java`: Class responsible for serving patient tables.
        -   `ServeXips.java`: Class responsible for serving chips.
        -   `ServMedicines.java`: Class managing medications.
        -   `Xips.java`: Class representing a chip.
-   `DAWFarmacia`: Folder containing the DDL file of the project and directories for both the backend and frontend.
    
    -   `DAWFarmacia`: Folder containing the backend files.
    -   `Frontend`: Folder containing the frontend files.

## Technologies Used

-   **Frontend**: The frontend of the application has been developed using HTML, CSS, and JavaScript to create an attractive and user-friendly interface.
    
-   **Backend**: The backend of the application has been entirely built using Java, utilizing different classes to represent system objects and handle logical operations.
    
-   **Database**: MySQL is used as the database to store information about doctors, patients, chips, and medications. The backend code connects to the database for performing read and write operations.

## Development Environment Setup

To set up the development environment and run the application, follow these steps:

1.  Clone the project repository from [here](https://github.com/smajada/DAWFarmacia.git).
    
2.  Install the necessary dependencies for both frontend and backend. Make sure you have [Tomcat](https://tomcat.apache.org/download-90.cgi) and [MySQL](https://dev.mysql.com/downloads/connector/j/) installed.
    
3.  Configure the MySQL database by running the DDL script located in the `DAWFarmacia` folder.
    
4.  Start the backend server by running the Tomcat server.
    
5.  Open the `index.html` file located in the `frontend` folder in your web browser to access the application.